package es.system.daniel.zoo.model;

import android.content.ContentValues;

import java.util.Objects;

import es.system.daniel.zoo.dao.contracts.AnimalContract;
import es.system.daniel.zoo.dao.contracts.SpeciesContract;

public class Animal {
    private String sex, country, continent;
    private int id, speciesId, zooId, birthYear;

    public Animal() {}

    public Animal (String sex, String country, String continent, int id,
                   int speciesId, int zooId, int birthYear) {
        this.id = id;
        this.sex = sex;
        this.country = country;
        this.continent = continent;
        this.speciesId = speciesId;
        this.zooId = zooId;
        this.birthYear = birthYear;

    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(int speciesId) {
        this.speciesId = speciesId;
    }

    public int getZooId() {
        return zooId;
    }

    public void setZooId(int zooId) {
        this.zooId = zooId;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(AnimalContract.AnimalEntry.SEX, this.sex);
        values.put(AnimalContract.AnimalEntry.COUNTRY, this.country);
        values.put(AnimalContract.AnimalEntry.CONTINENT, this.continent);
        values.put(AnimalContract.AnimalEntry.SPECIES_ID, this.speciesId);
        values.put(AnimalContract.AnimalEntry.ZOO_ID, this.zooId);
        values.put(AnimalContract.AnimalEntry.BIRTH_YEAR, this.birthYear);
        return values;
    }
    /**
     * Funcion que determina si dos objetos de la clase Species, son iguales
     * @param o objeto a evaluar
     * @return true/false con la evaluacion
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(this.id, animal.id)
                && Objects.equals(this.sex, animal.sex)
                && Objects.equals(this.country, animal.country)
                && Objects.equals(this.continent, animal.continent)
                && Objects.equals(this.speciesId, animal.speciesId)
                && Objects.equals(this.zooId, animal.zooId)
                && Objects.equals(this.birthYear, animal.birthYear);
    }
}
