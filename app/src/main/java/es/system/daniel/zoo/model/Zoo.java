package es.system.daniel.zoo.model;

public class Zoo {
    private String name, city, country;
    private Float size, yearlyIncome;
    public Zoo(String name, String city, String country, Float size, Float yearlyIncome) {
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

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public Float getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(Float yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

}
