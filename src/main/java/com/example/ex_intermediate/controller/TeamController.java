package com.example.ex_intermediate.controller;

import com.example.ex_intermediate.domain.Team;
import com.example.ex_intermediate.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * チーム情報を操作するコントローラー.
 *
 */
@Controller
@RequestMapping("team")
public class TeamController {
    @Autowired
    public TeamService teamService;

    /**
     * チームの一覧を表示する.
     *
     * @param model モデル
     * @return チームの一覧画面
     */
    @GetMapping("list")
    public String showAllTeams(Model model){
        List<Team> teamList = teamService.showList();
        model.addAttribute("teamList",teamList);
        return "show-all-teams";
    }

    /**
     * チームIDに基づいてチームの詳細情報を表示します.
     *
     * @param id チームのID
     * @param model モデルオ
     * @return 詳細画面
     */
    @GetMapping("showDetail")
    public String showTeamDetail(@RequestParam("id") Integer id, Model model) {
        Team team = teamService.showDetail(id);
        model.addAttribute("team", team);
        return "show-team-detail";
    }


}
