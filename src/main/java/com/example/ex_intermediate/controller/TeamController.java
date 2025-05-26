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

@Controller
@RequestMapping("exam1")
public class TeamController {
    @Autowired
    public TeamService teamService;

    /**
     * チームの一覧を表示する
     *
     * @param model モデル
     * @return チームの一覧画面
     */
    @GetMapping("show-all-teams")
    public String showAllTeams(Model model){
        List<Team> teamList = teamService.showAllTeams();
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
    @GetMapping("show-team-detail")
    public String showTeamDetail(@RequestParam("id") Integer id, Model model) {
        Team team = teamService.findTeamById(id);
        String formattedHistory = team.getHistory().replace("\n", "<br>");
        team.setHistory(formattedHistory);
        System.out.println(team.getHistory());
        model.addAttribute("team", team);
        return "show-team-detail";
    }


}
