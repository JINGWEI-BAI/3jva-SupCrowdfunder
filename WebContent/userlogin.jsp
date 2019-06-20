<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css.css" type="text/css" rel="stylesheet"></link>
<title>Login</title>
</head>
<body>
<%@ include file="/header.jsp" %>
<div class="maindiv" >

<h3>Please login as User/Administrator</h3>



<form method="post" action="${pageContext.servletContext.contextPath}/login">
<ul class="ul">
<li>Email:&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="email" required/></li>
<li>Password: <input type="password" name="password" required/></li>

<li><input id="loginbutton" type="submit" value="Login" id="submit"/></li>
</ul>
</form>
</div>

</body>
</html>
