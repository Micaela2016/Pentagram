package com.example.pentagram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pentagram.Mascota;
import com.example.pentagram.MascotasPerfil;
import com.example.pentagram.R;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter <PerfilAdaptador.PerfilViewHolder>{

    ArrayList<MascotasPerfil> mascotas;

    public PerfilAdaptador(ArrayList<MascotasPerfil> mas) {
        mascotas = mas;
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View x = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);

        return new PerfilViewHolder(x);
    }

    @Override
    public void onBindViewHolder(final PerfilViewHolder mascotasViewHolder, int position) {
        final MascotasPerfil mascota = mascotas.get(position);
        mascotasViewHolder.imgFotoPerro.setImageResource(mascota.getFotoPerro());
        mascotasViewHolder.imgHuesoAmarrillo.setImageResource(mascota.getHueso_amarillo());
        mascotasViewHolder.tvMegusta.setText(mascota.getMegusta()+"");

    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoPerro;
        private ImageView imgHuesoAmarrillo;
        private TextView tvMegusta;

        public PerfilViewHolder (View itemView) {
            super(itemView);
            imgFotoPerro = (ImageView) itemView.findViewById(R.id.imgFotoPerro);
            imgHuesoAmarrillo = (ImageView) itemView.findViewById(R.id.imgHuesoAmarrillo);
            tvMegusta = (TextView) itemView.findViewById(R.id.tvMegusta);


        }
    }
}
