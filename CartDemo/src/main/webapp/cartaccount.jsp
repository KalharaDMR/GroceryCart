<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Details</title>
<link rel="stylesheet" type="text/css" href="styles.css"> 
</head>
<body>

<div class="container">
<div class="cartAccount">

<c:choose>
    <c:when test="${empty cartDetails}">
        <p>No products in your cart.</p>
        
    </c:when>
    <c:otherwise>
        <h2>Cart Details for Customer ID: ${cartDetails[0].customerID}</h2>
        <table>
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Quantity</th>
                <th>Actions</th> 
            </tr>
            <c:forEach var="cus" items="${cartDetails}">
                <tr>
                    <td>${cus.productID}</td>
                    <td>${cus.productName}</td>
                    
                    <td>${cus.quantity}</td>
                    
                    <td>
                       
                        <c:url value="updatecart.jsp" var="cartupdate">
                            <c:param name="productid" value="${cus.productID}"/>
                            <c:param name="productName" value="${cus.productName}"/>
                            
                            <c:param name="quantity" value="${cus.quantity}"/>
                            
                            <c:param name="customerId" value="${cus.customerID}"/>
                        </c:url>
                        <a href="${cartupdate}"><input type="button" value="Update"></a>

                        
                       <c:url value="deletecart.jsp" var="cartdelete">
          
                       <c:param name="productid" value="${cus.productID}"/>
                       <c:param name="productName" value="${cus.productName}"/>
                       
                       <c:param name="quantity" value="${cus.quantity}"/>
                       
                       <c:param name="customerId" value="${cus.customerID}"/>

          
                       </c:url>
                       <br>
                       <a href="${cartdelete}">
                       <input type="button" name="delete" value="Delete product">
                       </a>


                    </td>
                </tr>
            </c:forEach>
        </table>
        
       
       
        
    </c:otherwise>
</c:choose>

</div>
</div>



</body>
</html>

