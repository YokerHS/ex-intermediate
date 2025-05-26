package com.example.ex_intermediate.repository;

import com.example.ex_intermediate.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public NamedParameterJdbcTemplate template;

    /**
     * チーム情報をすべて取得します.
     *
     * @return チームの一覧リスト
     */
    public List<Team> findAllTeams() {
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
    """;

        return template.query(sql, TEAM_ROW_MAPPER);
    }


}
