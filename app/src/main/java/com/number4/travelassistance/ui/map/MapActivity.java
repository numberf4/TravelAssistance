package com.number4.travelassistance.ui.map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.number4.travelassistance.R;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final String TAG = "TAG";
    private String apiKey ="AIzaSyDBHnz3DrH0ptZcFDJ5YaDPOSoyB5N9Y1A";
    private GoogleMap googleMap;
    private Boolean mLocationPermissions = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap gMap) {
        googleMap=gMap;
        LatLng hvktmm = new LatLng(20.981082, 105.796218);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hvktmm,17));
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions()
                .position(hvktmm)
                .title("Marker in Sydney"));
        }

}