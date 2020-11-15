package com.example.pentagram.presentador;

import android.content.Context;

import com.example.pentagram.db.ContructorMascotas;
import com.example.pentagram.pojo.Mascota;
import com.example.pentagram.vista.fragments.IRecyclerViewFragmentView;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ContructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView= iRecyclerViewFragmentView;
        this.context= context;
        obtenerMascotasBaseDatos();
    }

    public void obtenerMascotasBaseDatos() {
        constructorMascotas= new ContructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
