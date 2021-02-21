package com.edu.dao;

import com.edu.entity.Good;
import com.edu.entity.User;
import com.edu.utils.DBUtils;
import com.edu.utils.Page;
import com.edu.utils.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodDaoImp implements GoodDao{
    @Override
    public boolean insert(Good good) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Good good) {
        return false;
    }

    @Override
    public Good findById(int id) {
        Good good = new Good();
        Connection conn = null;
        DBUtils dbUtils = new DBUtils();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = dbUtils.getConn();
            String sql = "SELECT * FROM tb_goods WHERE gId = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                good.setgId(id);
                good.setgBrief(resultSet.getString("gBrief"));
                good.setgName(resultSet.getString("gName"));
                good.setgPrice(resultSet.getDouble("gPrice"));
                good.setgCompany(resultSet.getString("gCompany"));
                good.setgStock(resultSet.getString("gStock"));
                good.setgImage(resultSet.getString("gImage"));
                good.setgType(resultSet.getString("gType"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(conn,preparedStatement,resultSet);
        }
        return good;
    }

    @Override
    public List<Good> findAll() {
        return null;
    }

    @Override
    public Page findByFenYe(Page page) {
        Connection conn = null;
        DBUtils dbUtils = new DBUtils();
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        try {
            conn=dbUtils.getConn();
            String sql = "{call pro_fenye(?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);

            //6个输入
            callableStatement.setString(1,"tb_goods");
            callableStatement.setString(2,"*");
            callableStatement.setString(3,null);
            callableStatement.setString(4,null);
            callableStatement.setInt(5,page.getPageSize());
            callableStatement.setInt(6,page.getCurrentPage());
            //2个输出
            callableStatement.registerOutParameter(7, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(8, java.sql.Types.INTEGER);

            callableStatement.execute();

            int totalSize = callableStatement.getInt(7);
            int totalPage = callableStatement.getInt(8);

            resultSet = callableStatement.getResultSet();

            List<Good> data = new ArrayList<>();

            while (resultSet.next()){
                Good good = new Good();
                good.setgId(resultSet.getInt("gId"));
                good.setgBrief(resultSet.getString("gBrief"));
                good.setgName(resultSet.getString("gName"));
                good.setgPrice(resultSet.getDouble("gPrice"));
                good.setgCompany(resultSet.getString("gCompany"));
                good.setgStock(resultSet.getString("gStock"));
                good.setgImage(resultSet.getString("gImage"));
                good.setgType(resultSet.getString("gType"));
                data.add(good);
            }
            page.setTotalSize(totalSize);
            page.setTotalPage(totalPage);
            page.setData(data);
            page.setLast(totalPage);

            if (page.getCurrentPage()<=1){
                page.setPrevious(1);
            }else {
                page.setPrevious(page.getCurrentPage()-1);
            }
            if (page.getCurrentPage()>=totalPage){
                page.setNext(totalPage);
            }else {
                page.setNext(page.getCurrentPage()+1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(conn,callableStatement,resultSet);
        }
        return page;
    }

    @Override
    public List<Good> findByType(String type, int num) {
        Connection conn = null;
        DBUtils dbUtils = new DBUtils();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Good> list= new ArrayList<>();
        try {
            conn = dbUtils.getConn();
            String sql = "select * from tb_goods where gType=? limit 0,?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,type);
            preparedStatement.setInt(2,num);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Good good = new Good();
                good.setgId(resultSet.getInt("gId"));
                good.setgBrief(resultSet.getString("gBrief"));
                good.setgName(resultSet.getString("gName"));
                good.setgPrice(resultSet.getDouble("gPrice"));
                good.setgCompany(resultSet.getString("gCompany"));
                good.setgStock(resultSet.getString("gStock"));
                good.setgImage(resultSet.getString("gImage"));
                good.setgType(resultSet.getString("gType"));
                list.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(conn,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<Shop> findShopByUserId(int userId) {
        Connection conn = null;
        DBUtils dbUtils = new DBUtils();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Shop> list = new ArrayList<>();
        try {
            conn = dbUtils.getConn();
            String sql = "select sId,tb_shop.gId gId,num,gBrief,gPrice,gCompany,gStock,gImage,gType,gName " +
                    "from tb_shop  LEFT JOIN tb_goods on tb_shop.gId = tb_goods.gId where uId = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,userId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Shop shop = new Shop();
                Good good = new Good();
                good.setgId(resultSet.getInt("gId"));
                good.setgBrief(resultSet.getString("gBrief"));
                good.setgName(resultSet.getString("gName"));
                good.setgPrice(resultSet.getDouble("gPrice"));
                good.setgCompany(resultSet.getString("gCompany"));
                good.setgStock(resultSet.getString("gStock"));
                good.setgImage(resultSet.getString("gImage"));
                good.setgType(resultSet.getString("gType"));
                shop.setsId(resultSet.getInt("sId"));
                shop.setNum(resultSet.getInt("num"));
                shop.setGood(good);
                list.add(shop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(conn,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public boolean updateShop(int gId, int user_id) {
        boolean flag = false;
        Connection conn = null;
        DBUtils dbUtils = new DBUtils();
        PreparedStatement preparedStatement = null;
        try {
            //创建连接
            conn = dbUtils.getConn();
            //准备sql语句
            String sql = "UPDATE tb_shop SET num = num+1 where uId=? AND gId=?";
            //预编译sql语句
            preparedStatement = conn.prepareStatement(sql);
            //给？赋值
            preparedStatement.setInt(1,user_id);
            preparedStatement.setInt(2,gId);
            //执行并得到结果
            //sql执行影响数据库表的行数
            int n = preparedStatement.executeUpdate();
            flag = n > 0 ?true : false;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(conn,preparedStatement,null);
        }
        return flag;
    }

    @Override
    public boolean insertShop(int gId, int user_id) {
        boolean flag = false;
        Connection conn = null;
        DBUtils dbUtils = new DBUtils();
        PreparedStatement preparedStatement = null;
        try {
            //创建连接
            conn = dbUtils.getConn();
            //准备sql语句
            String sql = "INSERT INTO tb_shop(uId,gId,num) VALUES (?,?,?)";
            //预编译sql语句
            preparedStatement = conn.prepareStatement(sql);
            //给？赋值
            preparedStatement.setInt(1,user_id);
            preparedStatement.setInt(2,gId);
            preparedStatement.setInt(3,1);

            //执行并得到结果
            //sql执行影响数据库表的行数
            int n = preparedStatement.executeUpdate();
            flag = n > 0 ?true : false;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(conn,preparedStatement,null);
        }
        return flag;
    }

    @Override
    public boolean deleteShopByUIdAndGId(int gId, int user_id) {
        boolean flag = false;
        DBUtils dbUtils = new DBUtils();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dbUtils.getConn();
            String sql = "delete from tb_shop where uId = ? AND gId = ?";
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1,user_id);
            preparedStatement.setInt(2,gId);

            flag = preparedStatement.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(connection,preparedStatement,null);
        }
        return flag;
    }

    @Override
    public Page searchByFenye(Page page) {
        Connection conn = null;
        DBUtils dbUtils = new DBUtils();
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        try {
            conn=dbUtils.getConn();
            String sql = "{call pro_fenye(?,?,?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);

            //6个输入
            callableStatement.setString(1,"tb_goods");
            callableStatement.setString(2,"*");
            callableStatement.setString(3,page.getWhereStr());
            callableStatement.setString(4,null);
            callableStatement.setInt(5,page.getPageSize());
            callableStatement.setInt(6,page.getCurrentPage());
            //2个输出
            callableStatement.registerOutParameter(7, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(8, java.sql.Types.INTEGER);

            callableStatement.execute();

            int totalSize = callableStatement.getInt(7);
            int totalPage = callableStatement.getInt(8);

            resultSet = callableStatement.getResultSet();

            List<Good> data = new ArrayList<>();

            while (resultSet.next()){
                Good good = new Good();
                good.setgId(resultSet.getInt("gId"));
                good.setgBrief(resultSet.getString("gBrief"));
                good.setgName(resultSet.getString("gName"));
                good.setgPrice(resultSet.getDouble("gPrice"));
                good.setgCompany(resultSet.getString("gCompany"));
                good.setgStock(resultSet.getString("gStock"));
                good.setgImage(resultSet.getString("gImage"));
                good.setgType(resultSet.getString("gType"));
                data.add(good);
            }
            page.setTotalSize(totalSize);
            page.setTotalPage(totalPage);
            page.setData(data);
            page.setLast(totalPage);

            if (page.getCurrentPage()<=1){
                page.setPrevious(1);
            }else {
                page.setPrevious(page.getCurrentPage()-1);
            }
            if (page.getCurrentPage()>=totalPage){
                page.setNext(totalPage);
            }else {
                page.setNext(page.getCurrentPage()+1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(conn,callableStatement,resultSet);
        }
        return page;
    }
}
