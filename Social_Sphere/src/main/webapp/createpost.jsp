<%@ page import="com.user.model.User" %>

<%
    User user = (User) session.getAttribute("user");
    if(user == null){
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create a Post -SocialSphere</title>
</head>
<body>
      <h2><%= user.getUsername() %> Create A New Post:</h2>

      <form action="PostServlet" method="post">
        <label>Title:</label><br><br>
        <input type="text" name="title" placeholder="Enter Title" required><br><br>

        <label>What are you thinking ?</label><br><br>
        <input type="text" name="content" size="200" required><br><br>

        <input type="submit" value="Post">
      </form>

      <br>
      <a href="login.jsp">Back to Login</a>

      <% if (request.getParameter("error") != null) { %>
        <p style='color:red;'>Failed to Post! Please try Again</p>
      <% } %>
</body>
</html>