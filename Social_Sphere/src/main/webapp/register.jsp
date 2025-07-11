<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
</head>
<body>
        <h1>SignUp</h1>
        <form action="RegisterServlet" method="post">
            
            <label>Username:</label>
            <input type="text" name="username" placeholder="Enter Username" required/><br><br>

            <label>Email:</label>
            <input type="email" name="email" placeholder="Enter Email" required/><br><br>
            
            <label>Password:</label>
            <input type="password" name="password" placeholder="Enter Password" required/><br><br>

            <input type="submit" value="SignUp"/>
        </form>
        <p>Already had an account? <a href="login.jsp">Login</a></p>
</body>
</html>