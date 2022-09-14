package com.hadyahmed00.wander

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import com.hadyahmed00.wander.databinding.ActivityMapsBinding
import java.util.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val REQUEST_LOCATION_PERMISSION = 1


    private val TAG = MapsActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.maps_type, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.hyberid_map -> {
                map.mapType = GoogleMap.MAP_TYPE_HYBRID

            }
            R.id.normal -> {
                map.mapType = GoogleMap.MAP_TYPE_NORMAL


            }
            R.id.satellite_map -> {
                map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            }
            R.id.terrain_map -> {
                map.mapType = GoogleMap.MAP_TYPE_TERRAIN

            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
        return true

    }


    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val latitude = 30.097613
        val longitude = 31.265958
        val latLng = LatLng(latitude, longitude)
        val zoom = 15f
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom))
        map.addMarker(MarkerOptions().position(latLng))
        mapLongClick(map)
        mapPoiClick(map)
        mapStyle(map)
        enableMyLocation()
    }

    private fun mapLongClick(map: GoogleMap) {
        map.setOnMapLongClickListener {
            val snippet = String.format(
                Locale.getDefault(),
                """the longitude is %1$.5f,the latitude is %2$.5f""", it.longitude, it.latitude
            )
            map.addMarker(MarkerOptions().position(it).title("Dropped Pin").snippet(snippet).icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
        }
    }

    private fun mapPoiClick(map: GoogleMap) {
        map.setOnPoiClickListener {
            val poi = map.addMarker(MarkerOptions().position(it.latLng).title(it.name))
            poi?.showInfoWindow()
        }

    }

    private fun mapStyle(map:GoogleMap){

        try {
            map.setMapStyle(MapStyleOptions.loadRawResourceStyle(this,R.raw.map_style))

        }
        catch (e:Exception)
        {
            Log.e(TAG, "Style parsing failed.")

        }
    }

    private fun enableMyLocation() {
        if (isPermissionGranted()) {

            map.isMyLocationEnabled = true
        }
        else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }
    private fun isPermissionGranted():Boolean{
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)=== PackageManager.PERMISSION_GRANTED

    }
}