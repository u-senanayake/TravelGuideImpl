package com.udayanga.form.model;

public class City {
    private int cityID;
    private String cityName;
    private String cityDescription;
    private int rate;
    private String cityImgUrl;

    public City(int cityID, String cityName, String cityDescription, int rate, String cityImgUrl) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.cityDescription = cityDescription;
        this.rate = rate;
        this.cityImgUrl = cityImgUrl;
    }

    public City() {

    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityDescription(String cityDescription) {
        this.cityDescription = cityDescription;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setCityImgUrl(String cityImgUrl) {
        this.cityImgUrl = cityImgUrl;
    }

    public int getCityID() {
        return cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCityDescription() {
        return cityDescription;
    }

    public int getRate() {
        return rate;
    }

    public String getCityImgUrl() {
        return cityImgUrl;
    }
}
