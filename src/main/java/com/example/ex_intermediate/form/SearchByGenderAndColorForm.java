package com.example.ex_intermediate.form;

import lombok.Data;

/**
 * 衣類検索フォームのデータを保持するフォームクラス.
 *
 * 性別と色の情報を受け取るために使用される。
 */
@Data
public class SearchByGenderAndColorForm {

    /**
     * 選択された性別のコード.
     *
     * {@link com.example.ex_intermediate.enums.Gender} の code に対応。
     */
    private Integer gender;

    /**
     * 選択された色.
     *
     * {@code ClothesService#getColorList()} によって提供される色の1つ。
     */
    private String color;
}
