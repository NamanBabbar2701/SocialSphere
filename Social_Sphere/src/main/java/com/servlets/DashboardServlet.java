package com.servlets;

import java.io.IOException;

import com.comment.dao.CommentDAO;
import com.comment.dao.CommentDAOImpl;
import com.post.dao.PostDAO;
import com.post.dao.PostDAOImpl;
import com.user.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");

        if(user == null){
            resp.sendRedirect("login.jsp");
            return;
        }

        int userId = user.getUserID();

        PostDAO postDAO = new PostDAOImpl();
        CommentDAO commentDAO = new CommentDAOImpl();

        int totalPosts = postDAO.countPostByUserId(userId);
        int commentsMade = commentDAO.countCommentmadeByUserId(userId);

        req.setAttribute("totalPosts" , totalPosts);
        req.setAttribute("commentsMade", commentsMade);
        req.getRequestDispatcher("dashboard.jsp").forward(req,resp);

    }
}
