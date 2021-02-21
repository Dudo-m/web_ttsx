package com.edu.dao;

import com.edu.entity.Good;
import com.edu.utils.Page;
import com.edu.utils.Shop;

import java.util.List;


public interface GoodDao extends BaseDao<Good>{
    Page findByFenYe(Page page);

    List<Good> findByType(String type,int num);

    List<Shop> findShopByUserId(int userId);

    boolean updateShop(int gId, int user_id);

    boolean insertShop(int gId, int user_id);

    boolean deleteShopByUIdAndGId(int gId, int user_id);

    Page searchByFenye(Page page);
}
