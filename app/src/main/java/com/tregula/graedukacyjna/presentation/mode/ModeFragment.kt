package com.tregula.graedukacyjna.presentation.mode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.base.InjectedFragment
import com.tregula.graedukacyjna.navigation.GameNavigation
import javax.inject.Inject

class ModeFragment : InjectedFragment() {

    private lateinit var modeChooseView: ModeChooseView

    @Inject
    lateinit var gameNavigation: GameNavigation

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mode, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        modeChooseView = view.findViewById(R.id.mode_choose)
        setupListeners()
    }

    private fun setupListeners(){
        modeChooseView.learnMode.setOnClickListener {

        }
        modeChooseView.testMode.setOnClickListener {

        }
    }
}