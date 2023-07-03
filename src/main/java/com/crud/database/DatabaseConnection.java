package com.crud.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//This includes getConnection and closeConnection methods
public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/student";
    private static final String username = "root";
    private static final String password = "bishal";

    //establish connection with db

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        if (connection != null) {
            System.out.println("Database connection Successful :)");
        }
        return connection;
    }
    //close connection with db
    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}
