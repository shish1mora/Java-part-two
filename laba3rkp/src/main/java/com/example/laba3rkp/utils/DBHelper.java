package com.example.laba3rkp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/institut";
    private final static String LOGIN = "root";
    private final static String PASS = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, LOGIN, PASS);

    }
}
