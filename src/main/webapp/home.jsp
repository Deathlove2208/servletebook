<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet"> 
    <title>Home</title>
</head>
<body class="grid-layout">
    <div class="header">
        <a href="home" class="logo">book</a>
        <form class="form-search" action="" method="GET">
          <input class="search-input" type="search" placeholder="tìm kiếm..." name="b" />
          <button class="btn" type="submit">tìm kiếm</button>
        </form>
        
        <span class="header-right">
            <c:choose>
                <c:when test="${sessionScope.userInfo == null}"> 
                  <a href="login">login</a>
                </c:when>
                <c:otherwise>
                    <a href="">${sessionScope.userInfo.getFullname()}</a>
                    <a href="logout">logout</a>
                </c:otherwise>
            </c:choose>
            <c:if test="${sessionScope.userInfo.getRole() == 'admin'}"> 
                  <a href="admin">dashboard</a>
            </c:if>
          
        </span>
      </div>
      <div class="modal">
        
      </div>
      <div class="sidebar bg">
        <ul class="nav-sidebar">
          <li class="nav-sidebar-item"><a href="home">trang chủ</a></li>
          <li class="nav-sidebar-item"><a href="home?b=isNew">mới nhất </a></li>
          <li class="nav-sidebar-item"><a href="home?b=trending">thịnh hành </a></li>
          <li class="nav-sidebar-item"><a href="home?b=best">hay nhất</a></li>
        </ul>
        <ul class="nav-sidebar">theo dõi</ul>
      </div>
      <main class="content" >
      	<c:if test="${requestScope.books.size() == 0}"> 
                  <p>Not found book</p>
        </c:if>
          <c:forEach var="book" items="${requestScope.books}">
                <div class="card">
                    <a href="doc?q=${book.getId()}">
                        <img class="card-img-top" alt="img" src="${book.getImg()}"/>
                    </a>
                    <div class="card-body">
                        <a href="doc?q=${book.getId()}"><h3 class="card-title">${book.getTitle()}</h3></a>
                        <p class="card-des"> &#128065; ${book.getViews()}</p>
                    </div>
                    <div class="card-footer">
                        <div class="user">
                            <div class="avatar-cover"><img class="avatar-user" src="static/img/logo.png" alt="" /></div>
                            <p class="user-name">${book.getAuthor()}</p>
                        </div>
                        <a href="">&#x1F493;</a>                   
                    </div>
                </div>
          </c:forEach>
             
      </main>
      
</body>
</html>