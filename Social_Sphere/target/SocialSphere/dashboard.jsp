<%@ page import="java.util.*" %>
<%@ page import="com.user.model.User" %>

<%
    User user = (User) session.getAttribute("user");
    if(user == null){
        response.sendRedirect("login.jsp");
        return;
    }

    int totalPosts = (Integer) request.getAttribute("totalPosts");
    int commentsMade = (Integer) request.getAttribute("commentsMade");

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard -SocialSphere</title>
</head>
<body>
        <h1>Welcome, <%= user.getUsername() %>!</h1>
        <p>Total Posts: <%= totalPosts %></p>
        <p>Comments: <%= commentsMade %></p>

        <p></p><a href="ViewServlet">Go to Posts</a></p>
        <p><a href="LogoutServlet">Logout</a></p>

</body>
</html>