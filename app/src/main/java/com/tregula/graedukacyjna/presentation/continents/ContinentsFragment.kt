package com.tregula.graedukacyjna.presentation.continents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.base.InjectedFragment
import com.tregula.graedukacyjna.domain.data.mode.Mode
import com.tregula.graedukacyjna.navigation.Navigator
import com.tregula.graedukacyjna.view.continents.ContinentsView
import javax.inject.Inject

class ContinentsFragment : InjectedFragment() {

    companion object {
        private const val ARG_MODE = "arg_mode"

        fun newInstance(mode: Mode): ContinentsFragment {
            val bundle = Bundle().apply {
                putSerializable(ARG_MODE, mode)
            }

            return ContinentsFragment().apply {
                arguments = bundle
            }
        }
    }

    private lateinit var continentsView: ContinentsView
    private lateinit var mode: Mode

    @Inject
    lateinit var navigator: Navigator<Fragment>
    @Inject
    lateinit var presenter: ContinentsContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_continents, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        continentsView = view.findViewById(R.id.continents_container)

        presenter.attach(continentsView)
        continentsView.onContinentClick = { continent ->
            presenter.onContinentChosen(continent, mode)
        }
        continentsView.onNavigationBack = {
            navigator.handleOnBackPress()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mode = arguments?.getSerializable(ARG_MODE) as Mode
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }
}