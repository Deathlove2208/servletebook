package com.mycompany.controller;


import com.mycompany.dao.UserDAO;
import com.mycompany.model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    private UserDAO userDAO;
    public login() {
        super();
        this.userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User checkUser = this.userDAO.getUser(username);
        if(checkUser != null){
            if(checkUser.getPword().equals(password)){
                response.sendRedirect("dashboardadmin");
            } else {
                response.sendRedirect("login");
            }
        }
    }

}