<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>


<div class="container">
<div class="form-container">
     <%
          
           
           String productID = request.getParameter("productid");
   		   String productName = request.getParameter("productName");
   		   
   		   String quantity = request.getParameter("quantity");
   		   
   		   String customerID = request.getParameter("customerId");
       
       %>
       
       <h1>Product delete</h1>
       
       <form action="DeleteCartServlet" method="post">
          
          product ID <input type="text" name="prodid" value="<%= productID %>" readonly><br><br>
          product name <input type="text" name="prodname" value="<%= productName %>" readonly><br><br>
          
          quantity <input type="text" name="quantity" value="<%= quantity %>" readonly><br><br>
          
          customer ID <input type="text" name="cusid" value="<%= customerID %>" readonly><br><br>
          
          <input type="submit" name="submit" value="Delete my product"><br><br>
       
       
       </form>
</div>
</div>

</body>
</html>
