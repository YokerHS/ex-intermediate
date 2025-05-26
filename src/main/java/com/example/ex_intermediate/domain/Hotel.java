package com.example.ex_intermediate.domain;

import lombok.Data;
/**
 * ホテル情報を表すドメイン.
 *
 */
@Data
public class Hotel {
    /** ホテルのID */
    private Integer id;
    /** エリア名 */
    private String areaName;
    /** ホテル名 */
    private String hotelName;
    /** 住所 */
    private String address;
    /** 最寄り駅 */
    private String nearestStation;
    /** 宿泊料金 */
    private Integer price;
    /** 駐車場情報（例：あり、なし） */
    private String parking;
}
