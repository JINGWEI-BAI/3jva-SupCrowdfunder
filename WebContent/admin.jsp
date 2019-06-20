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
table{border:1px solid black;}  
table td{border:1px solid black;}  


</style>


<title>add</title>

</head>

<body >
<div class="header">

<a class="a_header" style="padding-left:100px;padding-right:30px;" href="${pageContext.servletContext.contextPath}/listproduct">Project</a>
<a class="a_header" style="padding-left:10px;padding-right:30px;" href="${pageContext.servletContext.contextPath}/category">Category</a>
<a class="a_header" style="padding-left:10px;padding-right:30px;" href="${pageContext.servletContext.contextPath}/auth/addProduct">Create</a>

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
  <form method="post" action="${pageContext.servletContext.contextPath}/auth/removeProduct">
  
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
  <th></th>
  </tr>
  <c:forEach items="${productList}" var="product">
  <input name="id"  type="hidden" value="${product.id}">
  <tr>
  <th>${product.id}</th>
  <th>${product.name}</th>
  <th>${product.creator}</th>
  <th>${product.date}</th>
  <th>${product.completion}</th>
  <th>${product.category.name}</th>
  <th><a class="innerdetail" href="${pageContext.servletContext.contextPath}/productdetail?id=${product.id} ">details</a></th>
  <th><a class="innerdetail" href="${pageContext.servletContext.contextPath}/editproduct?id=${product.id}">edit</a></th>
  <th><input type="submit" value="Remove"></th>
  </tr>
  </c:forEach>
  
  
  
  </table >
  
  </form>  
  </c:if>
  
  <c:if test="${empty productList}">
  <h3>No Product has been added</h3>
  <a href="${pageContext.servletContext.contextPath}/auth/addProduct">add a product</a>
  </c:if>
  
  
    <h3>Category table</h3>
  <c:if test="${not empty categoryList}">
  <form method="post" action="${pageContext.servletContext.contextPath}/auth/removeCategory">
  
  <table rules="all">
  <tr>
  <th>ID</th>
  <th>Name</th>
  <th></th>
  <th></th>
  </tr>
  <c:forEach items="${categoryList}" var="category">
  <input name="id"  type="hidden" value="${category.id}">
  <tr>
  <th>${category.id}</th>
  <th>${category.name}</th>
  <th><a  href="${pageContext.servletContext.contextPath}/editcategory?id=${category.id}">edit</a></th>
  <th>
 <input type="submit" value="Remove">
  
  
  </th>
  
  </tr>
  </c:forEach>
    
  
  
  
  </table>
  </form>
  </c:if>
  <c:if test="${empty categoryList}">
  <h3>No Category has been added</h3>
  <a href="${pageContext.servletContext.contextPath}/auth/addCategory">add a category</a>
  </c:if>
  
  
  
    <h3>User table</h3>
  <c:if test="${not empty UserList}">
  <form method="post" action="${pageContext.servletContext.contextPath}/removeUser">
  <table rules="all">
  <tr>
  <th>ID</th>
  <th>First Name</th>
  <th>Last Name</th>
  <th>Email</th>
  <th>Admin</th>
  <th></th>
  
  </tr>
  <c:forEach items="${UserList}" var="user">
   
  <tr>
 
  <th>${user.id}<input name="id" type="hidden" value="${user.id}"></th>
  <th>${user.firstname}</th>
  <th>${user.lastname}</th>
  <th>${user.email}</th>
  <c:if test="${user.admin eq true}"><th>yes<th></c:if>
  <c:if test="${user.admin eq false}"><th>no<th></c:if>
  <c:if test="${user.id ne sessionScope.id}">
  <input type="submit" value="Remove">
  </c:if>
  
  </tr>
  </c:forEach>
  </table>
  </form>
  </c:if>
   
  </div>
  </body>
</html>
