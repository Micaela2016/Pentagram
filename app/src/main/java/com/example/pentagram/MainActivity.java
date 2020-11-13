package com.example.pentagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
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

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.mContacto:
                Intent intent= new Intent(this, Contacto.class);
                startActivity(intent);
                break;
            case R.id.mAcercaDe:
                Intent i= new Intent(this, AcercaDe.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    public void inicializarAdaptador(){
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas,this);

        listaMascotas.setAdapter(adaptador);
    }

    public void pasarActividad(View v){
        Intent intent = new Intent(this, Listado.class);
        intent.putExtra("mascotas", mascotas);
        startActivity(intent);
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
}