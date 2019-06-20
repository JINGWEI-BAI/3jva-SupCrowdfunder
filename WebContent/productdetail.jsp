<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="css.css" type="text/css" rel="stylesheet"></link>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>  product detail</title>
</head>
<body>
  <%@ include file="/header.jsp" %>
  <div class="maindiv" >
      
       <c:if test="${not empty product}">
       <div class="detailinnerdiv">
       <ul>
          <li><h3 class="dtitle">Name:${product.name} </h3></li>
          <li><h3>Creator:${product.user.email}</h3></li>
          <li><h3>Category:${product.category.name} </h3></li>
          <li><h3>CreateDate:${product.date}</h3></li>
          <li><h3>Contribution:${product.completion}</h3></li>
          </ul>
            <p>   <h3>Here is the content</h3>${product.content}   </p>
                
                
                
                
               
          
          </div>
       </c:if>
           
                
              </div>


</body>
</html>