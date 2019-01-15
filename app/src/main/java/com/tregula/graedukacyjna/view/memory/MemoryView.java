package com.tregula.graedukacyjna.view.memory;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.GridLayout;

import com.tregula.graedukacyjna.R;

public class MemoryView extends GridLayout {

    private Button memory1;
    private Button memory2;
    private Button memory3;
    private Button memory4;
    private Button memory5;
    private Button memory6;
    private Button memory7;
    private Button memory8;
    private Button memory9;
    private Button memory10;
    private Button memory11;
    private Button memory12;
    private Button memory13;
    private Button memory14;
    private Button memory15;
    private Button memory16;
    private Button memory17;
    private Button memory18;


    public MemoryView(Context context) {
        super(context);
        init(context);
    }

    public MemoryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MemoryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context){
        inflate(context, R.layout.memory_view,this);
        memory1= findViewById(R.id.memory1);
        memory2= findViewById(R.id.memory2);
        memory3= findViewById(R.id.memory3);
        memory4= findViewById(R.id.memory4);
        memory5= findViewById(R.id.memory5);
        memory6= findViewById(R.id.memory6);
        memory7= findViewById(R.id.memory7);
        memory8= findViewById(R.id.memory8);
        memory9= findViewById(R.id.memory9);
        memory10= findViewById(R.id.memory10);
        memory11= findViewById(R.id.memory11);
        memory12= findViewById(R.id.memory12);
        memory13= findViewById(R.id.memory13);
        memory14= findViewById(R.id.memory14);
        memory15= findViewById(R.id.memory15);
        memory16= findViewById(R.id.memory16);
        memory17= findViewById(R.id.memory17);
        memory18= findViewById(R.id.memory18);
    }


}
