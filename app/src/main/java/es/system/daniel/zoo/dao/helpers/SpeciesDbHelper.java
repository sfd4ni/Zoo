package es.system.daniel.zoo.dao.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Collections;

import es.system.daniel.zoo.dao.contracts.AnimalContract;
import es.system.daniel.zoo.dao.contracts.SpeciesContract;
import es.system.daniel.zoo.dao.contracts.ZooContract;
import es.system.daniel.zoo.model.Animal;
import es.system.daniel.zoo.model.Species;

public class SpeciesDbHelper extends CommonDbHelper {
    public SpeciesDbHelper (Context context) {
        super(context);
    }

    /*
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + SpeciesContract.SpeciesEntry.TABLE_NAME + " ("
                + SpeciesContract.SpeciesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + SpeciesContract.SpeciesEntry.VULGAR_NAME + " TEXT NOT NULL,"
                + SpeciesContract.SpeciesEntry.SCIENTIFIC_NAME + " TEXT NOT NULL,"
                + SpeciesContract.SpeciesEntry.FAMILY + " TEXT NOT NULL,"
                + SpeciesContract.SpeciesEntry.ENDANGERED + " INTEGER NOT NULL DEFAULT 0,"
                + "UNIQUE (" + SpeciesContract.SpeciesEntry.VULGAR_NAME + "))");
    }

     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public long save(Species species) {
        return super.save(SpeciesContract.SpeciesEntry.TABLE_NAME,
                species.toContentValues());
    }

    public Species getById(String vulgarName) {
        Species species = null;
        Cursor cursor = null;
        try {
            cursor = super.getAll(SpeciesContract.SpeciesEntry.TABLE_NAME,
                    null,
                    SpeciesContract.SpeciesEntry.VULGAR_NAME + " = ?",
                    new String[]{vulgarName},
                    null,
                    null,
                    null);

            if (cursor.moveToFirst()) {
                @SuppressLint("Range") String scientificName = cursor.getString(cursor.getColumnIndex(
                        SpeciesContract.SpeciesEntry.SCIENTIFIC_NAME));
                @SuppressLint("Range") String family = cursor.getString(cursor.getColumnIndex(
                        SpeciesContract.SpeciesEntry.FAMILY));
                @SuppressLint("Range") int endangered = Integer.parseInt(cursor.getString(cursor.getColumnIndex(
                        SpeciesContract.SpeciesEntry.ENDANGERED)));
                species = new Species(vulgarName, scientificName, family, endangered == 1);
            }
        } catch (Exception exception) {
        } finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return species;
    }
    /**
     * Funcion encargada en eliminar un elemento de la BBDD
     * @param vulgarName identificador de consulta de la BBDD
     * @return valor con el resultado de la operacion
     */
    public int delete(String vulgarName) {
        return super.delete(SpeciesContract.SpeciesEntry.TABLE_NAME,
                SpeciesContract.SpeciesEntry.VULGAR_NAME + " = ?",
                new String[]{vulgarName});
    }


    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * de la BBDD
     * @param species species a actualizar en la app
     * @param vulgarName nombre vulgar de la species a actualizar
     * @return intero con el valor de la operacion
     */
    public int update(Species species, String vulgarName) {
        return super.update(SpeciesContract.SpeciesEntry.TABLE_NAME,
                species.toContentValues(),
                SpeciesContract.SpeciesEntry.VULGAR_NAME + " = ?",
                new String[]{vulgarName});
    }
}
