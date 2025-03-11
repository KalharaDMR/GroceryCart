package com.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





public class CartDBUtil {
	
	
	private static boolean isSuccess;
	public static List<Customer> validate(String customerID) {
	    ArrayList<Customer> cus = new ArrayList<>();
	    
	    // Database connection details
	    String url = "jdbc:mysql://localhost:3306/grocerystore";
	    String user = "root";
	    String pass = "20021007";
	    
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, user, pass);
	        Statement stmt = con.createStatement();
	        
	        // SQL query to fetch cart details based on customer ID
	        String sql = "SELECT * FROM cart WHERE customerId='" + customerID + "'";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            String productid = rs.getString("productid");
	            String productName = rs.getString("productName");
	        	
	            int quantity = rs.getInt("quantity");
	            
	            String customerId = rs.getString("customerId");
	            
	            // Add customer cart details to the list
	            Customer c = new Customer(productid, productName, quantity, customerId);
	            cus.add(c);
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return cus;
	}
	
//view product table	
	public static List<Product> getAllProducts() {
	    ArrayList<Product> products = new ArrayList<>();
	    
	    // Database connection details
	    String url = "jdbc:mysql://localhost:3306/grocerystore"; // Make sure this is correct
	    String user = "root";
	    String pass = "20021007";
	    
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");// Use the updated driver class
	        Connection con = DriverManager.getConnection(url, user, pass);
	        Statement stmt = con.createStatement();
	        
	        // SQL query to fetch all products
	        String sql = "SELECT * FROM product";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            String productId = rs.getString("productId");
	            String productName = rs.getString("productName");
	            double price = rs.getDouble("price");
	            
	            // Add product details to the list
	            Product product = new Product(productId, productName, price);
	            products.add(product);
	        }
	        
	    } catch (Exception e) {
	        System.out.println("Error in getAllProducts: " + e.getMessage());
	        e.printStackTrace();
	    }
	    
	    return products;
	}
	
	
	//insert
	
	public static boolean insertcart(String productid,String productname,String quantity,String customerid) {
		
		boolean isSuccess=false;
		
		
		//create db connection
		String url="jdbc:mysql://localhost:3306/grocerystore";
		String user="root";
		String pass="20021007";
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,user,pass);
			Statement stmt= con.createStatement();
			String sql="insert into cart values ('"+productid+"','"+productname+"','"+quantity+"','"+customerid+"')";
			int rs=stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess=true;
			}
			else {
				isSuccess=false;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}

	//update cart
	
		public static boolean updatecart(String productid,String productName,String quantity,String customerId) {
			
		
			//create db connection
					String url="jdbc:mysql://localhost:3306/grocerystore";
					String user="root";
					String pass="20021007";
			
			try {
				Connection con=DriverManager.getConnection(url,user,pass);
				Statement stmt= con.createStatement();
				String sql="update cart set productName='"+productName+"',quantity='"+quantity+"',customerId='"+customerId+"' " +
			    "where productid='"+productid+"'";

				
				int rs=stmt.executeUpdate(sql);
				
				if(rs>0) {
					isSuccess=true;
				}else {
					isSuccess=false;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
			
		}
		
//get cart details using cutomerid
		
		public static List<Customer> getCartDetails(String customerID){
			
			String url="jdbc:mysql://localhost:3306/grocerystore";
			String user="root";
			String pass="20021007";
			
			
			
			ArrayList<Customer> cus =new ArrayList<>();
			
			try {
				Connection con=DriverManager.getConnection(url,user,pass);
				Statement stmt= con.createStatement();
				String sql="select * from cart where customerId='"+customerID+"'";
				ResultSet rs=stmt.executeQuery(sql);
				
				while(rs.next()) {
					String productid=rs.getString(1);
					String productName=rs.getString(2);
					
					int quantity=rs.getInt(3);
					
					String customerId=rs.getString(4);
					
					Customer c=new Customer(productid,productName,quantity,customerId);
					cus.add(c);
					
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return cus;
		}
		
//delete cart
        public static boolean deleteCart(String productID) {
			
			String url="jdbc:mysql://localhost:3306/grocerystore";
			String user="root";
			String pass="20021007";
			
			
			
			try {
				
				Connection con=DriverManager.getConnection(url,user,pass);
				Statement stmt= con.createStatement();
				String sql="delete from cart where productid='"+productID+"'";
				int r=stmt.executeUpdate(sql);
				
				if(r>0) {
					isSuccess=true;
				}else {
					isSuccess=false;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
		}
        
//method to get totalprice
        
        public static double getTotalPriceForCustomer(String customerId) {
            double totalPrice = 0.0;

            // Database connection details
            String url = "jdbc:mysql://localhost:3306/grocerystore";
            String user = "root";
            String pass = "20021007";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                Statement stmt = con.createStatement();
                
                
                String cartSql = "SELECT productid, quantity FROM cart WHERE customerId = '" + customerId + "'";
                ResultSet cartRs = stmt.executeQuery(cartSql);

                // For each cart item, get the price from the product table
                while (cartRs.next()) {
                    String productId = cartRs.getString("productid");
                    int quantity = cartRs.getInt("quantity");

                    // Query the product table to get the price for the current productId
                    String productSql = "SELECT price FROM product WHERE productid = '" + productId + "'";
                    ResultSet productRs = stmt.executeQuery(productSql);

                    if (productRs.next()) {
                        double price = productRs.getDouble("price");
                        totalPrice += price * quantity; // Add the total for each product
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return totalPrice;
        }




}
