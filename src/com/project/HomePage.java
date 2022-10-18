package com.project;

import java.util.Scanner;

public class HomePage {

	
	public static void homepageInputs() {	
		
		System.out.println("For Admin LogIn .... Enter A");
		System.out.println("For Customer LogIn .... Enter B");
		System.out.println("For Customer Registration .... Enter C");

		Scanner sa = new Scanner(System.in);
		String s = sa.next();
		if(s.equalsIgnoreCase("A")) {	
		Admin.inputs();
		}
		
		else if(s.equalsIgnoreCase("B")) {	
			LoginDetails.LoginData();
		}
	
		else if(s.equalsIgnoreCase("C")) {	
			RegistrationData.register();
			LoginDetails.LoginData();
		}
		else {
			System.out.println("Check The Input");
			homepageInputs();
		}
	}
public static void main(String[] args) {
	homepageInputs();
	}
}

