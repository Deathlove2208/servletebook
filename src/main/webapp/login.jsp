<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/form.css">
    <title>Document</title>
</head>
<body>
    <form action="login" method="post" class="form">
    	<a href="home"><h2>Store</h2></a>
        <div class="form-group">
            <label for="username" class="label-input">@</label>
            <input type="text" name="username" placeholder="username" id="username" class="form-input" required>
        </div>
        <div class="form-group">
            <label for="password" class="label-input">Password</label>
            <input type="password" name="password" class="form-input" id="password" placeholder="password" required>
        </div>
        <button type="submit" class="btn-submit">Login</button>
        <p>Don't have an account? <a href="register"> Sign up</a></p>
    </form>
</body>
</html>