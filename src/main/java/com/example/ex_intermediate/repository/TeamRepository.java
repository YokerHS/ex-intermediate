package com.example.ex_intermediate.repository;

import com.example.ex_intermediate.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * teamsテーブルを操作するリポジトリ.
 *
 */
@Repository
public class TeamRepository {
    /**
     * Teamオブジェクトを生成するローマッパー.
     */
//    private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
//        Team team = new Team();
//        team.setId(rs.getInt("id"));
//        return team;
//    };
    private static final RowMapper<Team> TEAM_ROW_MAPPER = new BeanPropertyRowMapper<>(Team.class);

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * チーム情報をすべて取得します.
     *
     * @return チームの一覧リスト
     */
    public List<Team> findAll() {
        String sql = """
                    SELECT
                        id,
                        league_name,
                        team_name,
                        headquarters,
                        inauguration,
                        history
                    FROM
                        teams
                    ORDER BY inauguration
                """;

        return template.query(sql, TEAM_ROW_MAPPER);
    }


    /**
     * 指定されたIDのチーム情報を1件取得します.
     *
     * @param id チームのID
     * @return 該当するチーム情報
     */
    public Team findByID(Integer id) {
        String sql = """
        SELECT
            id,
            league_name,
            team_name,
            headquarters,
            inauguration,
            history
        FROM
            teams
        WHERE
            id = :id
    """;
        List<Team> list = new ArrayList<>();
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        list.add(template.queryForObject(sql, param, TEAM_ROW_MAPPER));
        return list.getFirst();
    }

}
