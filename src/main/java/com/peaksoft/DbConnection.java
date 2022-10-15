package com.peaksoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String name = "postgres";
    private static final String password = "bayaliev01";
    private static final String url = "jdbc:postgresql://localhost:5432/jdbc_java7";

    public static Connection connection() {
        Connection connection2 = null;
        try {
            connection2 = DriverManager.getConnection(url, name, password);
            System.out.println("Connection успешно создано");
        } catch (SQLException e) {
            e.getMessage();
        }
        return connection2;
    }
}
