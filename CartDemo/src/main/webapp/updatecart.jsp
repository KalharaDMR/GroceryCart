<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles.css">

<script type="text/javascript">
    function validateForm() {
        
        var pid = document.forms["cartForm"]["prodid"].value;
        var pname = document.forms["cartForm"]["prodname"].value;
        var qty = document.forms["cartForm"]["quantity"].value;
        var cid = document.forms["cartForm"]["cusid"].value;

        
        if (pid == "" || pname == "" || qty == "" || cid == "") {
            alert("All fields must be filled out");
            return false; 
        }

        
        if (isNaN(qty) || qty <= 0) {
            alert("Quantity must be a positive number");
            return false; 
        }

        return true; 
    }
</script>

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

       <form name= "cartForm" action="update" method="post" onsubmit="return validateForm()">
          
          product ID <input type="text" name="prodid" value="<%= productID %>" readonly><br><br>
          product name <input type="text" name="prodname" value="<%= productName %>" readonly><br><br>
          
          quantity <input type="text" name="quantity" value="<%= quantity %>"><br><br>
          
          customer ID <input type="text" name="cusid" value="<%= customerID %>" readonly><br><br>
          
          <input type="submit" name="submit" value="update My Data"><br><br>
       
       
       </form>
       
</div>
</div>

</body>
</html>


