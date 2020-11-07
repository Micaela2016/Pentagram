package com.example.pentagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas=(RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm= new LinearLayoutManager((this));
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm); //Para que el objeto se comporte como un linear layout
        inicializarListaContactos();
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    public void pasarActividad(View view)
    {
        Intent intent = new Intent(this, Listado.class);
        startActivity(intent);
        finish();
    }

    public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Uma",R.drawable.uma, "5"));
        mascotas.add(new Mascota("Oreo", R.drawable.oreo, "5"));
        mascotas.add(new Mascota("Olivia", R.drawable.olivia,"3"));
        mascotas.add(new Mascota("Otto", R.drawable.otto,"2"));
        mascotas.add(new Mascota("Milo", R.drawable.milo,"1"));
    }

}