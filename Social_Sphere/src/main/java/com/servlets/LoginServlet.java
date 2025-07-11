package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.user.dao.UserDAO;
import com.user.dao.UserDAOImpl;

import com.user.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.authenticate(username,password);

        if(user != null){
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            req.getRequestDispatcher("home.jsp").forward(req,resp);
        }
        else{
            out.println("<p style='color:red;'> Invalid User</p>");

        }
    }
}
