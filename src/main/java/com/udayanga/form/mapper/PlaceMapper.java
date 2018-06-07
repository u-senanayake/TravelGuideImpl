package com.udayanga.form.mapper;

import com.udayanga.form.model.Place;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceMapper implements RowMapper<Place> {
    @Override
    public Place mapRow(ResultSet resultSet, int i) throws SQLException {
        Place place = new Place();
        place.setPlaceId(resultSet.getInt("place_id"));
        place.setPlaceName(resultSet.getString("place_name"));
        place.setPlaceDescription(resultSet.getString("place_description"));
        place.setPlaceType(resultSet.getString("place_type"));
        place.setRate(resultSet.getInt("rate"));
        place.setCityId(resultSet.getInt("city_id"));
        place.setPlaceImgUrl(resultSet.getString("place_img_url"));

        return place;
    }
}
