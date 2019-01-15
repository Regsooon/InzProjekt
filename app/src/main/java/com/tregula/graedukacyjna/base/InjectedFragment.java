package com.tregula.graedukacyjna.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;

public class InjectedFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }
}
