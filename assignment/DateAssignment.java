package in.ineuron.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateAssignment {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement pstmnt = null;
		ResultSet resultset = null;
		
		String url = "jdbc:mysql://localhost:3306/userdetails";
		String uname = "root";
		String password ="Admin@123";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Select One Option");
		System.out.println("\t1.Insert\t2.Retrive");
		int input = scan.nextInt();
		
		
		try
		{
		 connection = DriverManager.getConnection(url,uname,password);
		   switch(input)
		   {
		   case 1:
		   {
			   if(connection != null)
				{
					System.out.println("Enter username :: ");
					String username = scan.next();
					System.out.println("Enter address :: ");
					String address = scan.next();
					System.out.println("Enter gender ::");
					String gender = scan.next();
					System.out.println("Enter DOJ(dd-MM-yyyy) ::");
					String sdoj = scan.next();
					System.out.println("Enter DOB(dd-MM-yyyy) :: ");
					String sdob = scan.next();
					System.out.println("Enter DOM(yyyy-MM-dd) :: ");
					String sdom = scan.next();
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					java.util.Date uDOJ = sdf.parse(sdoj);
					java.util.Date uDOB = sdf.parse(sdob);
					
					long dojtime = uDOJ.getTime();
					long dobtime = uDOB.getTime();
					java.sql.Date sDOJ = new java.sql.Date(dojtime);
					java.sql.Date sDOB = new java.sql.Date(dobtime);
					
					java.sql.Date sDOM = java.sql.Date.valueOf(sdom);
					
				
					String sqlInsertQuery = "insert into user(`name`,`address`,`gender`,`dob`,`doj`,`dom`) value(?,?,?,?,?,?)";
					pstmnt = connection.prepareStatement(sqlInsertQuery);
					

					
					if(pstmnt != null)
					{
						pstmnt.setString(1, username);
						pstmnt.setString(2, address);
						pstmnt.setString(3, gender);
						pstmnt.setDate(4, sDOJ);
						pstmnt.setDate(5, sDOB);
						pstmnt.setDate(6, sDOM);
						
						int noOfRows = pstmnt.executeUpdate();
						System.out.println("Number of rows affected :: " + noOfRows);
						
					}
					
				}
			   break;
		
		   }
		   case 2 :
		   {
			   if(connection != null)
			   {
				   System.out.println("Enter user name you want to fetch ::");
				  String  username = scan.next();
				   String sqlSelectQuery ="select name,address,gender,doj,dob,dom from user where name=?";
				   pstmnt = connection.prepareStatement(sqlSelectQuery);
				   
				   if(pstmnt != null)
				   {
					   pstmnt.setString(1, username);
					  resultset = pstmnt.executeQuery();
					  if(resultset != null)
					  {
						  if(resultset.next())
						  {
							  String name = resultset.getString(1);
							  String address = resultset.getString(2);
							  String gender = resultset.getString(3);
							  java.sql.Date doj = resultset.getDate(4);
							  java.sql.Date dob = resultset.getDate(5);
							  java.sql.Date dom = resultset.getDate(6);
							  
							  
							  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							  String sdoj = sdf.format(doj);
							  String sdob = sdf.format(dob);
							  
							  System.out.println("Name of user ::" + name);
							  System.out.println("User Address :: " + address);
							  System.out.println("Gender :: " + gender);
							  System.out.println("DOJ (dd-MM-yyyy) :: " + sdoj);
							  System.out.println("DOB (dd-MM-yyyy) :: " + sdob);
							  System.out.println("DOM (YYYY-MM-dd) :: " + dom);
							  
							  
						  }
					  }
					   
				   }
			   }
		   }
		   break;
			   
		   }
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
			{
				connection.close();
			}
			if(scan != null)
			{
				scan.close();
			}
		}
		
	}

}
