package com.tregula.graedukacyjna.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tregula.graedukacyjna.R;

import androidx.annotation.Nullable;

public class ScoreView extends LinearLayout {

    private TextView score_textView;

    public ScoreView(Context context) {
        super(context);
        init(context);
    }

    public ScoreView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ScoreView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init (Context context)
    {
        inflate( context, R.layout.score_view,this);
        score_textView = findViewById(R.id.score_textView);
    }
}
