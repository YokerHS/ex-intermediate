package com.example.ex_intermediate.service;

import com.example.ex_intermediate.domain.Hotel;
import com.example.ex_intermediate.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ホテル情報を操作するサービス.
 *
 */
@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    /**
     * すべてのホテル情報を取得する.
     *
     * @return ホテルのリスト
     */
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    /**
     * 指定された価格以下のホテル情報を検索する.
     *
     * @param price 上限価格（この価格以下のホテルを取得）
     * @return 条件に一致するホテルのリスト
     */
    public List<Hotel> searchByLessThanPrice(Integer price) {
        return hotelRepository.searchByLessThanPrice(price);
    }
}

