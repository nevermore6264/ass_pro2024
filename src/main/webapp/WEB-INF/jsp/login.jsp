<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Đăng nhập</title>
  
  <link rel="Shortcut Icon" href="hinh/iconhome.ico" type="image/x-icon" />  
  
      <link rel="stylesheet" href="css/style.css">

  
</head>

<body style="background-color: #292b2c;">
  <div class="wrapper">
	<div class="container">
		<h1>KHÁCH SẠN THĂNG THIÊN</h1>
		<span style="color: red; "><b><c:if test="${not empty message }">${message }</c:if></b></span>
		<form class="form" action="actionlogin">
			<input name="tendangnhap" type="text" placeholder="Tên đăng nhập" required="required">
			<input name="matkhau"type="password" placeholder="Mật khẩu" required="required">
			<button type="submit" id="login-button">Đăng nhập</button>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		
	</ul>
</div>
 

    <script  src="js/index.js"></script>

</body>
</html>
