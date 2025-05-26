package com.example.ex_intermediate.service;

import com.example.ex_intermediate.domain.Team;
import com.example.ex_intermediate.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    /**
     * すべてのチーム情報を取得して返します。
     *
     * @return チームの一覧リスト
     */
    public List<Team> showAllTeams() {
        return teamRepository.findAllTeams();
    }

}
