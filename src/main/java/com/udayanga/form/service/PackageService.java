package com.udayanga.form.service;

import com.udayanga.form.model.Package;
import com.udayanga.form.model.Place;

import java.util.List;

public interface PackageService {
    Package findById(Integer id);

    List<Package> findAll();

    void saveOrUpdate(Package aPackage);

    void delete(int id);

    List<Place> findPlacesByPackage(Integer id);
}
