package es.system.daniel.zoo.dao.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.system.daniel.zoo.dao.contracts.AnimalContract;
import es.system.daniel.zoo.dao.contracts.SpeciesContract;
import es.system.daniel.zoo.dao.contracts.ZooContract;
import es.system.daniel.zoo.model.Animal;
import es.system.daniel.zoo.model.Species;
import es.system.daniel.zoo.model.Zoo;

public class AnimalDbHelper extends CommonDbHelper {
    public AnimalDbHelper (Context context) {
        super(context);
    }

    public long save(Animal animal) {
        return super.save(AnimalContract.AnimalEntry.TABLE_NAME,
                animal.toContentValues());
    }


    public List<Animal> getAll() {
        List<Animal> animals = null;
        Cursor cursor = null;
        Animal animal = null;
        try {
            cursor = super.getAll(AnimalContract.AnimalEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                animals = new ArrayList<>();
                do {
                    @SuppressLint("Range") int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(
                            AnimalContract.AnimalEntry._ID)));
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
                    animals.add(animal);
                } while (cursor.moveToNext());
                return animals;
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

    /**
     * Funcion encargada en eliminar un elemento de la BBDD
     * @param id identificador de consulta de la BBDD
     * @return valor con el resultado de la operacion
     */
    public int delete(String id) {
        return super.delete(AnimalContract.AnimalEntry.TABLE_NAME,
                AnimalContract.AnimalEntry._ID + " = ?",
                new String[]{id});
    }


    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * de la BBDD
     * @param animal animal a actualizar en la app
     * @param id idea relacionado
     * @return intero con el valor de la operacion
     */
    public int update(Animal animal, String id) {
        return super.update(AnimalContract.AnimalEntry.TABLE_NAME,
                animal.toContentValues(),
                AnimalContract.AnimalEntry._ID + " = ?",
                new String[]{id});
    }

}
