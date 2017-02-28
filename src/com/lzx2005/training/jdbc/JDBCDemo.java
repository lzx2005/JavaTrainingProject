package com.lzx2005.training.jdbc;


import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by Lizhengxian on 2017/2/28.
 */
public class JDBCDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class<?> driver = Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println(driver);
        Driver jdbcDriver = (Driver) driver.newInstance();
        Properties properties = new Properties();
        String url = "jdbc:mysql://localhost:3306/lzx2005";
        properties.setProperty("user","root");
        properties.setProperty("password","459697036");

        boolean b = jdbcDriver.acceptsURL(url);
        System.out.println(b);
        Connection connect = jdbcDriver.connect(url, properties);
        System.out.println(connect);

        Statement statement = connect.createStatement();
        String sql = "select * from user";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("password"));
        }
    }
}
