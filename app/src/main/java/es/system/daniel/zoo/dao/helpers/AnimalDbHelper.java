package es.system.daniel.zoo.dao.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;

import es.system.daniel.zoo.dao.contracts.AnimalContract;
import es.system.daniel.zoo.dao.contracts.SpeciesContract;
import es.system.daniel.zoo.model.Animal;
import es.system.daniel.zoo.model.Species;

public class AnimalDbHelper extends CommonDbHelper {
    public AnimalDbHelper (Context context) {
        super(context);
    }

    public long save(Animal animal) {
        return super.save(AnimalContract.AnimalEntry.TABLE_NAME,
                animal.toContentValues());
    }

    public Animal getById(int id) {
        Animal animal = null;
        Cursor cursor = null;
        try {
            cursor = super.getAll(AnimalContract.AnimalEntry.TABLE_NAME,
                    null,
                    AnimalContract.AnimalEntry._ID + " = ?",
                    new String[]{String.valueOf(id)},
                    null,
                    null,
                    null);

            if (cursor.moveToFirst()) {
                @SuppressLint("Range") String sex = cursor.getString(cursor.getColumnIndex(
                        AnimalContract.AnimalEntry.SEX));
                @SuppressLint("Range") String country = cursor.getString(cursor.getColumnIndex(
                        AnimalContract.AnimalEntry.COUNTRY));
                @SuppressLint("Range") String continent = cursor.getString(cursor.getColumnIndex(
                        AnimalContract.AnimalEntry.CONTINENT));
                @SuppressLint("Range") int speciesId = Integer.parseInt(cursor.getString(cursor.getColumnIndex(
                        AnimalContract.AnimalEntry.SPECIES_ID)));
                @SuppressLint("Range") int zooId = Integer.parseInt(cursor.getString(cursor.getColumnIndex(
                        AnimalContract.AnimalEntry.ZOO_ID)));
                @SuppressLint("Range") int birthYear = Integer.parseInt(cursor.getString(cursor.getColumnIndex(
                        AnimalContract.AnimalEntry.BIRTH_YEAR)));
                animal = new Animal(sex, country, continent, id, speciesId, zooId, birthYear);
            }
        } catch (Exception exception) {
        } finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return animal;
    }
}
