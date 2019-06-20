<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="header_css.css" type="text/css" rel="stylesheet"></link>
</head>


<div class="header">

<a class="a_header" style="padding-left:100px;padding-right:30px;" href="${pageContext.servletContext.contextPath}/listproduct">Project</a>
<a class="a_header" style="padding-left:10px;padding-right:30px;" href="${pageContext.servletContext.contextPath}/category">Category</a>
<a class="a_header" style="padding-left:10px;padding-right:30px;" href="${pageContext.servletContext.contextPath}/auth/addProduct">Create</a>
<a class="a_header" style="padding-left:10px;padding-right:30px;" href="${pageContext.servletContext.contextPath}/auth/contribute">Contribute</a>
<c:if test="${empty sessionScope.email}">
<a class="a_header" style="padding-left:650px;padding-right:5px;" href="userlogin.jsp">Login</a>
</c:if>
<c:if test="${not empty sessionScope.id}">
<a class="a_header" style="padding-left:450px;padding-right:5px;" href="logout.jsp">Logout</a>
<a class="a_header" style="padding-left:5px;padding-right:5px;" href="${pageContext.servletContext.contextPath}/myinfo">${sessionScope.email} + ${sessionScope.id}</a>
</c:if>
<a class="a_header" style="padding-left:5px;padding-right:0px;" href="userreg.jsp">Register</a>
<a class="a_header" style="padding-left:5px;padding-right:0px;" href="${pageContext.servletContext.contextPath}/admin/adminpage">Admin</a> 
</div>

