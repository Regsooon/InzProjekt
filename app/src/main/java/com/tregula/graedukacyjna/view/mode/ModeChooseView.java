package com.tregula.graedukacyjna.view.mode;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;

import com.tregula.graedukacyjna.R;

import androidx.annotation.Nullable;

public class ModeChooseView extends LinearLayout {

    private Button learn_mode_button;
    private Button test_mode_button;

    public ModeChooseView(Context context) {
        super(context);
        init(context);
    }

    public ModeChooseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ModeChooseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context){
        inflate(context, R.layout.mode_choose_view,this);
        learn_mode_button=findViewById(R.id.learn_mode_button);
        test_mode_button=findViewById(R.id.test_mode_button);

    }
}
