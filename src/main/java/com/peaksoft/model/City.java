package com.peaksoft.model;

public class City {
    private int CityId;
    private String CityName;
    private int population;
    private int Country_id;
    private int person_Id;

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int cityId) {
        CityId = cityId;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getCountry_id() {
        return Country_id;
    }

    public void setCountry_id(int country_id) {
        Country_id = country_id;
    }

    public int getPerson_Id() {
        return person_Id;
    }

    public void setPerson_Id(int person_Id) {
        this.person_Id = person_Id;
    }

    @Override
    public String toString() {
        return "City - " +
                "(CityId - " + CityId +
                ") -- (, CityName='" + CityName + '\'' +
                ") -- (, population=" + population +
                ") -- (, Country_id=" + Country_id +
                ") -- (, People_id=" + person_Id +")\n";
    }
}