<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
</head>
<body>
        <h1>Login</h1>
        <form action="login" method="post">
            
            <label>Username:</label>
            <input type="text" name="username" placeholder="Enter Username" required/><br><br>
            
            <label>Password:</label>
            <input type="password" name="password" placeholder="Enter Password" required/><br><br>

            <input type="submit" value="Login"/>
        </form>
        <p>Don't have an account? <a href="register.jsp">SignUp</a></p>
</body>
</html>