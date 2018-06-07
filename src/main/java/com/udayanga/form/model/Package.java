package com.udayanga.form.model;

import java.util.List;

public class Package {
    private Integer packageID;
    private String packageName;
    private List<String> cities;
    private List<String> places;

    public Package() {
    }

    public Package(Integer packageID, String packageName, List<String> cities, List<String> places) {
        this.packageID = packageID;
        this.packageName = packageName;
        this.cities = cities;
        this.places = places;
    }

    public Integer getPackageID() {
        return packageID;
    }

    public String getPackageName() {
        return packageName;
    }

    public List<String> getCities() {
        return cities;
    }

    public List<String> getPlaces() {
        return places;
    }

    public void setPackageID(Integer packageID) {
        this.packageID = packageID;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public void setPlaces(List<String> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageID=" + packageID +
                ", packageName='" + packageName + '\'' +
                ", cities=" + cities +
                ", places=" + places +
                '}';
    }
}
