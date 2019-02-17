package com.tregula.graedukacyjna.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.base.InjectedFragment
import com.tregula.graedukacyjna.navigation.Navigator
import com.tregula.graedukacyjna.presentation.continents.ContinentsFragment
import com.tregula.graedukacyjna.view.ScoreView
import javax.inject.Inject

class ScoreFragment : InjectedFragment() {

    companion object {
        private const val ARG_SCORE = "arg_score"

        fun newInstance(score: Int): ScoreFragment {
            val bundle = Bundle().apply {
                putInt(ARG_SCORE, score)
            }
            return ScoreFragment().apply {
                arguments = bundle
            }
        }
    }

    @Inject
    lateinit var navigator: Navigator<Fragment>

    private var score: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_score, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scoreView: ScoreView = view.findViewById(R.id.score_container)
        scoreView.onNavigateBack = {
            navigator.handleOnBackPress()
        }
        scoreView.setScore(score)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        score = arguments?.getInt(ARG_SCORE, 0) ?: 0
    }
}