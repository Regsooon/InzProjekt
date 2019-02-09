package com.tregula.graedukacyjna.concurrent.action

import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.moshi.Moshi
import com.tregula.graedukacyjna.domain.remote.ContinentsJson
import io.reactivex.Single
import io.reactivex.SingleEmitter
import javax.inject.Inject

class FetchContinentsData @Inject constructor(private val storage: FirebaseStorage,
                                              private val moshi: Moshi) {

    companion object {

        private const val FILE_REFERENCE = "game_data.json"
        private const val MEGABYTE = (1024 * 1024).toLong()
        private const val DELAY = 100L
    }

    fun execute(): Single<ContinentsJson> {
        return Single.create { emitter ->
            val storageReference = storage.reference
            val jsonReference = storageReference.child(FILE_REFERENCE)
            fetchJson(emitter, jsonReference)
        }
    }

    private fun fetchJson(emitter: SingleEmitter<ContinentsJson>, jsonReference: StorageReference) {
        val task = jsonReference.getBytes(MEGABYTE)
        while (task.isComplete.not()) {
            Thread.sleep(DELAY)
        }

        if (task.isSuccessful) {
            task.result?.let { bytes ->
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
        } else {
            task.exception?.let { throwable ->
                emitter.onError(throwable)
            }
        }
    }
}
