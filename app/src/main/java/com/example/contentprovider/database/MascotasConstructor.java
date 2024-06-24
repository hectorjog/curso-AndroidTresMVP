package com.example.contentprovider.database;
import android.content.ContentValues;
import android.content.Context;
import  com.example.contentprovider.R;
import  com.example.contentprovider.pojo.Mascota;
import java.util.ArrayList;
public class MascotasConstructor {

    private static final int LIKE = 1;
    private Context context;
    public MascotasConstructor(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascotas(String filtro){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        Databses db = new Databses(context);
        insertarMascotas(db);
        switch (filtro)
        {
            case DatabsesConstants.MASCOTAS_TOP5: mascotas = db.obtenerTop5Mascotas();
                break;
            case DatabsesConstants.MASCOTAS_ALL: mascotas = db.obtenerTodasLasMascotas();
                break;
        }
        return mascotas;
    }

    public void insertarMascotas(Databses db){

        if(!(db.existeTablaMascotas())){
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabsesConstants.TABLE_MASCOTA_NOMBRE, "Yogui");
            contentValues.put(DatabsesConstants.TABLE_MASCOTA_IMAGEN,  R.drawable.bear);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(DatabsesConstants.TABLE_MASCOTA_NOMBRE, "Dumbo");
            contentValues.put(DatabsesConstants.TABLE_MASCOTA_IMAGEN,  R.drawable.elephant);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(DatabsesConstants.TABLE_MASCOTA_NOMBRE, "King Kong");
            contentValues.put(DatabsesConstants.TABLE_MASCOTA_IMAGEN,  R.drawable.monkey);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(DatabsesConstants.TABLE_MASCOTA_NOMBRE, "Kovalsky");
            contentValues.put(DatabsesConstants.TABLE_MASCOTA_IMAGEN,  R.drawable.pinguino);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(DatabsesConstants.TABLE_MASCOTA_NOMBRE, "Fox McCloud");
            contentValues.put(DatabsesConstants.TABLE_MASCOTA_IMAGEN,  R.drawable.fox);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(DatabsesConstants.TABLE_MASCOTA_NOMBRE, "Sheepy");
            contentValues.put(DatabsesConstants.TABLE_MASCOTA_IMAGEN,  R.drawable.sheep);
            db.insertarMascota(contentValues);


        }
    }

    public void darRaiting(Mascota mascota){
        Databses db = new Databses(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabsesConstants.TABLE_RATING_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(DatabsesConstants.TABLE_RATING_MASCOTA_RATING, LIKE);
        db.insertarRatingMascota(contentValues);
    }

    public int obtenerRatingMascota(Mascota mascota){
        Databses db = new Databses(context);
        return db.obtenerRatingMascota(mascota);
    }


}


