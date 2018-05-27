package com.udayanga.form.dao;

import com.udayanga.form.model.Place;

import java.util.List;

public interface PlaceDao {
    Place findById(Integer id);

    List<Place> findAll();

    void save(Place place);

    void update(Place place);

    void delete(Integer id);
}
