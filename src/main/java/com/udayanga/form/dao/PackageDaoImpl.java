package com.udayanga.form.dao;

import com.udayanga.form.mapper.PlaceMapper;
import com.udayanga.form.model.Package;
import com.udayanga.form.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class PackageDaoImpl implements PackageDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Package findById(Integer id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        String sql = "SELECT * FROM package WHERE package_id=:id";

        Package aPackage = null;
        try {
            aPackage = namedParameterJdbcTemplate.queryForObject(sql, params, new PackageMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }

        return aPackage;
    }

    @Override
    public List<Package> findAll() {
        String sql = "select * from package ;";
        List<Package> packages = namedParameterJdbcTemplate.query(sql, new PackageMapper());
        return packages;
    }

    @Override
    public void save(Package aPackage) {

    }

    @Override
    public void update(Package aPackage) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Place> findPlacesByPackage(Integer id) {
        String sql = "select * from place where place_id in ( select place_id from package_place where package_id = :id group by place_id) ;";
        List<Place> places = namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource("id", id), new PlaceMapper());
        return places;
    }

    @Override
    public void deletePlaceByPackage(Integer packageId, Integer placeId) {
        String sql = "delete from package_place where package_id= :packageId and place_id = :placeId";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("packageId", packageId).addValue("placeId", placeId));
    }


    private static final class PackageMapper implements RowMapper<Package> {

        @Override
        public Package mapRow(ResultSet resultSet, int i) throws SQLException {
            Package aPackage = new Package();
            aPackage.setPackageID(resultSet.getInt("package_id"));
            aPackage.setPackageName(resultSet.getString("package_name"));
            aPackage.setCities(convertDelimitedStringToList(resultSet.getString("city_id")));
            aPackage.setPlaces(convertDelimitedStringToList(resultSet.getString("place_id")));
            return aPackage;
        }
    }

    private static List<String> convertDelimitedStringToList(String delimitedString) {

        List<String> result = new ArrayList<String>();

        if (!StringUtils.isEmpty(delimitedString)) {
            result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
        }
        return result;

    }

    private String convertListToDelimitedString(List<String> list) {

        String result = "";
        if (list != null) {
            result = StringUtils.arrayToCommaDelimitedString(list.toArray());
        }
        return result;

    }
}
