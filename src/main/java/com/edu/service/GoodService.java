package com.edu.service;

import com.edu.entity.Good;
import com.edu.utils.Page;
import com.edu.utils.Shop;

import java.util.List;

public interface GoodService {
    Good selectGoodById(int gId);
    //分页查询所有
    Page selectByFenYe(int currentPage);

    List<Good> selectByType(String type);

    List<Shop> selectShopByUserId(int userId);

    boolean addShop(int gId, int user_id);

    boolean deleteShopByUIdAndGId(int gId, int user_id);

    Page searchByFenYe(int currentPage,String search);
}
