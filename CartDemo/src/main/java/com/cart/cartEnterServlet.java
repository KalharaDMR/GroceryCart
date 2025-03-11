package com.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/cartEnterServlet")
public class cartEnterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String customerId = request.getParameter("cid");
        
        //fetching cart details for customer
        try {
            List<Customer> cartDetails = CartDBUtil.validate(customerId);
            request.setAttribute("cartDetails", cartDetails);
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        
        RequestDispatcher dis = request.getRequestDispatcher("cartaccount.jsp");


        dis.forward(request, response);
		
	}

}
