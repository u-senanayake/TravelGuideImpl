package com.udayanga.form.model;

public class City {
    private String cityID;
    private String cityName;
    private String cityDescription;
    private int id;
    private String cityImgUrl;

    public City(String cityID, String cityName, String cityDescription, int id, String cityImgUrl) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.cityDescription = cityDescription;
        this.id = id;
        this.cityImgUrl = cityImgUrl;
    }

    public City(String cityID) {

        this.cityID = cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityDescription(String cityDescription) {
        this.cityDescription = cityDescription;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCityImgUrl(String cityImgUrl) {
        this.cityImgUrl = cityImgUrl;
    }

    public String getCityID() {
        return cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCityDescription() {
        return cityDescription;
    }

    public int getId() {
        return id;
    }

    public String getCityImgUrl() {
        return cityImgUrl;
    }
}
