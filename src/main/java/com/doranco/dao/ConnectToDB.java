package com.doranco.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author KAHILLL
 */
public  class ConnectToDB {
    private static Connection cnn;
    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String DATABASE_NAME = "fruitstore";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private ConnectToDB() {
    }

    public static Connection getConnection() throws Exception {
        if (cnn == null) {
            String url = "jdbc:mysql://" + HOST + ":" + PORT +  "/" + DATABASE_NAME;
            ConnectToDB.cnn = DriverManager.getConnection(url, USERNAME, PASSWORD);
        }
        return cnn;
    }

}