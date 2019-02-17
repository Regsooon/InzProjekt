package com.tregula.graedukacyjna.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.base.InjectedFragment
import com.tregula.graedukacyjna.domain.database.entity.Location
import com.tregula.graedukacyjna.domain.view.AreaDetail
import com.tregula.graedukacyjna.domain.view.CountryDetail
import com.tregula.graedukacyjna.domain.view.ExternalLink
import com.tregula.graedukacyjna.navigation.GameNavigation
import com.tregula.graedukacyjna.presentation.map.MapFragment
import com.tregula.graedukacyjna.view.countries.CountryDetailView
import javax.inject.Inject

class AreaDetailFragment : InjectedFragment() {

    private lateinit var countryName: String
    private lateinit var countryUrl: String
    private lateinit var capitolLocation: Location
    private lateinit var capitolName: String
    private lateinit var capitolUrl: String

    private lateinit var countryDetail: CountryDetailView
    private lateinit var mapContainer: FrameLayout
    private lateinit var toolbar: Toolbar

    @Inject
    lateinit var gameNavigation: GameNavigation

    companion object {
        private const val ARG_COUNTRY_NAME = "arg_country_name"
        private const val ARG_COUNTRY_URL = "arg_country_url"
        private const val ARG_CAPITOL_NAME = "arg_capitol_name"
        private const val ARG_CAPITOL_URL = "arg_capitol_url"
        private const val ARG_CAPITOL_LOCATION = "arg_location"

        fun newInstance(areaDetail: AreaDetail): AreaDetailFragment {
            val bundle = Bundle().apply {
                putString(ARG_COUNTRY_NAME, areaDetail.countryName)
                putString(ARG_COUNTRY_URL, areaDetail.countryUrl)
                putString(ARG_CAPITOL_NAME, areaDetail.capitolName)
                putString(ARG_CAPITOL_URL, areaDetail.capitolUrl)
                putParcelable(ARG_CAPITOL_LOCATION, areaDetail.capitolLocation)
            }

            return AreaDetailFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countryName = arguments?.getString(ARG_COUNTRY_NAME).orEmpty()
        countryUrl = arguments?.getString(ARG_COUNTRY_URL).orEmpty()
        capitolLocation = arguments?.getParcelable(ARG_CAPITOL_LOCATION) ?: Location.DEFAULT
        capitolName = arguments?.getString(ARG_CAPITOL_NAME).orEmpty()
        capitolUrl = arguments?.getString(ARG_CAPITOL_URL).orEmpty()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_area_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryDetail = view.findViewById(R.id.country_detail)
        mapContainer = view.findViewById(R.id.map_container)
        toolbar = view.findViewById(R.id.toolbar)
        toolbar.title = getString(R.string.details_for, countryName)

        childFragmentManager.beginTransaction()
                .replace(R.id.map_container, MapFragment.newInstance(getString(R.string.capitol, capitolName), capitolLocation))
                .commitAllowingStateLoss()

        toolbar.setNavigationOnClickListener {
            gameNavigation.handleOnBackPress()
        }

        val countryData = CountryDetail(countryName, countryUrl, capitolName, capitolUrl)
        countryDetail.setData(countryData) { url, title ->
            gameNavigation.openWebBrowser(ExternalLink(url, title))
        }
    }

}