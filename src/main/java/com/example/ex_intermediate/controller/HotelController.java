package com.example.ex_intermediate.controller;

import com.example.ex_intermediate.domain.Hotel;
import com.example.ex_intermediate.form.SearchForm;
import com.example.ex_intermediate.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ホテル検索画面のリクエストを処理するコントローラークラス.
 * <p>
 * ユーザーからのリクエストに応じて、ホテルの一覧表示や、
 * 指定された価格以下のホテルの検索結果を返す。
 * </p>
 */
@Controller
@RequestMapping("hotel")
public class HotelController {

    private static final Integer MAX = 300000;

    @Autowired
    private HotelService hotelService;

    /**
     * ホテル検索画面を表示する.
     *
     * @return ホテル検索画面
     */
    @GetMapping("")
    public String search(Model model,SearchForm form) {
        return "search-by-less-than-price";
    }

    /**
     * 指定された価格以下のホテルを検索し、結果を表示する.
     * <ul>
     *     <li>価格が未入力または空の場合は全件取得</li>
     *     <li>数値でない場合はエラーメッセージを表示</li>
     * </ul>
     *
     * @param price 入力された価格（文字列）
     * @param model ビューにデータを渡すためのModelオブジェクト
     * @return 検索結果画面
     */
    @PostMapping("/result")
    public String result(@Validated SearchForm form,
                         BindingResult result,
                         Model model) {

        if (result.hasErrors()) {
            return search(model,form);
        }

        if (!form.getPrice().isBlank() && Integer.parseInt(form.getPrice()) > MAX ){
            model.addAttribute("max","値段は最大30万円までの入力にしてください");
            return "search-by-less-than-price";
        }

        List<Hotel> hotelList = hotelService.searchByLessThanPrice(form.getPrice());

        if (hotelList.isEmpty()) {
            model.addAttribute("searchPrice",form.getPrice());
            model.addAttribute("blank","円以下のホテル情報は存在しません");
            return "search-by-less-than-price";
        }

        model.addAttribute("hotelList", hotelList);

        return "search-by-less-than-price";
    }
}






