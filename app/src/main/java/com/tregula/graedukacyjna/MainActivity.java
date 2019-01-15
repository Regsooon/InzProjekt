package com.tregula.graedukacyjna;

import android.os.Bundle;

import com.tregula.graedukacyjna.base.InjectedActivity;
import com.tregula.graedukacyjna.question.QuestionFragment;

public class MainActivity extends InjectedActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new QuestionFragment())
                .commitAllowingStateLoss();
    }
}
