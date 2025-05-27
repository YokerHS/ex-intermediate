package com.example.ex_intermediate.repository;

import com.example.ex_intermediate.domain.Clothes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 衣類情報をデータベースから取得するリポジトリクラス.
 *
 * 主に色と性別による検索や、利用可能な色の一覧取得を行う。
 */
@Repository
public class ClothesRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Clothes> CLOTHES_ROW_MAPPER = new BeanPropertyRowMapper<>(Clothes.class);

    /**
     * 指定された色と性別に一致する衣類情報を取得する.
     *
     * @param color  衣類の色
     * @param gender 性別コード（0: 男性, 1: 女性）
     * @return 条件に一致する衣類のリスト。該当がない場合は空リスト。
     */
    public List<Clothes> findByColorAndGender(String color, Integer gender) {
        String sql = """
            SELECT
                id,
                category,
                genre,
                gender,
                color,
                price,
                size
            FROM
                clothes
            WHERE
                color = :color
                AND gender = :gender
            ORDER BY
               price DESC 
            """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("color", color)
                .addValue("gender", gender);

        return template.query(sql, param, CLOTHES_ROW_MAPPER);
    }

    /**
     * 登録されている衣類の色を重複なく取得する.
     *
     * @return 色の一覧。
     */
    public List<String> colorList() {
        String sql = """
            SELECT DISTINCT
                color
            FROM
                clothes
            """;

        return template.query(sql, (rs, rowNum) -> rs.getString("color"));
    }
}
