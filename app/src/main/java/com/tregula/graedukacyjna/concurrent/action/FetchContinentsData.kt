package com.tregula.graedukacyjna.concurrent.action

import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.moshi.Moshi
import com.tregula.graedukacyjna.domain.remote.data.ContinentsJson
import io.reactivex.Single
import io.reactivex.SingleEmitter
import java.io.IOException
import javax.inject.Inject

class FetchContinentsData @Inject constructor(private val storage: FirebaseStorage,
                                              private val moshi: Moshi) {

    fun execute(): Single<ContinentsJson> {
        return Single.create { emitter ->
            val storageReference = storage.reference
            val jsonReference = storageReference.child(FILE_REFERENCE)
            fetchJsonFromServer(emitter, jsonReference)
        }
    }

    private fun fetchJsonFromServer(emitter: SingleEmitter<ContinentsJson>, jsonReference: StorageReference) {
        val task = jsonReference.getBytes(MEGABYTE)
        task.addOnSuccessListener { bytes ->
            try {
                val json = String(bytes)
                val continents = moshi.adapter(ContinentsJson::class.java)
                        .fromJson(json)
                if (continents != null) {
                    emitter.onSuccess(continents)
                } else {
                    emitter.onError(NullPointerException())
                }
            } catch (exception: Exception) {
                emitter.onError(exception)
            }
        }
        task.addOnFailureListener { exception -> emitter.onError(exception) }
    }

    companion object {

        private const val FILE_REFERENCE = "game_data.json"
        private const val MEGABYTE = (1024 * 1024).toLong()
    }
}
