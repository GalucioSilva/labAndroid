package com.soutosslave.listadepaises;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.soutosslave.listadepaises.Model.Country;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Country country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        //pega a country passada pela main
        country = (Country) getIntent().getSerializableExtra("country");

        //inicializa mapFragment
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        //coordenadas do pais
        LatLng countrylatlng = new LatLng(Double.parseDouble(country.latitude), Double.parseDouble(country.longitude));

        //adiciona marcador e move a camera do mapa p ele
        googleMap.addMarker(new MarkerOptions().position(countrylatlng).title(country.name));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(countrylatlng, 8.0f));
    }
}