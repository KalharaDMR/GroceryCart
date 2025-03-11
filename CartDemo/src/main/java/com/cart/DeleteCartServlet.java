package com.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*delete product*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productId = request.getParameter("prodid");
		String customerid = request.getParameter("cusid");
		
    boolean isTrue;
		
		isTrue=CartDBUtil.deleteCart(productId);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("cartEnter.jsp");
			dis.forward(request, response);
		}else {
			
			List<Customer> cartDetails =CartDBUtil.getCartDetails(customerid);
			request.setAttribute("cartDetails", cartDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("cartEnter.jsp");
			dis.forward(request, response);
			
		}
		
	}

}

