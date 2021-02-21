package com.edu.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
    //1.读取配置文件
    private DataSource dataSource = null;

    public DBUtils(){
        //读取配置文件
        InputStream inputStream
                = DBUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");

        //通过集合存储文件信息
        Properties properties = new Properties();

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建dataSource帮助类
        try {
             dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //2.创建连接,一个connection对象就是一个链接
    public Connection getConn(){
        Connection connection = null;
        //单例模式
        try {
            if (connection==null || connection.isClosed()){
                connection = dataSource.getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //3.关闭方法
    public void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet != null)resultSet.close();
            if(statement != null)statement.close();
            if(connection != null)connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        DBUtils dbUtils = new DBUtils();
//        dbUtils.getConn();
//        System.out.println("dbUtils = " + dbUtils);
//    }
}
