package com.udayanga.form.service;

import com.udayanga.form.dao.CityDao;
import com.udayanga.form.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cityService")
public class CityServiceImpl implements CityService {
    CityDao cityDao;

    @Autowired
    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public City findById(Integer id) {
        return cityDao.findById(id);
    }

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public void saveOrUpdate(City city) {
        if (findById(city.getCityID()) == null) {
            cityDao.save(city);
        } else {
            cityDao.update(city);

        }

    }

    @Override
    public void delete(int id) {
        cityDao.delete(id);
    }
}
