package com.udayanga.form.service;

import com.udayanga.form.dao.PackageDao;
import com.udayanga.form.model.Package;
import com.udayanga.form.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("packageService")
public class PackageServiceImpl implements PackageService {

    PackageDao packageDao;

    @Autowired
    public void setPackageDao(PackageDao packageDao) {
        this.packageDao = packageDao;
    }

    @Override
    public Package findById(Integer id) {
        return packageDao.findById(id);
    }

    @Override
    public List<Package> findAll() {
        return packageDao.findAll();
    }

    @Override
    public void saveOrUpdate(Package aPackage) {
        if (findById(aPackage.getPackageID()) == null) {
            packageDao.save(aPackage);
        } else {
            packageDao.update(aPackage);
        }
    }

    @Override
    public void delete(int id) {
        packageDao.delete(id);
    }

    @Override
    public List<Place> findPlacesByPackage(Integer id) {
        return packageDao.findPlacesByPackage(id);
    }
}
