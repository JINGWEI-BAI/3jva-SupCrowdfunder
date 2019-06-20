

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css.css" type="text/css" rel="stylesheet"></link>
<title>Insert title here</title>
</head>
<body >
<%@ include file="/header.jsp" %>
<div  class="maindiv" >

<c:if test="${not empty categoryList}">
        <c:forEach items="${categoryList}" var="Category">
        
           <div class="categorydiv1"> 
           <h4 class="categoryname"> ${Category.name} </h4>
           <c:forEach items="${productList}" var="product">
           <c:if test="${product.category.id eq Category.id}">
           <div class="innerdiv"> 
               <form method="post" action="${pageContext.servletContext.contextPath}/auth/removeProduct">
                <h3 class="innerdivtitle"> ${product.name} </h3>  <p>${product.content}</p>
                <input  name="id"  type="hidden" value="${product.id}"/>
                <a href="${pageContext.servletContext.contextPath}/productdetail?id=${product.id} ">details..</a>
                 
               <input style="margin-top:30px;display:none;" type="submit" value="Remove"/>
                  
               </form>
               <br>
                 
              </div>
              
       </c:if>
           </c:forEach>
               </div>
         
         </c:forEach>
      </c:if>
      
   <c:if test="${empty categoryList}">   
   <h3>No Category founded</h3>
   <a href="${pageContext.servletContext.contextPath}/auth/addCategory">add a category</a>
      </c:if>
      
      </div>

 


</body>
</html>