package com.example.pentagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pentagram.db.ContructorMascotas;
import com.example.pentagram.pojo.Mascota;
import com.example.pentagram.R;

import java.util.ArrayList;


public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity actividad;

    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity actividad){
        this.mascotas = mascotas;
        this.actividad=actividad;
    }
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardwiew_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFotoMascota());
        mascotaViewHolder.tvNombreMascota.setText(mascota.getNombreMascota());
        mascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()) + " ");

        mascotaViewHolder.btnLikes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(actividad, "Diste like a "+mascota.getNombreMascota(),Toast.LENGTH_SHORT).show();

                ContructorMascotas constructorMascotas = new ContructorMascotas(actividad);
                constructorMascotas.darLikeCotnacto(mascota);
                mascotaViewHolder.tvLikes.setText(constructorMascotas.obtenerLikesMascota(mascota) + " " );

            }
        });
    }

    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgMascota;
        private TextView tvNombreMascota;
        private TextView tvLikes;
        private ImageButton btnLikes;

        public MascotaViewHolder(View itemView){
            super(itemView);

            imgMascota = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombre);
            tvLikes = (TextView) itemView.findViewById(R.id.tvNum);
            btnLikes= (ImageButton) itemView.findViewById(R.id.ivBone);
        }
    }
}

