package com.barapp.LucasLejeune.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConfig {
       private static final String URL = "jdbc:mysql://localhost:3306/ExamenDatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws SQLException {
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            throw new SQLException("Driver non trouvé", e);
        }
        return DriverManager.getConnection(URL,USER, PASSWORD);
    }
}
