<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<%@ include file="/header.jsp" %>

</body>
</html>
<%
session.setAttribute("email", null);
session.invalidate();
response.sendRedirect("index.jsp");
%>
