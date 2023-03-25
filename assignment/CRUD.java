package in.ineuron.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUD {

	public static void main(String[] args) throws SQLException {
		
		
		
		String url = "jdbc:mysql://localhost:3306/employeedetails";
		String user = "root";
		String password = "Admin@123";
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		Scanner scan = new Scanner(System.in);
		String empname;
		int empage;
		String emploc;
		int empid;
		
		
		
		System.out.println("...Select one option from menu given below to perform the operation...");
		System.out.println("1.Create/Insert\t2.Read\t    3.Update \t4.Delete");
		
		int enter = scan.nextInt();
		
		try
		{
			connection = DriverManager.getConnection(url,user,password);
			if(connection != null)
			{
				statement = connection.createStatement();
				if(statement != null)
				{
					switch(enter)
					{
					case 1:
					{
						System.out.println("Enter employee name :: ");
						 empname = scan.next();
						System.out.println("Enter emloyee age :: ");
						empage  = scan.nextInt();
						System.out.println("Enter employee location :: ");
						emploc = scan.next();
						String Query = String.format("insert into employee(`emp_name`,`emp_age`,`emp_loc`) values('%s',%d,'%s')", empname,empage,emploc);
						System.out.println("Table Created with the data you provided");
					    int noOfRows = statement.executeUpdate(Query);
					    System.out.println("No of rows affected :: " + noOfRows);
					    break;
					}
					case 2:
					{
						System.out.print("\t\t=======please___enter======= \n1 to view entire table. \t&&\t2 to view employee details based on id::");
						int input = scan.nextInt();
						if(input == 1)
						{
							String sqlSelectQuery = "select emp_id,emp_name,emp_age,emp_loc from employee";
							resultset = statement.executeQuery(sqlSelectQuery);
							if(resultset != null)
							{
								System.out.println("======== Employee Details ==========");
								System.out.println("EMP_ID\tEMP_NAME EMP_AGE EMP_LOC");
								while(resultset.next())
								{
									Integer id = resultset.getInt(1);
									String name = resultset.getString(2);
									Integer age = resultset.getInt(3);
							
									String location = resultset.getString(4);
									//System.out.println("======== Employee Details ==========");
									System.out.println(id + "\t" + name + "\t" + age +"\t"+ location );
								}
						   }
				
							}
						else if(input==2)
						{
							System.out.println("please enter id of the employee you want :: ");
							empid=scan.nextInt();
							String sqlSelectQuery = "select emp_id,emp_name,emp_age,emp_loc from employee where emp_id=" + empid;
							resultset = statement.executeQuery(sqlSelectQuery);
							if(resultset != null)
							{
								System.out.println("======== Employee Details ==========");
								System.out.println("EMP_ID\tEMP_NAME\tEMP_AGE\tEMP_LOC");
								while(resultset.next())
								{
									Integer id = resultset.getInt(1);
									String name = resultset.getString(2);
									Integer age = resultset.getInt(3);
							
									String location = resultset.getString(4);
									//System.out.println("======== Employee Details ==========");
									System.out.println(id + "\t" + name + "\t" + age +"\t"+ location );
								}
						}
						}
							else
							{
								System.out.println("please select either 1 or 2...");
							}
					
						break;
					}
						
					case 3:
					{
						System.out.println("please select one option given below");
						System.out.println("1.To Update Location of Employee");
						System.out.println("2.To Update Name of Employee");
						int input = scan.nextInt();
						
						if(input==1)
						{
							System.out.println("enter employee id to update :: ");
							empid=scan.nextInt();			
							System.out.println("Enter the location you want to change for the employee with id  " + empid + " :: ");
							emploc = scan.next();
							String sqlUpdateQuery = "update employee set  emp_loc="+ "'"+emploc+"'" + "" + "where emp_id=" + empid;
						    int noOfRows = statement.executeUpdate(sqlUpdateQuery);
						    System.out.println("No of rows affected :: " + noOfRows);
						}
						else if(input==2)
						{
							System.out.println("enter employee id to update :: ");
							empid=scan.nextInt();
							System.out.println("Enter employee name to change :: ");
							empname = scan.next();
							String sqlUpdateQuery = "update employee set  emp_name="+ "'"+empname+"'" + "" + "where emp_id=" + empid;
						    int noOfRows = statement.executeUpdate(sqlUpdateQuery);
						    System.out.println("No of rows affected :: " + noOfRows);
						}
						else
						{
							System.out.println("please select from given options...");
						}
						
					    
					    break;
					}
					case 4:
					{
						System.out.println("enter employee id to delete :: ");
						empid=scan.nextInt();
						String sqlDeleteQuery = "delete from employee where emp_id=" + empid;
						
					    int noOfRows = statement.executeUpdate(sqlDeleteQuery);
					    System.out.println("Employee with id  " + empid + " details deleted successfully...");
					
					    System.out.println("no.of rows effected :: " + noOfRows);
					    break;
					}
					}
					
						
				}
			}
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(resultset != null)
			{
				resultset.close();
			}
			if(statement != null)
			{
				statement.close();
			}
			if(connection!= null)
			{
				connection.close();
			}
			if(scan != null)
			{
				scan.close();
			}
			System.out.println("connection closed...");
		}

	}

}
