package com.udayanga.form.dao;

import com.udayanga.form.mapper.PlaceMapper;
import com.udayanga.form.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PlaceDaoImpl implements PlaceDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Place findById(Integer id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        String sql = "SELECT * FROM place WHERE place_id=:id";
        Place place = null;
        try {
            place = namedParameterJdbcTemplate.queryForObject(sql, params, new PlaceMapper());
        } catch (EmptyResultDataAccessException e) {
        }

        return place;
    }

    @Override
    public List<Place> findAll() {
        String sql = "select * from place";
        return namedParameterJdbcTemplate.query(sql, new PlaceMapper());
    }

    @Override
    public void save(Place place) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO place( place_name, place_description, place_type, rate, city_id, place_img_url ) "
                + "VALUES (  :placeName, :placeDescription, :placeType, :rate, :cityId, :placeImgUrl )";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(place), keyHolder);
        place.setPlaceId(keyHolder.getKey().intValue());
    }

    @Override
    public void update(Place place) {
        String sql = "UPDATE place SET  place_name=:placeName, place_description=:placeDescription, place_type=:placeType, rate=:rate , city_id=:cityId,  place_img_url=:placeImgUrl WHERE place_id = :placeId ";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(place));
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM place WHERE place_id = :placeId";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("placeId", id));
    }

    private SqlParameterSource getSqlParameterByModel(Place place) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placeId", place.getPlaceId());
        paramSource.addValue("placeName", place.getPlaceName());
        paramSource.addValue("placeDescription", place.getPlaceDescription());
        paramSource.addValue("placeType", place.getPlaceType());
        paramSource.addValue("rate", place.getRate());
        paramSource.addValue("cityId", place.getCityId());
        paramSource.addValue("placeImgUrl", place.getPlaceImgUrl());

        return paramSource;
    }

   /* private static final class PlaceMapper implements RowMapper<Place> {

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
    }*/
}
