package com.example.pentagram.vista.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pentagram.MascotasPerfil;
import com.example.pentagram.R;
import com.example.pentagram.adapter.PerfilAdaptador;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {
    private ArrayList<MascotasPerfil> mas;
    private RecyclerView ListaMascotas;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        ListaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotasFrag);
        ListaMascotas.setLayoutManager(new GridLayoutManager(v.getContext(), 3));

        inicializarListaMascotas();
        inicializaAdaptador();
        return v;


    }
    public void inicializaAdaptador (){
        PerfilAdaptador adaptador = new PerfilAdaptador(mas);
        ListaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas () {

        mas = new ArrayList<MascotasPerfil>();
        mas.add(new MascotasPerfil(R.drawable.uma,5,R.drawable.hueso_amarillo));
        mas.add(new MascotasPerfil(R.drawable.uma2,2,R.drawable.hueso_amarillo));
        mas.add(new MascotasPerfil(R.drawable.uma3,12,R.drawable.hueso_amarillo));
        mas.add(new MascotasPerfil(R.drawable.uma4,10,R.drawable.hueso_amarillo));
        mas.add(new MascotasPerfil(R.drawable.uma5,5,R.drawable.hueso_amarillo));
        mas.add(new MascotasPerfil(R.drawable.uma6,3,R.drawable.hueso_amarillo));
        mas.add(new MascotasPerfil(R.drawable.uma7,7,R.drawable.hueso_amarillo));
        mas.add(new MascotasPerfil(R.drawable.uma8,9,R.drawable.hueso_amarillo));
        mas.add(new MascotasPerfil(R.drawable.uma9,10,R.drawable.hueso_amarillo));
    }
}