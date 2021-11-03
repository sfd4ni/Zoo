package es.system.daniel.zoo.model;

import android.content.ContentValues;

import java.util.Objects;

import es.system.daniel.zoo.dao.contracts.SpeciesContract;
import es.system.daniel.zoo.dao.contracts.ZooContract;

public class Zoo {
    private String name, city, country;
    private int size, yearlyIncome;
    public Zoo(String name, String city, String country, int size, int yearlyIncome) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.size = size;
        this.yearlyIncome = yearlyIncome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(int yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ZooContract.ZooEntry.NAME, this.name);
        values.put(ZooContract.ZooEntry.CITY, this.city);
        values.put(ZooContract.ZooEntry.COUNTRY, this.country);
        values.put(ZooContract.ZooEntry.SIZE, this.size);
        values.put(ZooContract.ZooEntry.YEARLY_INCOME, this.yearlyIncome);
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
        Zoo zoo = (Zoo) o;
        return Objects.equals(this.name, zoo.name)
                && Objects.equals(this.city, zoo.city)
                && Objects.equals(this.country, zoo.country)
                && Objects.equals(this.size, zoo.size)
                && Objects.equals(this.yearlyIncome, zoo.yearlyIncome);
    }
}
