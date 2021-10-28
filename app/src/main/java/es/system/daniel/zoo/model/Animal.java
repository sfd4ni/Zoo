package es.system.daniel.zoo.model;

import android.content.ContentValues;

public class Animal {
    private String vulgarName, scientificName, family;
    private boolean endangered;
    public Animal (String vulgarName, String scientificName, String family, boolean endangered) {
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



}
