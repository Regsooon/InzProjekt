package com.tregula.graedukacyjna.view.memory

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.GridLayout

import com.tregula.graedukacyjna.R

class MemoryView : GridLayout {

    private lateinit var memory1: Button
    private lateinit var memory2: Button
    private lateinit var memory3: Button
    private lateinit var memory4: Button
    private lateinit var memory5: Button
    private lateinit var memory6: Button
    private lateinit var memory7: Button
    private lateinit var memory8: Button
    private lateinit var memory9: Button
    private lateinit var memory10: Button
    private lateinit var memory11: Button
    private lateinit var memory12: Button
    private lateinit var memory13: Button
    private lateinit var memory14: Button
    private lateinit var memory15: Button
    private lateinit var memory16: Button
    private lateinit var memory17: Button
    private lateinit var memory18: Button


    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        inflate(context, R.layout.memory_view, this)
        memory1 = findViewById(R.id.memory1)
        memory2 = findViewById(R.id.memory2)
        memory3 = findViewById(R.id.memory3)
        memory4 = findViewById(R.id.memory4)
        memory5 = findViewById(R.id.memory5)
        memory6 = findViewById(R.id.memory6)
        memory7 = findViewById(R.id.memory7)
        memory8 = findViewById(R.id.memory8)
        memory9 = findViewById(R.id.memory9)
        memory10 = findViewById(R.id.memory10)
        memory11 = findViewById(R.id.memory11)
        memory12 = findViewById(R.id.memory12)
        memory13 = findViewById(R.id.memory13)
        memory14 = findViewById(R.id.memory14)
        memory15 = findViewById(R.id.memory15)
        memory16 = findViewById(R.id.memory16)
        memory17 = findViewById(R.id.memory17)
        memory18 = findViewById(R.id.memory18)
    }


}
