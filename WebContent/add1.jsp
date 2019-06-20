<%@ page import ="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<link href="css.css" type="text/css" rel="stylesheet"></link>

<head>



<title>add</title>

</head>

<body >
  <%@ include file="/header.jsp" %>

<div class="maindiv">
 <h1>Add Category</h1>
     <form method="post" action="${pageContext.servletContext.contextPath}/auth/addCategory">
       Name: <input type="text" id="name" name="name" required>
       <input type="submit" value="Submit">
      </form>
   </div>
 
</body>
</html>
