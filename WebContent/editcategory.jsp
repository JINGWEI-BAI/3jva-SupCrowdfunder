<%@ page import ="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >

<html>

<link href="css.css" type="text/css" rel="stylesheet"></link>

<head>



<title>add</title>

</head>

<body >
  <%@ include file="/header.jsp" %>



  <div class="maindiv">
  
  
  
  <c:if test="${not empty category}"> 
  <h1>Edit Your category</h1>
  
    <form method="post" action="${pageContext.servletContext.contextPath}/editcategory">
    <h3>Id: <input type="text" id="id" name="id" value="${category.id}"required/></h3>
    <h3>Name: <input type="text" id="name" name="name" value="${category.name}"required/></h3>
    
    <br/>
    <input type="submit" value="Submit">
 </form>
 </c:if>
 
 </div>
 
</body>
</html>
