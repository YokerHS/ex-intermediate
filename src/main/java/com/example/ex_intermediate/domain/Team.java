package com.example.ex_intermediate.domain;

import lombok.Data;

@Data
public class Team {
    /** チームのID */
    private Integer id;
    /** 所属リーグ名 */
    private String leagueName;
    /** チーム名 */
    private String teamName;
    /** 本部の所在地住所 */
    private String headquarters;
    /** 就任式の日付 */
    private String inauguration;
    /** チームの歴史 */
    private String history;
}

