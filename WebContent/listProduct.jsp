<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="css.css" type="text/css" rel="stylesheet"></link>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of product</title>
</head>
<body>
  <%@ include file="/header.jsp" %>
  
  <div class="maindiv">
      <c:if test="${not empty productList}">
        <c:forEach items="${productList}" var="product">
             <div class="innerdiv"> 
               <form method="post" action="${pageContext.servletContext.contextPath}/auth/removeProduct">
                <h4 class="innerdivtitle"> ${product.name} </h4>
                
                  <p class="innerp">Content:${product.content}</p>
                  
                  
                  <input name="id"  type="hidden" value="${product.id}">
               </form> 
               <a class="innerdetail" href="${pageContext.servletContext.contextPath}/productdetail?id=${product.id} ">details..</a> 
               
              </div>
         </c:forEach>
      </c:if>
       <c:if test="${empty productList}">
       <h2>Welcome!</h2>
           <h3>No Product founded</h3>
           <a href="${pageContext.servletContext.contextPath}/auth/addProduct">add a product</a>
       </c:if>
       
                
              </div>


</body>
</html>