package com.servlets;

import com.user.dao.UserDAO;
import com.user.dao.UserDAOImpl;
import com.user.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        UserDAO userDAO = new UserDAOImpl();
        int result = userDAO.insert(user);
        if(result > 0){
            resp.sendRedirect("login.jsp");
        }
        else{
            resp.setContentType("text/html");
            resp.getWriter().println("Error Registering");
            resp.sendRedirect("register.jsp");
        }

    }
}
