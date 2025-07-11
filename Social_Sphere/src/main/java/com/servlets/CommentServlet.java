package com.servlets;

import com.comment.dao.CommentDAO;
import com.comment.dao.CommentDAOImpl;
import com.comment.model.Comment;
import com.post.model.Post;
import com.user.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");

        if(user == null){
            resp.sendRedirect("login.jsp");
            return;
        }

        try{
            String content = req.getParameter("comment");
            int postid = Integer.parseInt(req.getParameter("postid"));

            Post post = new Post();
            post.setPostID(postid);

            Comment comment = new Comment();
            comment.setComment(content);
            comment.setUser(user);
            comment.setPost(post);

            CommentDAO commentDAO = new CommentDAOImpl();
            commentDAO.insert(comment);

            resp.sendRedirect("ViewServlet");
        } catch (RuntimeException e) {
            e.printStackTrace();
            out.println("Error with adding comments");
        }
    }
}
