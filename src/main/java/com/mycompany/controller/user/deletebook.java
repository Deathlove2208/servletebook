package com.mycompany.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.dao.BookDAO;

@WebServlet(name = "deletebook", urlPatterns = {"/book/delete"})
public class deletebook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookDAO bookDAO;
    public deletebook() {
        super();
        this.bookDAO = new BookDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("b"));
		boolean res = this.bookDAO.deleteBook(id);
		if(res) response.sendRedirect("/ebook/dashboard");
		
	}

}
