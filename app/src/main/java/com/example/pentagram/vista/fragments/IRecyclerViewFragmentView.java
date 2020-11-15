package com.example.pentagram.vista.fragments;

import com.example.pentagram.adapter.MascotaAdaptador;
import com.example.pentagram.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV (MascotaAdaptador adaptador);
}
