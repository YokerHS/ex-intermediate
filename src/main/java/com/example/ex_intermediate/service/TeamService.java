package com.example.ex_intermediate.service;

import com.example.ex_intermediate.domain.Team;
import com.example.ex_intermediate.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * チーム情報を操作するサービス.
 *
 */
@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    /**
     * すべてのチーム情報を取得して返します.
     *
     * @return チームの一覧リスト
     */
    public List<Team> showList() {
        return teamRepository.findAll();
    }

    /**
     * 指定されたIDに対応するチーム情報を取得します.
     *
     * @param id チームのID
     * @return 該当するチーム情報
     */
    public Team showDetail(Integer id) {
        return teamRepository.findByID(id);
    }

}
