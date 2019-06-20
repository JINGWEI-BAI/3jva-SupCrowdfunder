<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css.css" type="text/css" rel="stylesheet"></link>
<title>Insert title here</title>
</head>
<body>
<%@ include file="/header.jsp" %>



<c:if test="${not empty judge}">
<h1>sssssssss</h1>
</c:if>

<div class="maindiv">
<form method="post" action="${pageContext.servletContext.contextPath}/regist">
<ul class="ul">
<li>Email: <input class="in" type="text" name="email" required/></li>
<li>First Name: <input  class="in" type="text" name="fname" required/></li>
<li>Last Name: <input class="in" type="text" name="lname" required/></li>
<li>Password: <input  class="in" type="password" name="password" required/></li>
<li><input type="submit" value="Submit" id="submit"/></li>
</ul>
</form>

</div>

</body>
</html>