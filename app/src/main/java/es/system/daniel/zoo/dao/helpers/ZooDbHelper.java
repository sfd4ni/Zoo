package es.system.daniel.zoo.dao.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.system.daniel.zoo.dao.contracts.SpeciesContract;
import es.system.daniel.zoo.dao.contracts.ZooContract;
import es.system.daniel.zoo.model.Species;
import es.system.daniel.zoo.model.Zoo;

public class ZooDbHelper extends CommonDbHelper {
    public ZooDbHelper (Context context) {
        super(context);
    }

    /*@Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + ZooContract.ZooEntry.TABLE_NAME + " ("
                + ZooContract.ZooEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ZooContract.ZooEntry.NAME + " TEXT NOT NULL,"
                + ZooContract.ZooEntry.CITY + " TEXT NOT NULL,"
                + ZooContract.ZooEntry.COUNTRY + " TEXT NOT NULL,"
                + ZooContract.ZooEntry.SIZE + " INTEGER NOT NULL,"
                + ZooContract.ZooEntry.YEARLY_INCOME + " INTEGER NOT NULL,"
                + "UNIQUE (" + ZooContract.ZooEntry.NAME + "))");
    }

     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ZooContract.ZooEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long save(Zoo zoo) {
        return super.save(ZooContract.ZooEntry.TABLE_NAME,
                zoo.toContentValues());
    }

    public List<Zoo> getAll() {
        List<Zoo> zoos = null;
        Cursor cursor = null;
        Zoo zoo = null;
        try {
            cursor = super.getAll(ZooContract.ZooEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                zoos = new ArrayList<>();
                do {
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(
                            ZooContract.ZooEntry.NAME));
                    @SuppressLint("Range") String city = cursor.getString(cursor.getColumnIndex(
                            ZooContract.ZooEntry.CITY));
                    @SuppressLint("Range") String country = cursor.getString(cursor.getColumnIndex(
                            ZooContract.ZooEntry.COUNTRY));
                    @SuppressLint("Range") int size = Integer.parseInt(cursor.getString(cursor.getColumnIndex(
                            ZooContract.ZooEntry.SIZE)));
                    @SuppressLint("Range") int yearlyIncome = Integer.parseInt(cursor.getString(cursor.getColumnIndex(
                            ZooContract.ZooEntry.YEARLY_INCOME)));
                    zoo = new Zoo(name, city, country, size, yearlyIncome);
                    zoos.add(zoo);
                } while (cursor.moveToNext());
                return zoos;
            }
        } catch (Exception exception) {
            // TODO: Se debe de implementar las excepciones
        } finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return Collections.emptyList(); //Retornamos una lista vacia
    }

    public Zoo getById(String name) {
        Zoo zoo = null;
        Cursor cursor = null;
        try {
            cursor = super.getAll(ZooContract.ZooEntry.TABLE_NAME,
                    null,
                    ZooContract.ZooEntry.NAME + " = ?",
                    new String[]{name},
                    null,
                    null,
                    null);

            if (cursor.moveToFirst()) {
                @SuppressLint("Range") String city = cursor.getString(cursor.getColumnIndex(
                        ZooContract.ZooEntry.CITY));
                @SuppressLint("Range") String country = cursor.getString(cursor.getColumnIndex(
                        ZooContract.ZooEntry.COUNTRY));
                @SuppressLint("Range") int size = Integer.parseInt(cursor.getString(cursor.getColumnIndex(
                        ZooContract.ZooEntry.SIZE)));
                @SuppressLint("Range") int yearlyIncome = Integer.parseInt(cursor.getString(cursor.getColumnIndex(
                        ZooContract.ZooEntry.YEARLY_INCOME)));
                zoo = new Zoo(name, city, country, size, yearlyIncome);
            }
        } catch (Exception exception) {
        } finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return zoo;
    }
    /**
     * Funcion encargada en eliminar un elemento de la BBDD
     * @param name identificador de consulta de la BBDD
     * @return valor con el resultado de la operacion
     */
    public int delete(String name) {
        return super.delete(ZooContract.ZooEntry.TABLE_NAME,
                ZooContract.ZooEntry.NAME + " = ?",
                new String[]{name});
    }


    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * de la BBDD
     * @param zoo zoo a actualizar en la app
     * @param name nombre del zoo
     * @return intero con el valor de la operacion
     */
    public int update(Zoo zoo, String name) {
        return super.update(ZooContract.ZooEntry.TABLE_NAME,
                zoo.toContentValues(),
                ZooContract.ZooEntry.NAME + " = ?",
                new String[]{name});
    }
}
