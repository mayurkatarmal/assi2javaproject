package com.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class HotelRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");//load drivers
			
			//created connection with database
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
			
			
	
			Scanner sc= new Scanner (System.in);
			
			
			PreparedStatement stmt=con.prepareStatement("insert into hotel1 values(default,?,?,?,?)");
			
			System.out.println("Enter Hotel name : ");
			String Hotel_name=sc.next();
			
			System.out.println("Enter Hotel Address : ");
			String Address=sc.next();
			
			System.out.println("Enter Email : ");
			String Email_id=sc.next();
			
			System.out.println("Enter Phone No : ");
			long Phone=sc.nextLong();
			
			
			stmt.setString(1, Hotel_name);
			stmt.setString(2, Address);
			stmt.setString(3, Email_id);
			stmt.setLong(4, Phone);
			
			stmt.execute();
			System.out.println("Data inserted Successfully");
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}

