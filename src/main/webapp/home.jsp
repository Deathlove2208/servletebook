<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"
%>
<%@ page import="java.util.ArrayList"%>
    <%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/home.css">
    <title>Home</title>
</head>
<body class="grid-layout">
    <div class="header">
        <a href="home" class="logo">Store</a>
        <form class="form-search" action="" method="GET">
          <input class="search-input" type="search" placeholder="Search" name="search-query" />
          <button class="btn" type="submit">Search </button>
        </form>
        
        <span class="header-right">
          <a href="login">Login</a>
          <a href="register">Sign up</a>
        </span>
      </div>
      <div class="modal">
        
      </div>
      <div class="sidebar bg">
        <ul class="nav-sidebar">
          <li class="nav-sidebar-item"><a href="/">Home</a></li>
          <li class="nav-sidebar-item"><a href="/">New </a></li>
          <li class="nav-sidebar-item"><a href="/">Trending </a></li>
          <li class="nav-sidebar-item"><a href="/">Best</a></li>
        </ul>
        <ul class="nav-sidebar">Following</ul>
      </div>
      <main class="content" >
          <c:forEach var="book" items="${requestScope.books}">
                <div class="card">
                    <img class="card-img-top" alt="img" src="${book.getThumbnail()}"/>
                    <div class="card-body">
                        <h3 class="card-title">${book.getTitle()}</h3>
                        <p class="card-des">Description</p>
                    </div>
                    <div class="card-footer">
                        <div class="user">
                            <div class="avatar-cover"><img class="avatar-user" src="static/img/logo.png" alt="" /></div>
                            <p class="user-name">User name</p>
                        </div>
                        <a href="pdf_viewer/index.html"><button class="btn">Read</button></a>
                        
                    </div>
                </div>
          </c:forEach>
             
      </main>
      
</body>
</html>