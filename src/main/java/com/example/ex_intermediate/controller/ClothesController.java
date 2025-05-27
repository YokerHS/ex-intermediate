package com.example.ex_intermediate.controller;

import com.example.ex_intermediate.domain.Clothes;
import com.example.ex_intermediate.enums.Gender;
import com.example.ex_intermediate.form.SearchByGenderAndColorForm;
import com.example.ex_intermediate.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 衣類検索に関するリクエストを処理するコントローラークラス.
 *
 * ユーザーは性別と色を指定して衣類を検索することができる。
 */
@Controller
@RequestMapping("clothes")
public class ClothesController {

    /**
     * 衣類検索のサービスクラス。
     */
    @Autowired
    private ClothesService clothesService;

    /**
     * 初期表示処理。検索フォームを表示する.
     *
     * @param form  入力フォーム（バインドオブジェクト）
     * @param model モデルオブジェクト。性別や色の選択肢などをビューに渡す。
     * @return 検索フォーム画面のテンプレート名（search-by-color-and-gender）
     */
    @GetMapping("")
    public String search(SearchByGenderAndColorForm form, Model model) {
//        model.addAttribute("form", form);
        model.addAttribute("colors", clothesService.getColorList());
        model.addAttribute("genders", Gender.values());
        return "search-by-color-and-gender";
    }

    /**
     * 検索処理。フォームで指定された条件に基づいて衣類を検索し、結果を表示する.
     *
     * @param form  入力フォーム（性別と色）
     * @param model モデルオブジェクト。検索結果や選択肢をビューに渡す。
     * @return 検索結果表示画面のテンプレート名（search-by-color-and-gender）
     */
    @PostMapping("/search")
    public String searchResult(SearchByGenderAndColorForm form, Model model) {
//        model.addAttribute("form", form);
        model.addAttribute("colors", clothesService.getColorList());
        model.addAttribute("genders", Gender.values());

        List<Clothes> clothesList = clothesService.searchByColorAndGender(form.getColor(), form.getGender());
        if (clothesList.isEmpty()) {
            model.addAttribute("empty","検索結果に合うものはありません。");
            return "search-by-color-and-gender";
        }

        model.addAttribute("clothes", clothesList);
        return "search-by-color-and-gender";
    }
}
