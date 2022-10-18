package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;

public class ShoppingCart {

	ArrayList<Product> product;
	double totalAmount;
	double payableAmount;
	double discount;
	
	ShoppingCart() {
		this.product = new ArrayList<Product>();
		this.totalAmount = 0;
		this.payableAmount = 0;
		//this.discount = 0;
	}
	public void addToCart(Product product) {
		this.product.add(product);
	}
	public static void showCart(int productId, String Mnumber) {

			System.out.println("Shopping Cart : ");
			System.out.println("........");
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce","root","Swara@28041996");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select *, (givenquantity*price) As totalprice from cart");
				
				while(rs.next())
				{
					if(Mnumber.equals(rs.getString(5)))
					{
					System.out.println("productId:"+rs.getInt(1)+ "\n" + "productName:"+rs.getString(2)+"\n" + "required quantity:"+rs.getInt(3)+ "\n" + "price:"+rs.getDouble(4)+ "\n" + "total price:"+rs.getDouble(7));
				    }
				}
				
				conn.close();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce","root","Swara@28041996");
				PreparedStatement stmt = conn.prepareStatement("select *, sum(givenquantity*price) As payableprice from cart where MobileNumber = ? and PaymentStatus = ?");	
				stmt.setString(1, Mnumber);
				stmt.setString(2, "UNPAID");

				ResultSet rs = stmt.executeQuery();
				
				rs.next();
				    
					//System.out.println("productId:"+rs.getInt(1)+ "\n" + "productName:"+rs.getString(2)+"\n" + "required quantity:"+rs.getInt(3)+ "\n" + "price:"+rs.getDouble(4)+ "\n" );
				     

					System.out.println("Total Payable Amount....");
					 System.out.println("payable price:"+rs.getDouble(7));
				
				conn.close();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			
		}	

	
	}
	

