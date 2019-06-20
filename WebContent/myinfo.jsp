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
<h3>Edit your information</h3>
<c:if test="${not empty userList}">
<c:forEach items="${userList}" var="user">
      <c:if test="${user.id eq sessionScope.id}">  
      <form method="post" action="${pageContext.servletContext.contextPath}/edituserinfo">
      <ul class="ul">
     <input name="id" type="hidden" value="${user.id}">
<li>Email: <input class="in" type="text" name="email" value="${user.email}" required/></li>
<li>First Name: <input  class="in" type="text" name="fname" value="${user.firstname}" required/></li>
<li>Last Name: <input class="in" type="text" name="lname" value="${user.lastname}" required/></li>
<li>Password: <input  class="in" type="password" name="password" value="${user.password}" required/></li>
<li><input type="submit" value="Submit" id="submit"/></li>
</ul>
      
      
      </form>
    </c:if>
 </c:forEach>
</c:if>

<h3>Edit your products</h3>
<c:if test="${not empty productList}">

  <form method="post" action="${pageContext.servletContext.contextPath}/auth/removeProduct">
  
  <table >
  <tr>
  <th>ID</th>
  <th>Name</th>
  <th>Creator</th>
  <th>Create Date</th>
  <th>Completion</th>
  <th>Category</th>
  <th></th>
  <th></th>
  </tr>
  <c:forEach items="${productList}" var="product">
  <c:if test="${product.user.id eq sessionScope.id}">
  <input name="id"  type="hidden" value="${product.id}">
  <tr>
  <th>${product.id}</th>
  <th>${product.name}</th>
  <th>${product.creator}</th>
  <th>${product.date}</th>
  <th>${product.completion}</th>
  <th>${product.category.name}</th>
  <th><a class="innerdetail" href="${pageContext.servletContext.contextPath}/productdetail?id=${product.id} ">details..</a></th>
  <th><input type="submit" value="Remove"></th>
  </tr>
</c:if>
  </c:forEach>
  
  
  
  </table>
  
  </form>  
  </c:if>



 
</div>


</body>
</html>
