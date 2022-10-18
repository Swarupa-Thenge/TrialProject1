package com.project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin {

	public static void adminLogin()
	{
		Scanner scc = new Scanner(System.in);
		System.out.println("Enter User Name");
		String userName = scc.next();
		System.out.println("Enter User Password");
		String password = scc.next();
		if(userName.equals("admin") &&  password.equals("1234"))
		{
			System.out.println("LoggedIn Successfully...");
			
			//userPurchaseHistory
		}
		
	}
	public static void checkQuantity()
	{
		try {
			Scanner d = new Scanner(System.in);
			System.out.println("Enter Product ID : ");
			int f = d.nextInt();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce","root","Swara@28041996");
			PreparedStatement stmt = conn.prepareStatement("select * from productdetails where productId = ?");
			stmt.setInt(1, f);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				System.out.println("Product ID :  "+rs.getInt(1)+ "  Product Name :  "+  rs.getString(2)+ "  Product Total Quantity :  "+ rs.getInt(4)+ " Product Remaining Quantity :  "+ rs.getInt(6));
			}
			conn.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	public static void checkAllQuantity() {

		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce","root","Swara@28041996");
			PreparedStatement stmt = conn.prepareStatement("select * from productdetails ");
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				System.out.println("Product ID :  "+rs.getInt(1)+ "  Product Name :                 "+  rs.getString(2)+ "                  Product Total Quantity :    "+ rs.getInt(4)+ " Product Remaining Quantity :       "+ rs.getInt(6));
			}
			conn.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void inputs() {
        Scanner ff = new Scanner(System.in);
		
		System.out.println("To Check Register User List : Enter A");
		
		System.out.println("To Check ProductIDWise Quantity  : Enter B ");
		
		System.out.println("To Check All Quantity  : Enter C ");
		
		System.out.println("To Check User Purchase History  : Enter D ");
		
		System.out.println("To LogOut  : Enter E ");

	
		String s = ff.next();
		if(s.equalsIgnoreCase("A")) {	
		RegisterUserList.registerUser();
		inputs();
		}
		
		else if(s.equalsIgnoreCase("B")) {	
			checkQuantity();
			inputs();
		}
	
		else if(s.equalsIgnoreCase("C")) {	

			checkAllQuantity();
			inputs();
		}
		else if(s.equalsIgnoreCase("D")) {	
			userPurchaseHistory();
			inputs();
		}
		
		else if(s.equalsIgnoreCase("E")) {	
			System.out.println("LogOut Successfully....");
			HomePage.homepageInputs();
		}
		
		else {
			System.out.println("Check The Input");
			inputs();
		}
		
	}
	public static void userPurchaseHistory() {

		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce","root","Swara@28041996");
			PreparedStatement stmt = conn.prepareStatement("select * from cart where PaymentStatus ='PAID' ");
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				System.out.println("Product ID :  "+rs.getInt(1)+ "  Product Name :                 "+  rs.getString(2)+ "                  Product Quantity :    "+ + rs.getInt(3)+ "Product Price :  "+rs.getDouble(4)+ "Mobile Number  "+rs.getString(5)+ "Payment Status :  "+ rs.getString(6));
			}
			conn.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	}
	
}
