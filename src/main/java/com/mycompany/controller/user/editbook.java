package com.mycompany.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.dao.BookDAO;
import com.mycompany.model.Book;

@WebServlet(name = "editbook", urlPatterns = {"/book/edit"})
public class editbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
    public editbook() {
        super();
        this.bookDAO = new BookDAO();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("b"));
		Book book = bookDAO.getBookById(id);
        request.setAttribute("book", book);
        RequestDispatcher rd = request.getRequestDispatcher("/editBook.jsp");
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("b"));
		String title = request.getParameter("title");
		String img = request.getParameter("img");
		String detail = request.getParameter("detail");
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setImg(img);
		book.setDetail(detail);
		boolean res = bookDAO.updateBook(book);
		if(res) response.sendRedirect("/ebook/dashboard");


	}

}
