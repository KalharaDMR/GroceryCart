package com.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/UpdateCartServlet")

public class UpdateCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String productId = request.getParameter("prodid");
        String productName = request.getParameter("prodname");
        
        String quantity = request.getParameter("quantity");
        
        String customerid = request.getParameter("cusid");

        
        boolean isTrue = CartDBUtil.updatecart(productId, productName, quantity, customerid);

        
        if (isTrue) {
            List<Customer> cartDetails = CartDBUtil.getCartDetails(customerid);
            request.setAttribute("cartDetails", cartDetails);
            RequestDispatcher dis = request.getRequestDispatcher("cartaccount.jsp");
            dis.forward(request, response);
        } else {
            
            List<Customer> cartDetails = CartDBUtil.getCartDetails(customerid);
            request.setAttribute("cartDetails", cartDetails);
            RequestDispatcher dis = request.getRequestDispatcher("cartaccount.jsp");
            dis.forward(request, response);
        }
    }
}
