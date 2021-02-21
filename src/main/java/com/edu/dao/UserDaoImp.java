package com.edu.dao;

import com.edu.entity.Address;
import com.edu.entity.User;
import com.edu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImp implements UserDao {

    //根据账号查用户
    @Override
    public User selectUserByAccount(String user_account) {
        User user = null;
        Connection conn = null;
        DBUtils dbUtils = new DBUtils();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = dbUtils.getConn();
            String sql = "SELECT * FROM tb_user WHERE user_account = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,user_account);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                int user_id = resultSet.getInt("user_id");
                String user_password = resultSet.getString("user_password");
                String user_email = resultSet.getString("user_email");
                user = new User(user_id,user_account,user_password,user_email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(conn,preparedStatement,resultSet);
        }
        return user;
    }

    @Override
    public Address findAddressByUId(int user_id) {
        Address address = new Address();
        Connection conn = null;
        DBUtils dbUtils = new DBUtils();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = dbUtils.getConn();
            String sql = "SELECT * FROM tb_address WHERE uId = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,user_id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
               address.setaId(resultSet.getInt("aId"));
               address.setuId(user_id);
               address.setaAddress(resultSet.getString("aAddress"));
               address.setaConsignee(resultSet.getString("aConsignee"));
               address.setaPC(resultSet.getInt("aPC"));
               address.setaPhone(resultSet.getString("aPhone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(conn,preparedStatement,resultSet);
        }
        return address;
    }

    @Override
    public boolean insertAddress(Address address) {
        boolean flag = false;
        Connection conn = null;
        DBUtils dbUtils = new DBUtils();
        PreparedStatement preparedStatement = null;
        try {
            //创建连接
            conn = dbUtils.getConn();
            //准备sql语句
            String sql = "INSERT INTO tb_address(uId,aConsignee,aAddress,aPC,aPhone) VALUES (?,?,?,?,?)";
            //预编译sql语句
            preparedStatement = conn.prepareStatement(sql);
            //给？赋值
            preparedStatement.setInt(1,address.getuId());
            preparedStatement.setString(2,address.getaConsignee());
            preparedStatement.setString(3,address.getaAddress());
            preparedStatement.setInt(4,address.getaPC());
            preparedStatement.setString(5,address.getaPhone());
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
    public boolean updateAddress(Address address) {
        boolean flag = false;
        Connection conn = null;
        DBUtils dbUtils = new DBUtils();
        PreparedStatement preparedStatement = null;
        try {
            //创建连接
            conn = dbUtils.getConn();
            //准备sql语句
            String sql = "UPDATE tb_address SET aConsignee=?,aAddress=?,aPC=?,aPhone=? where uId=?";
            //预编译sql语句
            preparedStatement = conn.prepareStatement(sql);
            //给？赋值
            preparedStatement.setString(1,address.getaConsignee());
            preparedStatement.setString(2,address.getaAddress());
            preparedStatement.setInt(3,address.getaPC());
            preparedStatement.setString(4,address.getaPhone());
            preparedStatement.setInt(5,address.getuId());
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

    //添加用户
    @Override
    public boolean insert(User user) {
        boolean flag = false;
        Connection conn = null;
        DBUtils dbUtils = new DBUtils();
        PreparedStatement preparedStatement = null;
        try {
            //创建连接
            conn = dbUtils.getConn();
            //准备sql语句
            String sql = "INSERT INTO tb_user(user_account,user_password,user_email) VALUES (?,?,?)";
            //预编译sql语句
            preparedStatement = conn.prepareStatement(sql);
            //给？赋值
            preparedStatement.setString(1,user.getUser_account());
            preparedStatement.setString(2,user.getUser_password());
            preparedStatement.setString(3,user.getUser_email());
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
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }


    @Override
    public User findById(int id) {
        User user = null;
        Connection conn = null;
        DBUtils dbUtils = new DBUtils();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = dbUtils.getConn();
            String sql = "SELECT * FROM tb_user WHERE user_id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                String user_account = resultSet.getString("user_account");
                String user_password = resultSet.getString("user_password");
                String user_email = resultSet.getString("user_email");
                user = new User(id,user_account,user_password,user_email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(conn,preparedStatement,resultSet);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
