package com.example.farmaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuAjustes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ajustes);
    }
    // menu de opciones
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.menuopciones, m);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        switch (i) {
            case R.id.menuAjustes:
                Toast.makeText(this, "Abriendo Ajustes", Toast.LENGTH_SHORT).show();
                Intent int1 = new Intent(this, MenuAjustes.class);
                startActivity(int1);
                break;

            case R.id.menuHome:
                Toast.makeText(this, "Redireccionando al Home", Toast.LENGTH_SHORT).show();
                Intent int2 = new Intent(this, MainActivity.class);
                startActivity(int2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}