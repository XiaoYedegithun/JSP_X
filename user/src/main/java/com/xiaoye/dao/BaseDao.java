package com.xiaoye.dao;


import java.sql.*;

public class BaseDao {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/jsp_x?characterEncoding=utf-8&serverTimezone=GMT&useSSL=false";
    private static final String name = "root";
    private static final String password = "123456";

    public static Connection getcon() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeAll(ResultSet rs, Statement sta, Connection connection) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (sta != null) {
                sta.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
