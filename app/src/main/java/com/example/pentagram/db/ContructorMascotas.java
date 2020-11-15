package com.example.pentagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.pentagram.R;
import com.example.pentagram.pojo.Mascota;

import java.util.ArrayList;

public class ContructorMascotas {
    private static final int LIKE = 1;
    private Context context;

    public ContructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return  db.obtenerTodosLosContactos();
    }



    public void insertarTresContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Uma");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.uma);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Alaska");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO,R.drawable.alaska);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Oreo");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO,R.drawable.oreo);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Roma");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO,R.drawable.roma);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Molly");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO,R.drawable.molly);

        db.insertarContacto(contentValues);


    }

    public void darLikeCotnacto(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(mascota);
    }

}