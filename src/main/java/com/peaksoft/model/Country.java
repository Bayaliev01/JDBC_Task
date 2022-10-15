package com.peaksoft.model;

public class Country {
    private int CountryId;
    private String CountryName;
    private int number;
    private long population;
    private int people_id;

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getPeople_id() {
        return people_id;
    }

    public void setPeople_id(int people_id) {
        this.people_id = people_id;
    }

    @Override
    public String toString() {
        return "Country - " +
                "  (CountryId - " + CountryId +
                ") -- (, CountryName - " + CountryName + '\'' +
                ") -- (, number - " + number +
                ") -- (, population - " + population +
                ") -- (, people_id - " + people_id +")\n";
    }
}

