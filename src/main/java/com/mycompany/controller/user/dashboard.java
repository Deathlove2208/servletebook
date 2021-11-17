package com.mycompany.controller.user;

import com.mycompany.dao.BookDAO;
import com.mycompany.model.Book;
import com.mycompany.model.User;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "dashboard", urlPatterns = {"/dashboard"})
public class dashboard extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private List<Book> books;
    private BookDAO bookDAO;
    public dashboard() {
        super();
        this.bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("userInfo");
    	this.books = this.bookDAO.getBooksByAuthor(user.getUsername());
        request.setAttribute("books", this.books);
        RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
        rd.forward(request, response);
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
    }


}
