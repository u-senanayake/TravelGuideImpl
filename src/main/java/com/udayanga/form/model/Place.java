package com.udayanga.form.model;

public class Place {
    private String placeId;
    private String placeName;
    private String placeDescription;
    private String placeType;
    private int rate;
    private String cityId;
    private String placeImgUrl;


    public Place() {
    }

    public Place(String placeId, String placeName, String placeDescription, String placeType, int rate, String cityId, String placeImgUrl) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.placeDescription = placeDescription;
        this.placeType = placeType;
        this.rate = rate;
        this.cityId = cityId;
        this.placeImgUrl = placeImgUrl;
    }

    public String getPlaceId() {
        return placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public String getPlaceType() {
        return placeType;
    }

    public int getRate() {
        return rate;
    }

    public String getCityId() {
        return cityId;
    }

    public String getPlaceImgUrl() {
        return placeImgUrl;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setPlaceImgUrl(String placeImgUrl) {
        this.placeImgUrl = placeImgUrl;
    }
}
