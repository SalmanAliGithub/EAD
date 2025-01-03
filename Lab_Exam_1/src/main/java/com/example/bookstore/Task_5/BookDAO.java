package com.example.bookstore.Task_5;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_db";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "password";

//    List method
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setGenre(rs.getString("genre"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
    
    
 // Delete method a book by ID
    public boolean deleteBook(int bookId) {
        String query = "DELETE FROM books WHERE id = ?";
        boolean isDeleted = false;

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the bookId in the prepared statement
            stmt.setInt(1, bookId);

            // Execute the delete operation
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                isDeleted = true; // Book deleted successfully
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDeleted;
    }
}

