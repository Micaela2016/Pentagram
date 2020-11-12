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

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listaMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        mascotas = (ArrayList<Mascota> ) getIntent().getSerializableExtra("mascotas");
        reordenar();
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

    public void reordenar(){
            int cuentaintercambios=0;
            Mascota aux;
            //Usamos un bucle anidado, saldra cuando este ordenado el array
            for (boolean ordenado=false;!ordenado;){
                for (int i=0;i<mascotas.size()-1;i++){
                    if (mascotas.get(i).getLikes().compareTo(mascotas.get(i+1).getLikes())<0){
                        aux = mascotas.get(i);
                        //Intercambiamos valores
                        mascotas.set(i, mascotas.get(i+1));
                        mascotas.set(i+1, aux);
                        //indicamos que hay un cambio
                        cuentaintercambios++;
                }
            }

            //Si no hay intercambios, es que esta ordenado.
            if (cuentaintercambios==0){
                ordenado=true;
            }
            //Inicializamos la variable de nuevo para que empiece a contar de nuevo
            cuentaintercambios=0;
        }


    }





    @Override
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