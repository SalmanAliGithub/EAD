package com.example.bookstore.Task_6;

import com.example.bookstore.Task_5.BookDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the book ID from the request parameters
        String bookIdParam = request.getParameter("bookId");
        int bookId = Integer.parseInt(bookIdParam);

        // Initialize the BookDAO to perform the deletion
        BookDAO bookDAO = new BookDAO();
        boolean isDeleted = bookDAO.deleteBook(bookId);

        // Set content type for the response (HTML)
        response.setContentType("text/html");

        // Get the PrintWriter to write the response
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Delete Book</title></head>");
        out.println("<body>");
        
        if (isDeleted) {
            out.println("<h1>Book Deleted Successfully!</h1>");
        } else {
            out.println("<h1>Failed to Delete Book. Please try again.</h1>");
        }

        out.println("<a href='displayBooks'>Go back to Book List</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
