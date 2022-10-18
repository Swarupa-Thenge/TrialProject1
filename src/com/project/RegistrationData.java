package com.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RegistrationData {

		public static void register() {
              System.out.println( ".......Registration Page.......");
			Scanner Scan = new Scanner(System.in);

			System.out.println( "Enter the First Name ");

			String fname = Scan.nextLine();

			System.out.println("Enter the Last Name ");

			String lname = Scan.nextLine();

			System.out.println("Enter the Email Address");
	         
			String emailaddress = Scan.nextLine();

			System.out.println("Enter the mobile number");

			String Mnumber = Scan.nextLine();
			
			System.out.println("Enter the Password");
			
			String password = Scan.nextLine();
			

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce", "root",
						"Swara@28041996");

				PreparedStatement ps = conn
						.prepareStatement("insert into RegiData(FirstName,LastName,MobileNumber,EmailId,Password)values(?,?,?,?,?)");

				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, Mnumber);
				ps.setString(4, emailaddress);
				ps.setString(5,password);
				int j = ps.executeUpdate();

				System.out.println( "sucessfully Registration is done... "+ j);
				conn.close();
				ps.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			

		}

	}

