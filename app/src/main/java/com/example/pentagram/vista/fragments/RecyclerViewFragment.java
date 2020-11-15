package com.example.pentagram.vista.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pentagram.R;
import com.example.pentagram.adapter.MascotaAdaptador;
import com.example.pentagram.pojo.Mascota;
import com.example.pentagram.presentador.IRecyclerViewFragmentPresenter;
import com.example.pentagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private MascotaAdaptador adaptador;
    private IRecyclerViewFragmentPresenter presenter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaMascotas=(RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }

    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager((getActivity()));
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);//Para que el objeto se comporte como un linear layout
    }

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {

        adaptador = new MascotaAdaptador(mascotas, getActivity());

        return adaptador;
    }

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);

    }

}