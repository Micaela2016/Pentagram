package com.example.pentagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {

    ArrayList<Mascota> listmascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listaMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarlistaMascotas();
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(Listado.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    private void inicializarAdaptador()
    {
        MascotaAdaptador adaptador = new MascotaAdaptador(listmascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    private void inicializarlistaMascotas()
    {
        listmascotas = new ArrayList<Mascota>();
        listmascotas.add(new Mascota("Uma",R.drawable.uma, "5"));
        listmascotas.add(new Mascota("Oreo", R.drawable.oreo, "5"));
        listmascotas.add(new Mascota("Olivia", R.drawable.olivia,"3"));
        listmascotas.add(new Mascota("Otto", R.drawable.otto,"2"));
        listmascotas.add(new Mascota("Milo", R.drawable.milo,"1"));

    }


}