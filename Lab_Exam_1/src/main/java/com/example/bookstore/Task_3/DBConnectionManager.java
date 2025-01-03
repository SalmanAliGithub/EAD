package com.example.bookstore.Task_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DBConnectionManager {
    private String url = "jdbc:mysql://localhost:3306/BookstoreDB"; // 'BookstoreDB' is the DB we did
    private String user = "root"; //  'root' is my MySQL username
    private String password = "faris@mysql"; // the password for my root
    private Connection connection;

    public Connection openConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection opened successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to open connection.");
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed successfully!");
            } catch (SQLException e) {
                System.out.println("Failed to close connection.");
                e.printStackTrace();
            }
        }
    }
}
