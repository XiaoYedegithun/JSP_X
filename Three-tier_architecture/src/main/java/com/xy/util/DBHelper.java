package com.xy.util;

import java.sql.*;

public class DBHelper {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/jsp_x?useUnicode=true&useSSL=false&characterEncoding=UTF8&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getCon() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    private static void close(Statement pr) {
        try {
            if (pr != null && !pr.isClosed()) {
                pr.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void close(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void close(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rs, Statement pr, Connection con) {
        close(rs);
        close(pr);
        close(con);
    }
}
