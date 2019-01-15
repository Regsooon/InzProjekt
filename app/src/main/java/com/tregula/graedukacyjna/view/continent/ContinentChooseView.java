package com.tregula.graedukacyjna.view.continent;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;

import com.tregula.graedukacyjna.R;

import androidx.annotation.Nullable;

public class ContinentChooseView extends LinearLayout {

    private Button europe_button;
    private Button africa_button;
    private Button asia_button;
    private Button americaPln_button;
    private Button americaPld_button;
    private Button australia_button;

    public ContinentChooseView(Context context) {
        super(context);
        init(context);
    }

    public ContinentChooseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ContinentChooseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context)
    {
        inflate( context, R.layout.continent_choose_view, this);
        europe_button= findViewById(R.id.europe_button);
        africa_button= findViewById(R.id.africa_button);
        asia_button= findViewById(R.id.asia_button);
        americaPln_button= findViewById(R.id.americaPln_button);
        americaPld_button= findViewById(R.id.americaPld_button);
        australia_button= findViewById(R.id.australia_button);

    }
}
