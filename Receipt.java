package com.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Receipt {


	public void Receipt() throws Exception {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
			Statement st= (Statement) con.createStatement();
			
			ResultSet rs=st.executeQuery("select password from login");
		    Scanner sc=new Scanner(System.in);
		   
			System.out.println("\nForwarding to Payment...");
			System.out.println("Enter Your Password for Payment : ");
			 String pass=sc.next();
			while (rs.next()) 
			{
				if(pass.equals(rs.getString(2)))
						{
					System.out.println("       Receipt        ");
					ResultSet rs1= ((java.sql.Statement) st).executeQuery
							("select customer11.first_name,customer11.last_name,hotel.hotel_name,customer11.phone,bill.r_id,hotel.address,bill.tax,bill.amount from((bill inner join customer11 on bill.c_id=customer11.c_id) inner join hotel on bill.h_id= hotel.h_id)");
					while(rs1.next())
					{
						 System.out.println("Customer Name is :"+rs1.getString("first_name")+rs1.getString("last_name")+"\n"
					        +"Customer Phone is : "+rs1.getBigDecimal("phone")+"\n"+"Hotel Name is : "+rs1.getString("hotel_name")
				    	  +"\n"+"Hotel Phone No : "+rs1.getBigDecimal("Phone")+"\n"+"Hotel Address is : "+rs1.getString("Address")+"\n"+"Room Id is : "+rs1.getInt("r_id")
				    	  +"\n"+"tax : "+rs1.getInt("tax")+"\n"+"Amount : "+rs1.getInt("Amount"));
				    
					}
					st.executeBatch();
					st.close();
					rs1.close();
					rs.close();
						}	
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
