package com.udayanga.form.mapper;

import com.udayanga.form.model.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMapper implements RowMapper<City> {
    @Override
    public City mapRow(ResultSet resultSet, int i) throws SQLException {
        City city = new City();
        city.setCityID(resultSet.getInt("CITY_ID"));
        city.setCityName(resultSet.getString("CITY_NAME"));
        city.setCityDescription(resultSet.getString("CITY_DESCRIPTION"));
        city.setRate(resultSet.getInt("RATE"));
        city.setCityImgUrl(resultSet.getString("CITY_IMG_URL"));

        return city;
    }
}
