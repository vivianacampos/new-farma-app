package com.example.farmaapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.farmaapp.R.drawable.icono_farmaapp;

public class Mapa extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker miMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng dignidad = new LatLng(-33.436941933816314,-70.63439715071587);
        LatLng farmacia = new LatLng(-33.43733495042139, -70.63467885697638);//Farmacia Ahumada
        LatLng farmacia1 = new LatLng(-33.44032145699199, -70.6399221779726); //Farmacia Daniela
        LatLng farmacia2 = new LatLng(-33.443717970409125, -70.64450350680835); //Gamma
        LatLng farmacia3 = new LatLng(-33.443870161698726, -70.64610210333592); //Dr. Simi
        LatLng farmacia4 = new LatLng(-33.44070989954292, -70.64546910202634); //Manriquez
        LatLng farmacia5 = new LatLng(-33.44326139493825, -70.64974990749286); //Knop
        LatLng farmacia6 = new LatLng(-33.444353591059766, -70.63661781227083); //Salcobrand
        LatLng farmacia7 = new LatLng(-33.44003844081823, -70.62984791668285); //Conac Botiquin
        LatLng farmacia8 = new LatLng(-33.43175374371574, -70.62860074938217); //Cruz verde
        LatLng farmacia9 = new LatLng(-33.43471735827918, -70.62644425337155); //Salcobrand




        mMap.addMarker(new MarkerOptions().position(dignidad).title("Plaza de la Dignidad"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dignidad, 15));
        mMap.addMarker(new MarkerOptions().position(farmacia).title("Farmacia").snippet("Farmacia Ahumada").icon(BitmapDescriptorFactory.fromResource(icono_farmaapp)));
        miMarker = googleMap.addMarker(new MarkerOptions().position(farmacia1).title("Farmacia").snippet("Farmacia Daniela").icon(BitmapDescriptorFactory.fromResource(icono_farmaapp)));
        miMarker = googleMap.addMarker(new MarkerOptions().position(farmacia2).title("Farmacia").snippet("Farmacia Gamma").icon(BitmapDescriptorFactory.fromResource(icono_farmaapp)));
        miMarker = googleMap.addMarker(new MarkerOptions().position(farmacia3).title("Farmacia").snippet("Farmacia Dr. Simi").icon(BitmapDescriptorFactory.fromResource(icono_farmaapp)));
        miMarker = googleMap.addMarker(new MarkerOptions().position(farmacia4).title("Farmacia").snippet("Farmacia Manriquez").icon(BitmapDescriptorFactory.fromResource(icono_farmaapp)));
        miMarker = googleMap.addMarker(new MarkerOptions().position(farmacia5).title("Farmacia").snippet("Farmacia Knop").icon(BitmapDescriptorFactory.fromResource(icono_farmaapp)));
        miMarker = googleMap.addMarker(new MarkerOptions().position(farmacia6).title("Farmacia").snippet("Farmacia Salcobrand").icon(BitmapDescriptorFactory.fromResource(icono_farmaapp)));
        miMarker = googleMap.addMarker(new MarkerOptions().position(farmacia7).title("Farmacia").snippet("Farmacia Conac Botiquin").icon(BitmapDescriptorFactory.fromResource(icono_farmaapp)));
        miMarker = googleMap.addMarker(new MarkerOptions().position(farmacia8).title("Farmacia").snippet("Farmacia Cruz Verde").icon(BitmapDescriptorFactory.fromResource(icono_farmaapp)));
        miMarker = googleMap.addMarker(new MarkerOptions().position(farmacia9).title("Farmacia").snippet("Farmacia Salcobrand").icon(BitmapDescriptorFactory.fromResource(icono_farmaapp)));








    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}