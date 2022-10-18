package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void productDisplay() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce","root","Swara@28041996");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from productdetails");
			
			while(rs.next())
			{
				Product pr = new Product (rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getDouble(5) );
				System.out.println(pr.toString());
			}
			conn.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
	}
	public static void getQuantity(String Mnumber) {
		String p = "UNPAID";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce","root","Swara@28041996");
			PreparedStatement stmt = conn.prepareStatement("select productId,productName,Price,quantity,remainingQuantity from productdetails where productId =?");
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the ProductId");
			int i = sc.nextInt();
			stmt.setInt(1, i);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			PreparedStatement stmt7 = conn.prepareStatement("insert into cart value(?,?,?,?,?,?)");
			
			System.out.println("Enter the Quantity");
			int i2 = sc.nextInt();
			
			if(i2<= rs.getInt(5)) {
	
            stmt7.setInt(1, rs.getInt(1));
            stmt7.setString(2, rs.getString(2));
            stmt7.setInt(3, i2);
            stmt7.setDouble(4, rs.getDouble(3));
            stmt7.setString(5, Mnumber);
            stmt7.setString(6, "UNPAID");
			int j = stmt7.executeUpdate();
			
			System.out.println("Added to Cart Successfully");

			}
			else {
				System.out.println("Out of Stock");
			}
			
			PreparedStatement stmt0 = conn.prepareStatement("update productdetails set remainingQuantity = ? where productId = ?");
			
			stmt0.setInt(1, (rs.getInt(5)-i2));
			
			stmt0.setInt(2, i);

			int h = stmt0.executeUpdate();
			
			
			System.out.println("Do you want to continue buying..... Y or N");
			Scanner sc2 = new Scanner(System.in);
			String s1 = sc2.next();
			if(s1.equalsIgnoreCase("Y"))
			{
				productDisplay();
				getQuantity(Mnumber);		
			}
			else if(s1.equalsIgnoreCase("N"))
			{
			
				ShoppingCart sp = new ShoppingCart();
				sp.showCart(i,Mnumber);
		     	System.out.println("Proceed to payment");
				System.out.println("Do you want to pay.... Y or N");
				Scanner sc3 = new Scanner(System.in);
				String r = sc3.next();
				if(r.equalsIgnoreCase("Y"))
				{
				
					PaymentDetails.paymentstatus(Mnumber, i);
					PaymentDetails.payment( Mnumber);
				}
				else if(s1.equalsIgnoreCase("N"))
				{
					System.out.println("Do you want to louout ... Enter A" );
					System.out.println("Do you want to continue buying ... Enter B" );

					Scanner sc7 = new Scanner(System.in);
					String rr = sc7.next();
					if(rr.equalsIgnoreCase("A"))
					{
						System.out.println("LogOut Successfully....");
						HomePage.homepageInputs();
					}
					else if(rr.equalsIgnoreCase("B"))
					{
						productDisplay();
						getQuantity(Mnumber);
					}
					else {
						System.out.println("Check The Input");
					
				}		
			}
		
		else
			{System.out.println("Check The Input");
				getQuantity(Mnumber);
				
			}
			 conn.close();
			 stmt.close();
			}
		}
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
	}
	
	public static void main(String[] args) {
	
		//RegisterUserList.registerUser();
		//RegistrationData.register(); 	
		//LoginDetails.LoginData();
		
		
	
	}

}
