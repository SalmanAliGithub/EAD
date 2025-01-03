package com.example.bookstore.Task_4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BookRegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Getting parameters from the form
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");

        // For now, just printing the values (you can add JDBC logic here later to save the book data)
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Book Registered Successfully!</h3>");
        out.println("<p>Title: " + title + "</p>");
        out.println("<p>Author: " + author + "</p>");
        out.println("<p>Price: " + price + "</p>");
        out.println("</body></html>");
    }
}
