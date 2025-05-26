package com.example.ex_intermediate.domain;

import lombok.Data;
/**
 * 服情報を表すドメイン.
 *
 */
@Data
public class Cloth {
    /** 衣類のID */
    private Integer id;
    /** カテゴリー */
    private String category;
    /** ジャンル */
    private String genre;
    /** 性別 */
    private Integer gender;
    /** 色 */
    private String color;
    /** 価格（円） */
    private Integer price;
    /** サイズ */
    private String size;
}
