package com.udayanga.form.dao;

import com.udayanga.form.model.City;

import java.util.List;

public interface CityDao {

    City findById(Integer id);

    List<City> findAll();

    void save(City city);

    void update(City city);

    void delete(Integer id);

}
