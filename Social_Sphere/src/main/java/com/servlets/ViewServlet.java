package com.servlets;

import java.io.IOException;
import java.util.List;

import com.comment.dao.CommentDAO;
import com.comment.dao.CommentDAOImpl;
import com.comment.model.Comment;
import com.post.dao.PostDAO;
import com.post.dao.PostDAOImpl;
import com.post.model.Post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostDAO postDAO = new PostDAOImpl();
        List<Post> posts = postDAO.view();

        CommentDAO commentDAO = new CommentDAOImpl();
        List<Comment> comments = commentDAO.view();


        req.setAttribute("posts" , posts);
        req.setAttribute("comments", comments);
        req.getRequestDispatcher("view.jsp").forward(req,resp);
    }
}
