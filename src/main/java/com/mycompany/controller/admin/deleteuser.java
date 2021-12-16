package com.mycompany.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.dao.UserDAO;

@WebServlet(name = "deleteuser", urlPatterns = {"/user/delete"})
public class deleteuser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDAO;
    public deleteuser() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("u"));
		boolean res = this.userDAO.deleteUser(id);
		if(res) response.sendRedirect("/ebook/admin");	
	}
}
