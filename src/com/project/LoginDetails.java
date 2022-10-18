package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;


public class LoginDetails {
		public static void LoginData() {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce","root","Swara@28041996");
				PreparedStatement stmt = conn.prepareStatement("select * from RegiData where MobileNumber=?");
				System.out.println("....Login Page....." );
				Scanner Scan = new Scanner(System.in);

				System.out.println("enter the mobile number"); 
				String Mnumber = Scan.nextLine();
				stmt.setString(1,Mnumber);
				System.out.println("enter the password");
				String password = Scan.nextLine();
				ResultSet rs5 = stmt.executeQuery();
				while(rs5.next()) {
	
				
				if(Mnumber.equals(rs5.getString(3)) ){
					
					if(password.equals(rs5.getString(5)) )
					
					{
						System.out.println( "Successfully Loggedin");
						Main.productDisplay();
						Main.getQuantity(rs5.getString(3));
					}  
					else
					{
					 System.out.println("Invalid User");
					 for(int i=1;i<=3;i++)
					 { 
						 if(i<3)
						 {
							 LoginData();
						 }
						 else 
						 {
							 RegistrationData.register();	
						 }
					 }
					
					}
				}
				
				}
				 conn.close();
			
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}

  }

