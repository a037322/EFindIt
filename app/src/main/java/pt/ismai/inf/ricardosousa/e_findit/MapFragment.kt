package pt.ismai.inf.ricardosousa.e_findit

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import android.os.AsyncTask.execute
import android.location.Location
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng
import android.location.Address
import android.widget.SearchView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.IOException
import android.location.Geocoder
import android.view.KeyEvent


class MapFragment : Fragment() {

    private lateinit var mMap : GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_map, container, false)
        //val searchView = inflater.inflate(R.id.idSearchView, container, false)
        //val searchView = rootView.findViewById<SearchView>(R.id.idSearchView)
        val mapFragment = childFragmentManager.findFragmentById(R.id.fragment_map_container) as SupportMapFragment?
            mapFragment!!.getMapAsync { mMap ->
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL

                mMap.clear() //clear old markers
            /*
            val googlePlex = CameraPosition.builder()
                .target(LatLng(37.4219999, -122.0862462))
                .zoom(10f)
                .bearing(0f)
                .tilt(45f)
                .build()

            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10000, null)

            mMap.addMarker(
                MarkerOptions()
                    .position(LatLng(37.4219999, -122.0862462))
                    .title("Spider Man")
                    .icon(bitmapDescriptorFromVector(activity, R.drawable.ic_baseline_location_on_24))
            )

            mMap.addMarker(
                MarkerOptions()
                    .position(LatLng(37.4629101, -122.2449094))
                    .title("Iron Man")
                    .snippet("His Talent : Plenty of money")
            )

            mMap.addMarker(
                MarkerOptions()
                    .position(LatLng(37.3092293, -122.1136845))
                    .title("Captain America")
            )
            */
                /*
                searchView.setOnKeyListener(View.OnKeyListener { _, keyCode, keyevent ->
                    if (keyCode == KeyEvent.KEYCODE_ENTER && keyevent.action == KeyEvent.ACTION_UP) {
                        //dropMarker(searchView.toString())
                        searchView.setQuery("", false)
                        searchView.clearFocus()
                        return@OnKeyListener true
                    }
                    false
                })
                */
                /*
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String): Boolean {
                        // on below line we are getting the
                        // location name from search view.
                        val location = searchView.query.toString()

                        // below line is to create a list of address
                        // where we will store the list of all address.
                        var addressList: List<Address>? = null

                        // checking if the entered location is null or not.
                        if (location != null || location == "") {
                            // on below line we are creating and initializing a geo coder.
                            val geocoder = Geocoder(this@MapFragment)
                            try {
                                // on below line we are getting location from the
                                // location name and adding that location to address list.
                                addressList = geocoder.getFromLocationName(location, 1)
                            } catch (e: IOException) {
                                e.printStackTrace()
                            }
                            // on below line we are getting the location
                            // from our list a first position.
                            val address = addressList!![0]

                            // on below line we are creating a variable for our location
                            // where we will add our locations latitude and longitude.
                            val latLng = LatLng(address.latitude, address.longitude)

                            // on below line we are adding marker to that position.
                            mMap.addMarker(MarkerOptions().position(latLng).title(location))

                            // below line is to animate camera to that position.
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f))
                        }
                        return false
                    }

                    override fun onQueryTextChange(newText: String): Boolean {
                        return false
                    }
                })
                // at last we calling our map fragment to update.
                // at last we calling our map fragment to update.
                mapFragment.getMapAsync(this)
                */
            }



            return rootView
    }
    /*
    private fun bitmapDescriptorFromVector(context: Context?, vectorResId: Int): BitmapDescriptor {
        val vectorDrawable = ContextCompat.getDrawable(requireContext(), vectorResId)
        vectorDrawable!!.setBounds(0, 0, vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight)
        val bitmap =
            Bitmap.createBitmap(vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }*/
}