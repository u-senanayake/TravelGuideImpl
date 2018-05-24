package com.udayanga.form.service;

import com.udayanga.form.model.City;

import java.util.List;

public interface CityService {

    City findById(Integer id);

    List<City> findAll();

    void saveOrUpdate(City user);

    void delete(int id);
}
