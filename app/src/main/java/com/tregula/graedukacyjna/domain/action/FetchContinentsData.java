package com.tregula.graedukacyjna.domain.action;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.moshi.Moshi;
import com.tregula.graedukacyjna.domain.remote.ContinentsJson;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public class FetchContinentsData {

    private static final String FILE_REFERENCE = "game_data.json";
    private static final long MEGABYTE = 1024 * 1024;

    private final FirebaseStorage storage;
    private final Moshi moshi;

    @Inject
    public FetchContinentsData(FirebaseStorage storage, Moshi moshi) {
        this.storage = storage;
        this.moshi = moshi;
    }

    public Single<ContinentsJson> execute() {
        return Single.create(new SingleOnSubscribe<ContinentsJson>() {
            @Override
            public void subscribe(SingleEmitter<ContinentsJson> emitter) {
                StorageReference storageReference = storage.getReference();
                StorageReference jsonReference = storageReference.child(FILE_REFERENCE);
                fetchJsonFromServer(emitter, jsonReference);
            }
        });
    }

    private void fetchJsonFromServer(final SingleEmitter<ContinentsJson> emitter, StorageReference jsonReference) {
        Task<byte[]> task = jsonReference.getBytes(MEGABYTE);
        task.addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                try {
                    String json = new String(bytes, Charset.forName("UTF-8"));
                    ContinentsJson continents = moshi.adapter(ContinentsJson.class)
                            .fromJson(json);
                    emitter.onSuccess(continents);
                } catch (IOException exception) {
                    emitter.onError(exception);
                }
            }
        });
        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception exception) {
                emitter.onError(exception);
            }
        });
    }
}
