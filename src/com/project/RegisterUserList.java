package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterUserList {
 
	public static void registerUser() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce","root","Swara@28041996");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from regidata");
			
			while(rs.next())
			{
				System.out.println("First Name:  " + rs.getString(1) + "  Last Name :  "+ rs.getString(2)+ "  Mobile Number :   "+ rs.getString(3)+ "  E-mail ID :   "+ rs.getString(4));
			}
			conn.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
	}
	
}
