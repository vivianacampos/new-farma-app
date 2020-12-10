package com.example.farmaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.farmaapp.Controlador.MainFragment;
import com.example.farmaapp.Controlador.PagerController;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1, tab2, tab3;
    PagerController pagerAdapter;

    FragmentTransaction transaction;
    Fragment fragmentPrincipal, fragmentFarm, fragmentFarmaTips, fragmentMed  ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentPrincipal = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment, fragmentPrincipal).commit();
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);

        tab1 = findViewById(R.id.tabFarmaApp);
        tab2 = findViewById(R.id.tabFarmaTips);
        tab3 = findViewById(R.id.tabRS);

        pagerAdapter = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition() == 1){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition() == 2){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
    public boolean onCreateOptionsMenu (Menu m){
        getMenuInflater().inflate(R.menu.menuopciones, m);
        return true;
    }

    // menu de opciones
    public boolean onOptionsItemSelected (MenuItem item) {
        int i = item.getItemId();
        switch (i) {
            case R.id.menuAjustes:
                Toast.makeText(this, "Abriendo Ajustes", Toast.LENGTH_SHORT).show();
                Intent int1 = new Intent(  this, MenuAjustes.class);
                startActivity(int1);
                break;

            case R.id.menuHome:
                Toast.makeText(this, "Redireccionando al Home", Toast.LENGTH_SHORT).show();
                Intent int4 = new Intent(  this, MainActivity.class);
                startActivity(int4);
                break;


        }
        return super.onOptionsItemSelected(item);
    }

}