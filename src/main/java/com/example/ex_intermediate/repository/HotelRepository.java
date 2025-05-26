package com.example.ex_intermediate.repository;

import com.example.ex_intermediate.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ホテル情報をデータベースから取得するリポジトリクラス.
 *
 */
@Repository
public class HotelRepository {

    /** ホテルオブジェクトへのマッピング定義 */
    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * すべてのホテル情報を取得する.
     *
     * @return 全ホテルのリスト。価格順に並べ替え済み。
     */
    public List<Hotel> findAll() {
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
                    price DESC
                """;
        return template.query(sql, HOTEL_ROW_MAPPER);
    }

    /**
     * 指定された価格以下のホテル情報を取得する.
     *
     * @param price 上限価格（この値以下の価格のホテルを検索）
     * @return 条件に一致するホテルのリスト。価格順に並べ替え済み。
     */
    public List<Hotel> findByLessThanPrice(Integer price) {
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
                price DESC
            """;
        SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
        return template.query(sql, param, HOTEL_ROW_MAPPER);
    }
}
