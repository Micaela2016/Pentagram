package com.example.pentagram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pentagram.adapter.MascotaAdaptador;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaMascotas=(RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm); //Para que el objeto se comporte como un linear layout

        inicializarListaContactos();

        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas,getActivity());

        listaMascotas.setAdapter(adaptador);
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