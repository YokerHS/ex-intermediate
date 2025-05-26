package com.example.ex_intermediate.controller;

import com.example.ex_intermediate.domain.Hotel;
import com.example.ex_intermediate.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    private HotelService hotelService;

    /**
     * ホテル検索画面を表示する.
     *
     * @return ホテル検索画面
     */
    @GetMapping("")
    public String search() {
        return "search-byr-less-than-price";
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
    @PostMapping("result")
    public String result(String price, Model model) {
        List<Hotel> hotelList;

        // 入力が空または未指定なら、全件表示
        if (price == null || price.isBlank()) {
            hotelList = hotelService.findAll();
            model.addAttribute("hotelList", hotelList);
            return "search-byr-less-than-price";
        }

        // 数値でない場合はエラー
        try {
            int priceValue = Integer.parseInt(price);
            hotelList = hotelService.searchByLessThanPrice(priceValue);
        } catch (NumberFormatException e) {
            model.addAttribute("error", "数字を入力してください。");
            return "search-byr-less-than-price";
        }

        // 正常時の結果表示
        model.addAttribute("hotelList", hotelList);
        return "search-byr-less-than-price";
    }
}






