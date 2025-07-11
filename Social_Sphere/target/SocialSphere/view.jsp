<%@ page import="java.util.*" %>
<%@ page import="com.user.model.User" %>
<%@ page import="com.post.model.Post" %>
<%@ page import="com.comment.model.Comment" %>


<%
    User user = (User) session.getAttribute("user");
    if(user == null){
        response.sendRedirect("login.jsp");
        return;
    }
    List<Post> posts =  (List<Post>) request.getAttribute("posts");
    List<Comment> comments = (List<Comment>) request.getAttribute("comments");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Posts - SocialSphere</title>
</head>
<body>
    <h1>All Posts</h1>
    <hr>
    <% 
        if(posts != null && !posts.isEmpty()){
            for(Post post : posts) {
    %>
        <div style="border: 1px solid #ccc; padding: 10px; margin-bottom: 15px;">
            <h2><%= post.getTitle() %></h2>
            <p><%= post.getContent() %></p>
            <p><strong>Posted by: </strong><%= post.getUser().getUsername() %> |
                <%= post.getTimestamp() %></p>

                <div style="margin-left: 20px; border-top: 1px solid #999; padding-top: 10px;">
                <h4>Comment:</h4>
                <%
                    boolean hasComments = false;
                    for(Comment comment : comments){
                        if(comment.getPost().getPostID() == post.getPostID()){
                            hasComments = true;
                %>
                            <p>
                                <strong><%= comment.getUser().getUsername() %>:</strong>
                                <%= comment.getComment() %>
                                <small style="color:grey;">[<%= comment.getTimeStamp() %>]</small>
                            </p>
                <%
                        }
                     }
                     if(!hasComments){
                %>
                        <p>No Comments Yet</p>
                <% } %>
                </div>
            <form action="CommentServlet" method="post" style="margin-top:10px">
                <input type="hidden" name="postid" value="<%= post.getPostID() %>">
                <textarea name="comment" rows="3" cols="90" placeholder="Write a comment...."></textarea><br>
                <input type="submit" value="Add Comment">
            </form>
        </div>
    <%
            }
        } else{
    %>  
                <p>No Posts Found</p>
    <%           
            }
    %>    
</body>
</html>
