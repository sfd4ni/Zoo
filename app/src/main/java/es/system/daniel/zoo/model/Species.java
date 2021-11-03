package es.system.daniel.zoo.model;

import android.content.ContentValues;

import java.util.Objects;

import es.system.daniel.zoo.dao.contracts.SpeciesContract;

public class Species {
    private String vulgarName, scientificName, family;
    private boolean endangered;

    public Species() {}

    public Species (String vulgarName, String scientificName, String family, boolean endangered) {
        this.vulgarName = vulgarName;
        this.scientificName = scientificName;
        this.family = family;
        this.endangered = endangered;
    }

    public String getVulgarName() {
        return vulgarName;
    }

    public void setVulgarName(String vulgarName) {
        this.vulgarName = vulgarName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public boolean isEndangered() {
        return endangered;
    }

    public void setEndangered(boolean endangered) {
        this.endangered = endangered;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(SpeciesContract.SpeciesEntry.VULGAR_NAME, this.vulgarName);
        values.put(SpeciesContract.SpeciesEntry.SCIENTIFIC_NAME, this.scientificName);
        values.put(SpeciesContract.SpeciesEntry.FAMILY, this.family);
        values.put(SpeciesContract.SpeciesEntry.ENDANGERED, (this.endangered ? 1 : 0));
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
        Species species = (Species) o;
        return Objects.equals(this.vulgarName, species.vulgarName)
                && Objects.equals(this.scientificName, species.scientificName)
                && Objects.equals(this.family, species.family)
                && Objects.equals(this.endangered, species.endangered);
    }
}
