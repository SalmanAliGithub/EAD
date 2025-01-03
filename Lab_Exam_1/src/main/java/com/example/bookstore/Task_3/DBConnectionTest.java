package com.example.bookstore.Task_3;

import java.sql.Connection;

public class DBConnectionTest {
    public static void main(String[] args) {
        DBConnectionManager dbManager = new DBConnectionManager();
        Connection connection = dbManager.openConnection();
        
        if (connection != null) {
            System.out.println("Database connection test passed!");
        } else {
            System.out.println("Database connection test failed.");
        }
        
        dbManager.closeConnection();
    }
}
