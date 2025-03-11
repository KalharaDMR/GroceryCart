package com.cart;

public class Customer {
	
	
	private String productID;
	private String productName;
	
	private int quantity;
	
	private String customerID;
	
	
	public Customer(String productID, String productName, int quantity,
			String customerID) {
		
		
		this.productID = productID;
		this.productName = productName;
		
		this.quantity = quantity;
		
		this.customerID = customerID;
	}


	public String getProductID() {
		return productID;
	}


	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getCustomerID() {
		return customerID;
	}


	
	
	
	

}
