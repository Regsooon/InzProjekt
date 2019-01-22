package com.tregula.graedukacyjna.view.map

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
        googleMap.addMarker(MarkerOptions().position(position).title(markerTitle))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(position))
    }
}
