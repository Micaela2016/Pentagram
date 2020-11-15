package com.example.pentagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.example.pentagram.adapter.MascotaAdaptador;
import com.example.pentagram.pojo.Mascota;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listaMascotas = findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaContactos();
        inicializarAdaptador();


        Toolbar miActionBar = findViewById(R.id.miActionbar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        miActionBar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Listado.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Uma",R.drawable.uma, 5));
        mascotas.add(new Mascota("Oreo", R.drawable.oreo, 5));
        mascotas.add(new Mascota("Alaska", R.drawable.alaska,3));
        mascotas.add(new Mascota("Atun", R.drawable.atun,2));
        mascotas.add(new Mascota("Juanita", R.drawable.juanita,1));
        mascotas.add(new Mascota("Molly", R.drawable.molly,1));
        mascotas.add(new Mascota("Roma", R.drawable.roma,1));
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(Listado.this, MainActivity.class);
            intent.putExtra("mascotas", mascotas);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
    private void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }
}