package com.jamith.AdyapanaInstituteApp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static Connection con;

    private static final String dbHost = "localhost";
    private static final String port = "3306";
    private static final String dbName = "adyapanainstitute";
    private static final String userName = "root";
    private static final String password = "Jamith@5000";

//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        connect();
//    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":" + port + "/" + dbName, userName, password);
    }

    public static Connection getConnection() throws Exception {
        if (con == null) {
            connect();
        }
        return con;
    }
}
