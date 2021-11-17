<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet"> 
	<link rel="stylesheet" href="./css/profile.css">
	<title>${user.getUsername()}</title>

</head>
<body>
<div class="settings-page">
  <div class="settings-container">
    <h1 class="page-title">Account</h1>
    <div class="settings-section">
      <h2 class="settings-title">General Information</h2>
        <div class="non-active-form">
          <p>${user.getFullname()}</p><i class="fas fa-pen"></i>
        </div>
	<div>
     <div class="non-active-form">
       <p class="capitalize"></p><i class="fas fa-pen"></i>
     </div>
    </div>
    <div>
      <div class="non-active-form">
        <p class="capitalize"></p><i class="fas fa-pen"></i>
      </div>
    </div>
    <div>
      <div class="non-active-form">
        <p>${user.getUsername()}</p><i class="fas fa-pen"></i>
      </div>
    </div>
</div>
<c:if test="${sessionScope.userInfo.getUsername() == user.getUsername()}"> 
                  <div class="settings-section">
	  <h2 class="settings-title">My profile</h2>
	  <form class="form my-form">
	    <div class="img-upload-container">
	      <label class="img-upload btn btn-bwm">
	        <input type="file" value="">
	      </label>
	      <h4>Change Your Profile Picture</h4>
	      <div class="img-preview-container">
	        <div class="img-preview">
	        </div>
	      </div>
	    </div>
	    <div class="form-submit">
	      <button class="btn button full" type="submit" disabled="">Save New Picture</button>
	    </div>
	  </form>
	</div>
	<div class="settings-section">
	  <h2 class="settings-title">Password</h2>
	  <form class="form my-form">
	    <div class="form-group">
	      <div class="input-group">
	        <input name="currentPassword" placeholder="Old Password" type="password" class="form-control" autocomplete="Old Password" value="">
	        <span class="focus-input"></span>
	      </div>
	    </div>
	    <div class="form-group">
	      <div class="input-group">
	        <input name="password" placeholder="New Password" type="password" class="form-control" autocomplete="New Password" value="">
	        <span class="focus-input"></span>
	      </div>
	    </div>
	   <div class="form-submit right">
	     <button class="btn button full" type="submit" disabled="">Change Password</button>
	    </div>
	  </form>
	</div>
</c:if>
	
</div>
</div>
</body>
</html>