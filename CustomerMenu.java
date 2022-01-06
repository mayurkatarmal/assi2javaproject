package com.registration;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CustomerMenu 
{

	


	public int Hotelid;

	public void SearchHotel() throws Exception  {
		// TODO Auto-generated method stub
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management","root","root");
		Statement st= (Statement) con.createStatement();
		
		int cat=0;
		System.out.println("**********Select Category**************** "
		            +"\n 1.A.C."
		            +"\n 2.Non A.C."
		            +"\n 3.Suite"
		            +"\n 0: Exit");
			System.out.println("****************************");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Category :");
		    cat = sc.nextInt();
		    int no=0;
			switch(cat)
			{
				case 1:
					ResultSet rs= ((java.sql.Statement) st).executeQuery
							("select hotel.h_id, Hotel.hotel_name, Hotel.Address,Hotel.Email_id,Hotel.phone,Room_details.catagory from hotel inner join room_details on hotel.h_id= Room_details.H_id where room_details.catagory='ac'");						
			      while(rs.next())
			      {
			    	  System.out.println("Hotel ID:"+rs.getInt("h_id")+"----"+rs.getString("hotel_name")+"----"+rs.getString("Address")
			    	  +"----"+rs.getString("Email_id")+"----"+rs.getBigDecimal("Phone")+"----"+rs.getString("catagory"));
			      no++;
			      }
		
					break;
				case 2:
					ResultSet rs1= ((java.sql.Statement) st).executeQuery
							("select hotel.h_id,Hotel.hotel_name, Hotel.Address,Hotel.Email_id,Hotel.phone,Room_details.catagory from hotel inner join room_details on hotel.h_id= Room_details.H_id where room_details.catagory='non_ac'");						
					 while(rs1.next())
				      {
				    	  System.out.println("Hotel ID:"+rs1.getInt("h_id")+"----"+rs1.getString("hotel_name")+"----"+rs1.getString("Address")
				    	  +"----"+rs1.getString("Email_id")+"----"+rs1.getBigDecimal("Phone")+"----"+rs1.getString("catagory"));
				      no++;
				      }
					break;
				case 3:
					ResultSet rs2= ((java.sql.Statement) st).executeQuery
							("select hotel.h_id,Hotel.hotel_name, Hotel.Address,Hotel.Email_id,Hotel.phone,Room_details.catagory from hotel inner join room_details on hotel.h_id= Room_details.H_id where room_details.catagory='suite'");						
					 while(rs2.next())
				      {
				    	  System.out.println("Hotel ID:"+rs2.getInt("h_id")+"----"+rs2.getString("hotel_name")+"----"+rs2.getString("Address")
				    	  +"----"+rs2.getString("Email_id")+"----"+rs2.getBigDecimal("Phone")+"----"+rs2.getString("catagory"));
				      no++;
				      }
					break;	
				case 0:
					System.exit(0);
					
			}//switch
			
			System.out.println("----------------------------------\n Total available Rooms : "+no);
			System.out.println("--------------------------------------------------------------------------------------------------------");
			
			System.out.println("Enter choice:"
					       +"\n 1.Book Hotel"
			               +"\n 0.Exit");
			int ch=sc.nextInt();
			switch(ch) 
			{
			case 1:
				System.out.println("");
				PreparedStatement stmt=con.prepareStatement("update  room_details set check_in=?,check_out=? where h_id=?");
				
				System.out.println("Enter Check In Date : ");
				SimpleDateFormat dateInput = new SimpleDateFormat("yyyy-MM-dd");
				//Scanner sc=new Scanner(System.in);
				String check_in = sc.next();
				Date date = dateInput.parse(check_in);
				   //System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
				 
				System.out.println("-----------------------------------");
				
				System.out.println("Enter Check Out Date : ");
				//SimpleDateFormat dateInput1 = new SimpleDateFormat("yyyy-MM-dd");
				String check_out = sc.next();
				 Date date1 = dateInput.parse(check_out);
				   //System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
					
					 
				
			System.out.println("---------------------------------------");
			System.out.println("Enter how many rooms you want to book..");
			int i=sc.nextInt();
			int j;
			if(i<=no)
			{
			for( j=0;j<i;j++)
			{
			
				PreparedStatement stmt1=con.prepareStatement("update bill set h_id=? ");
			System.out.println("Enter Hotel Id where you want to book room :");
			int hotelid=sc.nextInt();

			stmt.setString(1, check_in);
			stmt.setString(2,check_out );
			stmt.setInt(3, hotelid);
			stmt1.setInt(1, hotelid);
			stmt.executeUpdate();
			stmt1.executeUpdate();
			System.out.println("Bill updated.......");
			stmt1.close();
			}
			System.out.println("----------------------------------------------------------------");
			System.out.println("Congratulations.........\n"+j+" Room Booked");
			System.out.println("----------------------------------------------------------------");
			System.out.println("Generating Payment Receipt..\n\n\n\n\n");
			Receipt rp=new Receipt();
			rp.Receipt();
			}
			else 
			{
				System.out.println("Error only "+no+" Rooms are available... \n Please try again");
			}	
			
		    stmt.close();	
		    st.close();
		    con.close();
				break;
			case 0:
					System.exit(0);			
			}//switch
		
		}
			catch (SQLException | ClassNotFoundException | ParseException e) 
			{
				e.printStackTrace();
			   System.out.println("Parce Exception");
			}
			
		
	
		
	}//search hotel
	
}//class	
	
	
	
