package com.mycompany.controller.doc;

import com.mycompany.dao.BookDAO;
import com.mycompany.model.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "doc", urlPatterns = {"/doc"})
public class doc extends HttpServlet {

    private Book book;
    private BookDAO bookDAO;
    public doc() {
        super();
        this.bookDAO = new BookDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("q"));
        
        this.book = this.bookDAO.getBookById(id);
        this.bookDAO.setViewOfBook(id);
        request.setAttribute("book", book);
        RequestDispatcher rd = request.getRequestDispatcher("docScreen.jsp");
        rd.forward(request, response);
        
    }
}
