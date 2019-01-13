package com.tregula.graedukacyjna;

import android.os.Bundle;

import com.tregula.graedukacyjna.question.QuestionFragment;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new QuestionFragment())
                .commitAllowingStateLoss();
    }
}
