package com.cart;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CartInsert")
public class CartInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	
    	//insert products to cart
        String productId = request.getParameter("pid");
        String productname = request.getParameter("pname");
        
        String quantity = request.getParameter("qty");
        
        String customerid = request.getParameter("cid");
        String action = request.getParameter("action");  
        
        boolean isTrue = false;
        
        if (action.equals("Add Product") || action.equals("Done")) {
            isTrue = CartDBUtil.insertcart(productId, productname, quantity, customerid);
        }

        /*if action=Add product you can continuously add products if action=Done stop product inserting into cart*/
        if (isTrue) {
            if (action.equals("Add Product")) {
                
                RequestDispatcher dis = request.getRequestDispatcher("/cartinsert.jsp");
                dis.forward(request, response);
            } else if (action.equals("Done")) {
                
                RequestDispatcher dis = request.getRequestDispatcher("/cartEnter.jsp");
                dis.forward(request, response);
            }
        } else {
            RequestDispatcher dis2 = request.getRequestDispatcher("/cartaccount.jsp");
            dis2.forward(request, response);
        }
    }
}
