package es.system.daniel.zoo.model;

import android.content.ContentValues;

import es.system.daniel.zoo.dao.contracts.SpeciesContract;

public class Species {
    private String vulgarName, scientificName, family;
    private boolean endangered;
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
}
