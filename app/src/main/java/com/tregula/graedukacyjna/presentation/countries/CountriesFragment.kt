package com.tregula.graedukacyjna.presentation.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.base.InjectedFragment
import com.tregula.graedukacyjna.domain.data.ContinentData
import com.tregula.graedukacyjna.navigation.GameNavigation
import com.tregula.graedukacyjna.view.countries.CountriesView
import javax.inject.Inject

class CountriesFragment : InjectedFragment() {

    companion object {
        private const val ARG_CONTINENT = "arg_continent"

        fun newInstance(continent: ContinentData): CountriesFragment {
            val bundle = Bundle().apply {
                putParcelable(ARG_CONTINENT, continent)
            }
            return CountriesFragment().apply {
                arguments = bundle
            }
        }
    }

    private lateinit var countriesContainer: CountriesView
    private var continent: ContinentData? = null

    @Inject
    lateinit var gameNavigation: GameNavigation

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countriesContainer = view.findViewById(R.id.container)
        countriesContainer.onNavigationBack = {
            gameNavigation.handleOnBackPress()
        }

        continent?.let {
            countriesContainer.displayCountries(it.countries)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        continent = arguments?.getParcelable(ARG_CONTINENT)
    }
}