package com.udayanga.form.dao;

import com.udayanga.form.model.Package;
import com.udayanga.form.model.Place;

import java.util.List;

public interface PackageDao {

    Package findById(Integer id);

    List<Package> findAll();

    void save(Package aPackage);

    void update(Package aPackage);

    void delete(Integer id);

    List<Place> findPlacesByPackage(Integer id);

    void deletePlaceByPackage(Integer packageId, Integer placeId);

}
