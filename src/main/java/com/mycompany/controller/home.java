package com.mycompany.controller;

import com.mycompany.dao.BookDAO;
import com.mycompany.model.Book;
import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"", "/home"})
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        
    private List<Book> books;
    private final BookDAO bookDAO;
    public home() {
    	super();
        this.bookDAO = new BookDAO();
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        this.books = this.bookDAO.getBooks();
        request.setAttribute("books", this.books);
        RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");  
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

    }
}