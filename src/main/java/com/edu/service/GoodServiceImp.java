package com.edu.service;

import com.edu.dao.GoodDao;
import com.edu.dao.GoodDaoImp;
import com.edu.entity.Good;
import com.edu.utils.Page;
import com.edu.utils.Shop;

import java.util.List;

public class GoodServiceImp implements GoodService{
    GoodDao goodDao = new GoodDaoImp();
    @Override
    public Good selectGoodById(int gId) {
        return goodDao.findById(gId);
    }

    //分页查询所有
    @Override
    public Page selectByFenYe(int currentPage) {
        Page page = new Page(10,currentPage);
        return goodDao.findByFenYe(page);
    }

    @Override
    public List<Good> selectByType(String type) {
        return goodDao.findByType(type,4);
    }
    //根据用户id查购物车
    @Override
    public List<Shop> selectShopByUserId(int userId) {
        return goodDao.findShopByUserId(userId);
    }

    @Override
    public boolean addShop(int gId, int user_id) {
        //判断是否已存在，存在则加一，不存在则添加
        List<Shop> list = goodDao.findShopByUserId(user_id);
        boolean flag = false;
        for (Shop shop : list) {
            if (shop.getGood().getgId()==gId) {
                flag = true;
                break;
            }
        }
        if (flag){
            return goodDao.updateShop(gId,user_id);
        }else {
            return goodDao.insertShop(gId,user_id);
        }
    }

    @Override
    public boolean deleteShopByUIdAndGId(int gId, int user_id) {
        return goodDao.deleteShopByUIdAndGId(gId,user_id);
    }

    @Override
    public Page searchByFenYe(int currentPage,String search) {
        Page page = new Page(10,currentPage);
        //测试用
//        Page page = new Page(2,currentPage);

        page.setWhereStr("and gName like '%"+search+"%'");
        return goodDao.searchByFenye(page);
    }
}
