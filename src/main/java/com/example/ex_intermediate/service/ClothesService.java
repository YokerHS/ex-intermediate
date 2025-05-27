package com.example.ex_intermediate.service;

import com.example.ex_intermediate.domain.Clothes;
import com.example.ex_intermediate.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 衣類に関するビジネスロジックを扱うサービスクラス.
 *
 * 主にリポジトリ層を呼び出して、検索や色の取得処理を提供する。
 */
@Service
public class ClothesService {

    /** 衣類情報にアクセスするリポジトリ */
    @Autowired
    private ClothesRepository clothesRepository;

    /**
     * 指定された色と性別に基づいて衣類を検索する.
     *
     * @param color  色
     * @param gender 性別コード（0: 男性, 1: 女性）
     * @return 条件に一致する衣類のリスト。該当がない場合は空リスト。
     */
    public List<Clothes> searchByColorAndGender(String color, Integer gender) {
        return clothesRepository.findByColorAndGender(color, gender);
    }

    /**
     * データベースに登録されている衣類の色を一覧で取得する.
     *
     * @return 色のリスト（重複なし）。
     */
    public List<String> getColorList() {
        return clothesRepository.colorList();
    }
}
