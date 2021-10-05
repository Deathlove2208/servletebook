package com.mycompany.controller;

import com.mycompany.dao.DAO;
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
       

    public home() {
    	super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        DAO dao = new DAO();
//        List<Book> books = dao.getAllBook();
//        request.setAttribute("books", books);
        RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");  
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}