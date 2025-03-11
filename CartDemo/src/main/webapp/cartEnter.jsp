<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Customer ID</title>
<link rel="stylesheet" type="text/css" href="styles.css"> 

<script type="text/javascript">
    function validateForm() {
        
        var pid = document.forms["cartForm"]["pid"].value;
        var pname = document.forms["cartForm"]["pname"].value;
        var qty = document.forms["cartForm"]["qty"].value;
        var cid = document.forms["cartForm"]["cid"].value;

        
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
<div class="cart-details">
<h2>View Products</h2>
     <form action="ProductListServlet" method="post">
        <input type="submit" value="View Products">
     </form>

<h2>Add Product to Cart</h2>
    <form  name= "cartForm" action="CartInsert" method="post" onsubmit="return validateForm()">
       <label for="pid">Product ID:</label>
       <select name="pid" required style="width: 200px; height: 35px; font-size: 16px;">
        
        <option value="P001" >P001</option>
        <option value="P002" >P002</option>
        <option value="P003" >P003</option>
        <option value="P004" >P004</option>
        <option value="P005" >P005</option>
        <option value="P006" >P006</option>
        <option value="P007" >P007</option>
        <option value="P008" >P008</option>
        
        </select>
        <br><br>
       <label for="pname">Product Name:</label>
       
       <select name="pname" required style="width: 200px; height: 35px; font-size: 16px;">
        
        <option value="Apple" >Apple</option>
        <option value="Banana" >Banana</option>
        <option value="Orange" >Orange</option>
        <option value="Grape" >Grape</option>
        <option value="Mango" >Mango</option>
        <option value="Rice" >Rice</option>
        <option value="Sugar" >Sugar</option>
        <option value="flavour" >flavour</option>
        
        </select>
        <br><br>
       
       
       <label for="qty">Quantity:</label>
       <input type="text" name="qty" id="qty"><br>
       <label for="cid">Customer ID:</label>
       <input type="text" name="cid" id="cid"><br>

    <input type="submit" name="action" value="Add Product">
    <input type="submit" name="action" value="Done">
   </form>

<h2>Retrieve Cart</h2>
<form action="cartEnterServlet" method="post">
    <label for="cid">Customer ID:</label>
    <input type="text" name="cid" id="cid" required><br>
    <input type="submit" name="submit" value="Retrieve Cart">
</form>

<h2>Get Total Price</h2>
<form action="totalPriceServlet" method="post">
    <label for="cid">Customer ID:</label>
    <input type="text" name="cid" id="cid" required><br>
    <input type="submit" name="submit" value="Get Total Price">
</form>
</div>
</div>

</body>
</html>
