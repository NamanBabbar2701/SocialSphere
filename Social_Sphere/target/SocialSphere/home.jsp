<%@ page import="com.user.model.User" %>

<%
   User user =  (User) session.getAttribute("user");
   if(user == null) {
        response.sendRedirect("login.jsp");
        return;
   }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - SocialSphere</title>
</head>
<body>
    <h1>Welcome, <%= user.getUsername() %> !</h1>

    <hr>

    <h2>What would you like to do?</h2>
    <a href="DashboardServlet"><button style="background-color: bisque; color: blue;">Open Dashboard</button></a><br><br>
    <a href="createpost.jsp"><button style="background-color: bisque; color: blue;">+ Create a Post</button></a><br><br>
    <a href="ViewServlet"><button style="background-color: bisque; color: blue;">View Posts</button></a><br><br>

    <hr>

    <a href="logout"><button style="background-color: bisque; color: blue;">LogOut</button></a><br>
    
</body>
</html>
