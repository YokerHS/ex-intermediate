package com.example.ex_intermediate.enums;

import lombok.Getter;

/**
 * 性別を表す列挙型.
 *
 * 男性（MALE）と女性（FEMALE）を整数コードと日本語ラベルで保持する。
 */
@Getter
public enum Gender {
    /**
     * 男性（コード: 0, ラベル: "男"）
     */
    MALE(0, "男"),

    /**
     * 女性（コード: 1, ラベル: "女"）
     */
    FEMALE(1, "女");

    /** 性別を表す整数コード（0: 男, 1: 女） */
    private final int code;

    /** 性別を表すラベル（表示用の日本語） */
    private final String label;

    /**
     * コンストラクタ。
     *
     * @param code  性別コード
     * @param label 表示用ラベル
     */
    Gender(int code, String label) {
        this.code = code;
        this.label = label;
    }

    /**
     * 性別コードに対応する {@link Gender} を返す。
     *
     * @param code 性別コード（0 または 1）
     * @return 対応する {@link Gender} オブジェクト
     * @throws IllegalArgumentException 指定されたコードに対応する性別が存在しない場合
     */
    public static Gender fromCode(int code) {
        for (Gender g : Gender.values()) {
            if (g.code == code) {
                return g;
            }
        }
        throw new IllegalArgumentException("Invalid gender code: " + code);
    }
}
