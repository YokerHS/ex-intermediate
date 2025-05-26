package com.example.ex_intermediate.repository;

import com.example.ex_intermediate.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HotelRepository {
    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);

    @Autowired
    private NamedParameterJdbcTemplate template;

    public List<Hotel> findAll(){
        String sql = """
                SELECT
                    id,
                    area_name,
                    hotel_name,
                    address,
                    nearest_station,
                    price,
                    parking
                FROM
                    hotels
                ORDER BY
                    price
                """;
        return template.query(sql,HOTEL_ROW_MAPPER);
    }

    public List<Hotel> searchByLessThanPrice(Integer price) {
        String sql = """
            SELECT
                id,
                area_name,
                hotel_name,
                address,
                nearest_station,
                price,
                parking
            FROM
                hotels
            WHERE
                price <= :price
            ORDER BY
                price
            """;

        SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
        return template.query(sql, param, HOTEL_ROW_MAPPER);
    }

}
