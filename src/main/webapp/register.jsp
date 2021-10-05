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
    <form action="register" method="post" class="form">
        <a href="home"><h2>Store</h2></a>
        <div class="form-group">
            <label for="name" class="label-input">Name</label>
            <input type="text" name="name" placeholder="fullname" id="name" class="form-input">
        </div>
        <div class="form-group">
            <label for="username" class="label-input">@</label>
            <input type="text" name="username" placeholder="username" id="username" class="form-input" required>
        </div>
        <div class="form-group">
            <label for="password" class="label-input">Password</label>
            <input type="password" name="password" id="password" class="form-input" placeholder="password" required>
        </div>
        <div class="form-group">
            <label for="repassword" class="label-input">Confirm</label>
            <input type="password" name="repw" id="repassword" class="form-input" placeholder="Confirm password" required>
        </div>
        <button type="submit" class="btn-submit">Register</button>
        <p>Have an account? <a href="login">Log in</a></p>
    </form>
</body>
</html>