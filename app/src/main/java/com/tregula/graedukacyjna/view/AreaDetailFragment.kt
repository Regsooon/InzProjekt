package com.tregula.graedukacyjna.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.base.InjectedFragment
import com.tregula.graedukacyjna.domain.database.entity.Location
import com.tregula.graedukacyjna.domain.view.AreaDetail
import com.tregula.graedukacyjna.domain.view.ExternalLink
import com.tregula.graedukacyjna.navigation.GameNavigation
import com.tregula.graedukacyjna.presentation.map.MapFragment
import javax.inject.Inject

class AreaDetailFragment : InjectedFragment() {

    private lateinit var title: String
    private lateinit var url: String
    private lateinit var location: Location

    private lateinit var areaName: TextView
    private lateinit var mapContainer: FrameLayout
    private lateinit var toolbar: Toolbar

    @Inject
    lateinit var gameNavigation: GameNavigation

    companion object {
        private const val ARG_TITLE = "arg_title"
        private const val ARG_URL = "arg_url"
        private const val ARG_LOCATION = "arg_location"

        fun newInstance(areaDetail: AreaDetail): AreaDetailFragment {
            val bundle = Bundle().apply {
                putString(ARG_TITLE, areaDetail.title)
                putString(ARG_URL, areaDetail.url)
                putParcelable(ARG_LOCATION, areaDetail.location)
            }

            return AreaDetailFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString(ARG_TITLE).orEmpty()
        url = arguments?.getString(ARG_URL).orEmpty()
        location = arguments?.getParcelable(ARG_LOCATION) ?: Location.DEFAULT
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_area_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        areaName = view.findViewById(R.id.area_name)
        mapContainer = view.findViewById(R.id.map_container)
        toolbar = view.findViewById(R.id.toolbar)

        childFragmentManager.beginTransaction()
            .replace(R.id.map_container, MapFragment.newInstance(title, location))
            .commitAllowingStateLoss()
        areaName.text = title
        areaName.setOnClickListener {
            gameNavigation.openWebBrowser(ExternalLink(url, title))
        }

        toolbar.setNavigationOnClickListener {
            gameNavigation.handleOnBackPress()
        }
    }

}