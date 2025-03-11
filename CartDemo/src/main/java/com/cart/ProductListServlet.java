package com.cart;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductListServlet") 
public class ProductListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = CartDBUtil.getAllProducts();
        
        // Set the product list as a request attribute
        request.setAttribute("productList", productList);
        
        // Forward to the JSP page to display the product list
        request.getRequestDispatcher("productlist.jsp").forward(request, response);
    }
}
