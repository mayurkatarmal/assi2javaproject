package com.registration;


import java.util.Scanner;

public class CustomerWelcomePage 
{

		public static void main(String[]args) throws Exception
		{
			
			
			int choice=0;
			do
		      {
				System.out.println("*************Welcome*************");
				
				Scanner sc=new Scanner(System.in);
				System.out.println("Select option below...."
						            +"\n 1.Search Rooms"
						            +"\n 2.Show Booked Hotel"
						            +"\n 3.Update Account"
						            +"\n 0.Exit");
				System.out.println("*****************************");
				System.out.println("Enter Choice");
				 choice=sc.nextInt();
				
				switch(choice)
				{
				case 1:
					CustomerMenu cm=new CustomerMenu();
					cm.SearchHotel();
					break;
				
				case 2:
					ShowBooked sb=new ShowBooked();
					sb.ShowBooked();
					break;
				case 3:
					System.out.println("Update Account: "
							          +"\n1.Update First Name"
							          +"\n2.Update last Name"
							          +"\n3.Email Id"
							          +"\n4.Phone No");
					break;
					
				case 0:
					System.exit(0);
				default:
					System.out.println("Enter Valid Input");
					break;
					
				 }//switch
				
		      }//do
			while
				(choice!=0);
			
			
		}
		

		
		
		}

	


