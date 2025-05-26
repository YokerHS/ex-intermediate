package com.example.ex_intermediate.domain;

import lombok.Data;

@Data
public class Team {
    /**
     * チームのID
     */
    private Integer id;
    /**
     * リーグ名
     */
    private String leagueName;
    /**
     *チーム名
     */
    private String teamName;
    /**
     *本部住所
     */
    private String  headquarters;
    /**
     *就任式日
     */
    private String inauguration;
    /**
     *歴史
     */
    private String history;
}
