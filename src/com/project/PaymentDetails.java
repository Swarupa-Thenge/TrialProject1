package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PaymentDetails {

public static void payment(String Mnumber)
	{
		
					System.out.println("Do you want to logout ... Enter A" );
					System.out.println("Do you want to continue buying ... Enter B" );

					Scanner sc3 = new Scanner(System.in);
					String r = sc3.next();
					if(r.equalsIgnoreCase("A"))
					{
						System.out.println("LogOut Successfully....");
						HomePage.homepageInputs();
					}
					else if(r.equalsIgnoreCase("B"))
					{
						Main.productDisplay();
						Main.getQuantity(Mnumber);
					}
					else {
						System.out.println("Check The Input");
					}
	
	}
	public static void paymentstatus(String Mnumber, int productId ) {
		
		try {
			System.out.println("Enter your amount");
			Scanner sc3 = new Scanner(System.in);
			double amount = sc3.nextDouble();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce","root","Swara@28041996");
			PreparedStatement stmt = conn.prepareStatement("select *, sum(givenquantity*price) As payableprice from cart where MobileNumber = ? and PaymentStatus = ?");	
			stmt.setString(1, Mnumber);
			stmt.setString(2, "UNPAID");
			ResultSet rs4 = stmt.executeQuery();
			rs4.next();
		
			if(amount == rs4.getDouble(7)) {

			PreparedStatement stmt6 = conn.prepareStatement("update cart set PaymentStatus = ? where MobileNumber = ?");	
				stmt6.setString(1, "PAID");
	            stmt6.setString(2, Mnumber );
	            
			int y= stmt6.executeUpdate();
				}
			else {
				System.out.println("unpaid");
			}
		
			conn.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
	}
}
