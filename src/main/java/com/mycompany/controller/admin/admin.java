package com.mycompany.controller.admin;

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



@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class admin extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private List<Book> books;
    private BookDAO bookDAO;
    public admin() {
        super();
        this.bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.books = this.bookDAO.getBooks("");
        request.setAttribute("books", this.books);
        RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
        rd.forward(request, response);
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String img = request.getParameter("img");
        String detail = request.getParameter("detail");
        Book book = new Book();
        book.setTitle(title);
        book.setImg(img);
        book.setDetail(detail);
        boolean inserted = this.bookDAO.insertBook(book);
        if(inserted) {
            response.sendRedirect("admin");
        }
        
    }


}
