package com.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowBooked {

	public void ShowBooked() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
		Statement st= (Statement) con.createStatement();
		
		
		ResultSet rs= ((java.sql.Statement) st).executeQuery
			("select hotel1.h_id, Hotel1.hotel_name, Hotel1.Address,Hotel1.Email_id,Hotel1.phone,Room_details.catagory,Room_details.price from hotel1 inner join room_details on hotel1.h_id= Room_details.H_id where check_in!=null");	//I have doubt in the last part					
	    
		CustomerMenu cm=new CustomerMenu();
		cm.SearchHotel();
		
		
		while(rs.next())
	      {
	    	  System.out.println("Hotel ID:"+rs.getInt("h_id")+
	    	 "----"+rs.getString("hotel_name")+ "----"+rs.getString("Address")
	    	  +"----"+rs.getString("Email_id")+"----"+rs.getBigDecimal("Phone")+
	    	  "----"+rs.getString("catagory")+
	    	  "----"+"    "+rs.getDouble("price"));
	     
	      }
		st.executeBatch();
		rs.close();
		st.close();
		con.close();
	
		}
		
	}

	


