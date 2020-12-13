package com.example.farmaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BuscadorMed extends AppCompatActivity {
    private ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();

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
            case R.id.menuMed:
                Toast.makeText(this, "Abriendo mantenedor de medicamentos", Toast.LENGTH_SHORT).show();
                Intent int3 = new Intent(this, CrudMed.class);
                startActivity(int3);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador_med);

        listaMedicamentos.add(new Medicamento("Ibuprofeno", 400, "comprimido", 2000));
        listaMedicamentos.add(new Medicamento("Paracetamol", 500, "pastilla", 2990));
        listaMedicamentos.add(new Medicamento("Ritalin", 400, "comprimido", 5900));
        listaMedicamentos.add(new Medicamento("Salbutamol", 200, "Inhalador", 2590));
        listaMedicamentos.add(new Medicamento("Levocetiricina", 250, "jarabe", 5490));
        listaMedicamentos.add(new Medicamento("Migranol", 400, "comprimido", 3000));
        listaMedicamentos.add(new Medicamento("Prednisona", 200, "jarabe", 2990));

        MedicamentoAdapter adap = new MedicamentoAdapter(this);
        ListView lvMed = (ListView) findViewById(R.id.listViewMed);
        lvMed.setAdapter(adap);


    }

    class MedicamentoAdapter extends ArrayAdapter<Medicamento> {
        AppCompatActivity appCompatActivity;

        MedicamentoAdapter(AppCompatActivity contexto) {
            super(contexto, R.layout.listado, listaMedicamentos);
            appCompatActivity = contexto;
        }

        public View getView(int p, View convert, ViewGroup g) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.listado, null);

            TextView tv1 = (TextView) item.findViewById(R.id.txtMed);
            tv1.setText(listaMedicamentos.get(p).getNombre() + " " + listaMedicamentos.get(p).getMg()+" mg "+listaMedicamentos.get(p).getFormato()+"  valor $"+listaMedicamentos.get(p).getValor());

            ImageView img1 = (ImageView) item.findViewById(R.id.imgFormato);
            if (listaMedicamentos.get(p).getFormato().equalsIgnoreCase("pastilla")) {
                img1.setImageResource(R.drawable.pastillas);
            } else if (listaMedicamentos.get(p).getFormato().equalsIgnoreCase("comprimido")) {
                img1.setImageResource(R.drawable.comprimido);
            } else if (listaMedicamentos.get(p).getFormato().equalsIgnoreCase("jarabe")) {
                img1.setImageResource(R.drawable.jarabe);
            } else if (listaMedicamentos.get(p).getFormato().equalsIgnoreCase("inhalador")) {
                img1.setImageResource(R.drawable.inhalador);
            }
            return item;


        }
    }
}