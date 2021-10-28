package es.system.daniel.zoo.dao.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Collections;

import es.system.daniel.zoo.dao.contracts.SpeciesContract;
import es.system.daniel.zoo.model.Species;

public class SpeciesDbHelper extends CommonDbHelper {
    public SpeciesDbHelper (Context context) {
        super(context);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + SpeciesContract.SpeciesEntry.TABLE_NAME + " ("
                + SpeciesContract.SpeciesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + SpeciesContract.SpeciesEntry.VULGAR_NAME + " TEXT NOT NULL,"
                + SpeciesContract.SpeciesEntry.SCIENTIFIC_NAME + " TEXT NOT NULL,"
                + SpeciesContract.SpeciesEntry.FAMILY + " TEXT NOT NULL,"
                + SpeciesContract.SpeciesEntry.ENDANGERED + " INTEGER NOT NULL DEFAULT 0,"
                + "UNIQUE (" + SpeciesContract.SpeciesEntry.VULGAR_NAME + "))");

        save(new Species ("Cheetah", "Acinonyx jubatus", "Felines", false));
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // No hay operaciones
    }


    public long save(Species species) {
        return super.save(SpeciesContract.SpeciesEntry.TABLE_NAME,
                species.toContentValues());
    }

    public Species getByVulgarName(String vulgarName) {
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
                species = new Species(vulgarName, scientificName, family, false);
            }
        } catch (Exception exception) {
            // TODO: Se debe de implementar las excepciones
        } finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return species; //Retornamos una lista vacia
    }
}
