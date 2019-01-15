package com.tregula.graedukacyjna.question;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tregula.graedukacyjna.R;
import com.tregula.graedukacyjna.base.InjectedFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class QuestionFragment extends InjectedFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question_fragment, container, false);
    }
}
