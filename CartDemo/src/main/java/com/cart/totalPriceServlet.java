package com.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/totalPriceServlet")
public class totalPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerId = request.getParameter("cid");

        
        double totalPrice = CartDBUtil.getTotalPriceForCustomer(customerId);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        out.println("<html><body>");
        out.println("<script type='text/javascript'>");
        out.println("alert('Total Price for Customer ID " + customerId + ": Rs." + totalPrice + "');");
        out.println("window.location.href = 'cartEnter.jsp';");  
        out.println("</script>");
        out.println("</body></html>");
		
		
	}

}
