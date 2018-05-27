package com.udayanga.form.dao;

import com.udayanga.form.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class CityDaoImpl implements CityDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public City findById(Integer id) {

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        String sql = "SELECT * FROM city WHERE city_id=:id";
        City result = null;
        try {
            result = namedParameterJdbcTemplate.queryForObject(sql, params, new CityMapper());
        } catch (EmptyResultDataAccessException e) {
        }

        return result;
    }

    @Override
    public List<City> findAll() {
        String sql = "select * from city";
        return namedParameterJdbcTemplate.query(sql, new CityMapper());
    }

    @Override
    public void save(City city) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO CITY( CITY_NAME, CITY_DESCRIPTION, RATE, CITY_IMG_URL) "
                + "VALUES (  :cityName, :cityDescription, :rate, :cityImgUrl)";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(city), keyHolder);
        city.setCityID(keyHolder.getKey().intValue());

    }

    @Override
    public void update(City city) {
        String sql = "UPDATE CITY SET  CITY_NAME=:cityName, CITY_DESCRIPTION=:cityDescription, RATE=:rate, CITY_IMG_URL=:cityImgUrl WHERE city_id = :cityId ";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(city));
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM CITY WHERE city_id= :cityId";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("cityId", id));
    }

    private SqlParameterSource getSqlParameterByModel(City city) {

        // Unable to handle List<String> or Array
        // BeanPropertySqlParameterSource
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        city.setCityID(keyHolder.getKey().intValue());

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("cityId", city.getCityID());
        paramSource.addValue("cityName", city.getCityName());
        paramSource.addValue("cityDescription", city.getCityDescription());
        paramSource.addValue("rate", city.getRate());
        paramSource.addValue("cityImgUrl", city.getCityImgUrl());

        // join String
//        paramSource.addValue("framework", convertListToDelimitedString(city.getFramework()));
//        paramSource.addValue("sex", city.getSex());
//        paramSource.addValue("number", city.getNumber());
//        paramSource.addValue("country", city.getCountry());
//        paramSource.addValue("skill", convertListToDelimitedString(city.getSkill()));

        return paramSource;
    }

    private static final class CityMapper implements RowMapper<City> {

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
}
