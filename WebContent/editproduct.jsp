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
  
  <c:if test="${empty categoryList}">
  <h3>Please Create a Category at first!</h3>
   <a href="${pageContext.servletContext.contextPath}/auth/addCategory">add a category</a> 
  </c:if>
  
  <c:if test="${not empty categoryList}"> 
  <h1>Edit Your Product</h1>
  
    <form method="post" action="${pageContext.servletContext.contextPath}/editproduct">
    <h3>Id: <input type="text" id="id" name="id" value="${product.id}"required/></h3>
    <h3>Name: <input type="text" id="name" name="name" value="${product.name}"required/></h3>
    <h3>Content: <textarea  rows="4" cols="50" id="content" name="content"  required>${product.content}</textarea></h3>
    <h3>Completion: <input type="text" id="completion" name="completion" value="${product.completion}"required></h3>
    
    Category : 
    <select name="categoryId">
    <c:forEach items="${categoryList}" var="category">
    <option  value="${category.id}">${category.name}</option>
    </c:forEach>
     </select>
    <br/>
    <input type="submit" value="Submit">
 </form>
 </c:if>
 
 </div>
 
</body>
</html>
