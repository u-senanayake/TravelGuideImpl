package com.udayanga.form.service;

import com.udayanga.form.dao.PlaceDao;
import com.udayanga.form.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("placeService")
public class PlaceServiceImpl implements PlaceService {

    PlaceDao placeDao;

    @Autowired
    public void setPlaceDao(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    @Override
    public Place findById(Integer id) {
        return placeDao.findById(id);
    }

    @Override
    public List<Place> findAll() {
        return placeDao.findAll();
    }

    @Override
    public void saveOrUpdate(Place place) {
        if (findById(place.getPlaceId()) == null) {
            placeDao.save(place);
        } else {
            placeDao.update(place);
        }
    }

    @Override
    public void delete(int id) {
        placeDao.delete(id);
    }
}
