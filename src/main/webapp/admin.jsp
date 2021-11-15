<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet"> 
    <link rel="stylesheet" href="./css/dashboard.css">
    <title>Dashboard</title>
</head>
<body>
    <div class="layout">
        <div class="header">
            <span class="logo"><a href="home">Store</a></span>
            <span class="feature" id="myBtn" title="New post">
                &#43;
            </span>
             
        </div>
        <div class="sidebar">
            <ul>
                <li><a href="home">Home</a></li>
                <li><a href="" title="Users">Users</a></li>
                <li><a href="" title="Files">Books</a></li>
            </ul>
        </div>  
        <div class="content">

            <c:forEach var="book" items="${requestScope.books}">
                 <div class="card-group">
                    <div class="card-img">
                        <a href="doc?q=${book.getId()}"><img src="${book.getImg()}" alt=""></a>
                    </div>                    
                    <div class="card-body">
                        <a href="doc?q=${book.getId()}"><p>${book.getTitle()}</p></a>
                    </div>
                    <div class="card-footer">
                        <p></p>
                        <a href="admin/delete?b=${book.getId()}" title="delete" id="delete-btn">Delete</a>
                        <a href="admin/delete?b=${book.getId()}" title="eidt" id="edit-btn">Edit</a>
                    </div>
                </div>
            </c:forEach>
            <!-- The Modal -->
            <div id="myModal" class="modal">
                <!-- Modal content -->
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <h3>new book</h3>
                    <form action="admin" method="post" class="post-book">
                        <label for="title" class="title-book">Enter title for book</label>
                        <input type="text" id="title" class="title-input" placeholder="book title" name="title"><br>
                        <label for="book-img" class="title-input">Enter image for book</label>
                        <input type="text" class="title-input" id="book-img" name="img" placeholder="book image"><br>
                        <label for="" class="book-detail">Enter detail for book</label>
                        <textarea name="detail" rows="20" cols="100"></textarea>
                        <br>
                        <input type="submit" value="Upload" class="btn-submit">
                    </form>
                </div>
            </div> 
        </div>

    </div>
     <script src="js/dashboard.js"></script>
</body>
</html>
