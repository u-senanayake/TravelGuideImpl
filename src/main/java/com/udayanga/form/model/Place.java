package com.udayanga.form.model;

public class Place {
    private Integer placeId;
    private String placeName;
    private String placeDescription;
    private String placeType;
    private int rate;
    private Integer cityId;
    private String placeImgUrl;


    public Place() {
    }

    public Place(Integer placeId, String placeName, String placeDescription, String placeType, int rate, Integer cityId, String placeImgUrl) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.placeDescription = placeDescription;
        this.placeType = placeType;
        this.rate = rate;
        this.cityId = cityId;
        this.placeImgUrl = placeImgUrl;
    }

    public Integer getPlaceId() {
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

    public Integer getCityId() {
        return cityId;
    }

    public String getPlaceImgUrl() {
        return placeImgUrl;
    }

    public void setPlaceId(Integer placeId) {
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

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public void setPlaceImgUrl(String placeImgUrl) {
        this.placeImgUrl = placeImgUrl;
    }

    public boolean isNew() {
        return (this.placeId == null);
    }
}
