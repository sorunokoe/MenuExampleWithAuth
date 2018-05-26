package com.kitestart.menuexample.Controller;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kitestart.menuexample.R;

public class UserMapActivity extends FragmentActivity implements OnMapReadyCallback {

    static String name, status;
    static Double lat, lon;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if(!UserMapActivity.name.isEmpty() && !UserMapActivity.status.isEmpty()
                && !UserMapActivity.lon.toString().isEmpty() && !UserMapActivity.lat.toString().isEmpty()) {

            LatLng someplace = new LatLng(UserMapActivity.lat, UserMapActivity.lon);
            MarkerOptions option = new MarkerOptions();
            option.position(someplace);
            option.title(UserMapActivity.name);
            option.snippet(UserMapActivity.status);
            mMap.addMarker(option);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(someplace));
        }
    }
}
