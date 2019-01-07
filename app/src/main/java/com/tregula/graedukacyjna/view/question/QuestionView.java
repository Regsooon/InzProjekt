package com.tregula.graedukacyjna.view.question;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;

import com.tregula.graedukacyjna.R;

import androidx.annotation.Nullable;

public class QuestionView extends LinearLayout {

    private Button firstAnswear;
    private Button secondAnswear;
    private Button thirdAnswear;
    private Button forthAnswear;

    public QuestionView(Context context) {
        super(context);
        init(context);
    }

    public QuestionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public QuestionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        inflate(context, R.layout.question_view, this );
        firstAnswear = findViewById(R.id.first_answear);
        secondAnswear = findViewById(R.id.second_answear);
        thirdAnswear = findViewById(R.id.third_answear);
        forthAnswear = findViewById(R.id.forth_answear);
    }
}
