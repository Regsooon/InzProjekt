package com.tregula.graedukacyjna.presentation.map

import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tregula.graedukacyjna.domain.database.entity.Location

class MapFragment : SupportMapFragment(), OnMapReadyCallback {

    companion object {
        private const val ZOOM_LEVEL = 7f
        private const val ARG_NAME = "arg_name"
        private const val ARG_LOCATION = "arg_location"

        fun newInstance(name: String, location: Location): MapFragment {
            val bundle = Bundle().apply {
                putString(ARG_NAME, name)
                putParcelable(ARG_LOCATION, location)
            }

            return MapFragment().apply {
                arguments = bundle
            }
        }
    }

    private lateinit var markerTitle: String
    private lateinit var location: Location

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        markerTitle = arguments?.getString(ARG_NAME) ?: ""
        location = arguments?.getParcelable(ARG_LOCATION) ?: Location.DEFAULT

        getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val position = LatLng(location.latitude, location.longitude)
        googleMap.apply {
            addMarker(MarkerOptions().position(position).title(markerTitle))
            moveCamera(CameraUpdateFactory.newLatLngZoom(position, ZOOM_LEVEL))
            uiSettings.isScrollGesturesEnabled = false
        }
    }
}
