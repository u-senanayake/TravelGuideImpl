package com.udayanga.form.service;

import com.udayanga.form.model.Place;

import java.util.List;

public interface PlaceService {
    Place findById(Integer id);

    List<Place> findAll();

    void saveOrUpdate(Place place);

    void delete(int id);
}
