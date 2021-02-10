package com.example.mapsandlocations

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    val locationmanager by lazy {
        getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            999->
                if (grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                setUpLocationListener()
                }else
                Toast.makeText(this,"not connected",Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("MissingPermission")
    private fun setUpLocationListener(){
        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        val locationRequest = LocationRequest()
                .setInterval(2000) //2 seconds
                .setFastestInterval(2000)
                .setSmallestDisplacement(1f)
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)

        fusedLocationProviderClient.requestLocationUpdates(locationRequest,
        object : LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult?) {
                super.onLocationResult(locationResult)
                for(location in locationResult?.locations!!){
                    val Current = LatLng(location.latitude,location.longitude)
                    if (::mMap.isInitialized)
                    {
                        //val Current = LatLng(it.latitude, it.longitude)
                        mMap.addMarker(MarkerOptions().position(Current).title("Marker on Location"))
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(Current))

                    }
                }
            }
        },
                Looper.myLooper()
        )

    }

   // @SuppressLint("MissingPermission")
   /* private fun setUpLocationListener(){
       // val lm =getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val providers = locationmanager .getProviders(true)

        var l : Location? = null
        for (i in providers.indices.reversed()){
            l= locationmanager.getLastKnownLocation(providers[i])
            if (l!=null) break
        }

        l?.let {
            if (::mMap.isInitialized)
            {
                val Current = LatLng(it.latitude, it.longitude)
                mMap.addMarker(MarkerOptions().position(Current).title("Marker on Location"))
                mMap.moveCamera(CameraUpdateFactory.newLatLng(Current))

            }
        }

    }*/

    fun isfinelocationgranted (): Boolean{
        return checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    override fun onStart() {
        requestaccesfinelocation()
        super.onStart()
        when{
            isfinelocationgranted()->{
                when{
                    isLocationEnabled()->setUpLocationListener()
                    else
                        ->showGpsNotEnabledDialog()
                }
               //setUpLocationListener()
            }
            else
                ->requestaccesfinelocation()

        }
    }
    fun isLocationEnabled():Boolean{
        return  locationmanager.isProviderEnabled(LocationManager.GPS_PROVIDER)||
                locationmanager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    fun showGpsNotEnabledDialog() {
        AlertDialog.Builder(this).setTitle("Enabled Gps")
                .setMessage("enabled by user")
                .setCancelable(false)
                .setPositiveButton("ENABLE NOW") { dialogInterface: DialogInterface, i: Int ->
                    startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                    dialogInterface.dismiss()
                }.show()
    }

    private fun requestaccesfinelocation() {
        this.requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),999
        )

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.apply {
            isZoomControlsEnabled=true
            isZoomGesturesEnabled=true
            isMyLocationButtonEnabled=true
            isCompassEnabled=true
        }
        mMap.setMaxZoomPreference(14f)  //0f to 22f
        val sydney = LatLng(-34.0, 151.0)
        mMap.addPolyline(PolylineOptions().add(sydney,LatLng(20.2,78.99)).color(ContextCompat.getColor(baseContext,R.color.design_default_color_primary))).width=2f
        mMap.addMarker(MarkerOptions().position(LatLng(20.2,78.99)).title("Destination"))
        // Add a marker in Sydney and move the camera

        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}