package com.example.pentagram;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class Mascota implements Serializable {

    private String nombreMascota;
    private int fotoMascota;
    private int likes;

    public Mascota(String nombreMascota, int fotoMascota, int likes) {
        this.nombreMascota = nombreMascota;
        this.fotoMascota = fotoMascota;
        this.likes = likes;
    }
    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(int fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void masLikes(){
        likes++;
    }
}
