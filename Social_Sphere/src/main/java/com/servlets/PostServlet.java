package com.servlets;

import com.post.dao.PostDAO;
import com.post.dao.PostDAOImpl;
import com.post.model.Post;
import com.user.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {

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

        String title = req.getParameter("title");
        String content = req.getParameter("content");


        Post post = new Post(title,content,user);
        PostDAO postDAO = new PostDAOImpl();
        int result = postDAO.insert(post);

        if(result > 0){
            resp.sendRedirect("home.jsp");
        } else{
            resp.sendRedirect("createpost.jsp?error=true");
        }

    }
}
