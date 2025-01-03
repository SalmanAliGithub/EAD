package com.example.bookstore.Task_5;

import com.example.bookstore.Task_5.BookDAO ;
import com.example.bookstore.Task_5.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DisplayBooksServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type for the response (HTML)
        response.setContentType("text/html");

        // Get the list of books from the database
        BookDAO bookDAO = new BookDAO();
        List<Book> books = bookDAO.getAllBooks();

        // Use PrintWriter to write HTML response
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Book List</title></head>");
        out.println("<body>");
        out.println("<h1>List of Books</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Title</th><th>Author</th><th>Price</th><th>Genre</th></tr>");

        // Loop through the list of books and display them
        for (Book book : books) {
            out.println("<tr>");
            out.println("<td>" + book.getTitle() + "</td>");
            out.println("<td>" + book.getAuthor() + "</td>");
            out.println("<td>" + book.getPrice() + "</td>");
            out.println("<td>" + book.getGenre() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
