<%@ page import ="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<link href="css.css" type="text/css" rel="stylesheet"></link>


<head>
<style type="text/css">

.maindiv{
	margin-top:70px;
	width:810px;
	
	MARGIN-RIGHT: auto;
	 MARGIN-LEFT: auto;
	font-family:Arial,Verdana,Sans-serif;
}
.111{background-color:red;}
table
{border: thin solid black;}



</style>


<title>add</title>

</head>

<body >
<div class="header">

<a class="a_header" style="padding-left:100px;padding-right:30px;" href="${pageContext.servletContext.contextPath}/listproduct">Project</a>
<a class="a_header" style="padding-left:10px;padding-right:30px;" href="${pageContext.servletContext.contextPath}/category">Category</a>
<a class="a_header" style="padding-left:10px;padding-right:30px;" href="${pageContext.servletContext.contextPath}/auth/addProduct">Create</a>
<a class="a_header" style="padding-left:10px;padding-right:30px;" href="${pageContext.servletContext.contextPath}/auth/contribute">Contribute</a>
<c:if test="${empty sessionScope.email}">
<a class="a_header" style="padding-left:650px;padding-right:5px;" href="userlogin.jsp">Login</a>
</c:if>
<c:if test="${not empty sessionScope.email}">
<a class="a_header" style="padding-left:650px;padding-right:5px;" href="logout.jsp">Logout</a>
<a class="a_header" style="padding-left:5px;padding-right:5px;" href="${pageContext.servletContext.contextPath}/myinfo">${sessionScope.email}</a>
</c:if>
<a class="a_header" style="padding-left:5px;padding-right:0px;" href="userreg.jsp">Register</a>
<a class="a_header" style="padding-left:5px;padding-right:0px;" href="${pageContext.servletContext.contextPath}/admin/adminpage">I am administrator</a> 
</div>

  



  <div class="maindiv">
  <h3>Product table</h3>
  <c:if test="${not empty productList}">
  <form method="post" action="${pageContext.servletContext.contextPath}/auth/contribute">
  <table rules="all">
  <tr>
  <th>ID</th>
  <th>Name</th>
  <th>Creator</th>
  <th>Create Date</th>
  <th>Contribution</th>
  <th>Category</th>
  <th></th>
  <th></th>
  
  </tr>
  <c:forEach items="${productList}" var="product">
  <input name="id"  type="hidden" value="${product.id}">
  <input name="oldnum"  type="hidden" value="${product.completion}">
  <tr>
  <th>${product.id}</th>
  <th>${product.name}</th>
  <th>${product.creator}</th>
  <th>${product.date}</th>
  <th>${product.completion}</th>
  <th>${product.category.name}</th>
  <th><input type="text" id="num" name="num"></th>
  <th><button type="submit">submit</button></th>

  </tr>
  </c:forEach>
  
  
  
  </table>
  
  </form>  
  </c:if>
  
  <c:if test="${empty productList}">
  <h3>No Product has been added</h3>
  <a href="${pageContext.servletContext.contextPath}/auth/addProduct">add a product</a>
  </c:if>
  
  
  
  
  
  
    
   
  </div>
  </body>
</html>
