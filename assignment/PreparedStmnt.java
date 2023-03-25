package in.ineuron.assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStmnt {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		PreparedStatement pstmnt = null;
		ResultSet resultset = null;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("...Select one option from menu given below to perform the operation...");
		System.out.println("1.Create/Insert\t2.Read\t    3.Update \t4.Delete");
		
		int enter = scan.nextInt();
		

		
		try
		{
			connection =JdbcUtil.getJdbcConnection();
			
			if(connection != null)
			{
				switch(enter)
				{
				case 1:
				{
					String sqlInsertQuery = "insert into employee(`emp_name`,`emp_age`,`emp_loc`) values(?,?,?)";
					pstmnt = connection.prepareStatement(sqlInsertQuery);
					if(pstmnt != null)
					{
						System.out.println("Enter employee name::");
						String emp_name = scan.next();
						System.out.println("Enter employee age::");
						int emp_age = scan.nextInt();
						System.out.println("Enter employee Location::");
						String emp_loc = scan.next();
						
						pstmnt.setString(1, emp_name);
						pstmnt.setInt(2, emp_age);
						pstmnt.setString(3, emp_loc);
						
						int noOfRows = pstmnt.executeUpdate();
						System.out.println("No of rows affected :: " + noOfRows);
						
					}
					
					
					break;
				}
				case 2:
				{

					System.out.println("Enter One Option");
					System.out.println("1.To ViewBased On EMP ID \t 2.To View Entire Data ::");
					int input = scan.nextInt();
					if(input == 1)
					{
					String sqlSelectQuery = "select emp_id,emp_name,emp_age,emp_loc from employee where emp_id=?";
					pstmnt = connection.prepareStatement(sqlSelectQuery);
					System.out.println("Enter employee id to fetch the data::");
					int empid = scan.nextInt();
					if(pstmnt != null)
					{
						
						
						pstmnt.setInt(1, empid);
						resultset = pstmnt.executeQuery();
						
					}
					if(resultset!=null)
					{
						if(resultset.next())
						{
							System.out.println("======== Employee Details ==========");
							System.out.println("EMP_ID\tEMP_NAME EMP_AGE EMP_LOC");
							System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getInt(3)+"\t"+resultset.getString(4));
						}
						else
						{
							System.out.println("Record not available for the given id:: " + empid);
						}
					}
					}
					else if(input == 2)
					{
						String selectQuery = "select emp_id,emp_name,emp_age,emp_loc from employee";
						pstmnt = connection.prepareStatement(selectQuery);
						if(pstmnt != null)
						{
							resultset = pstmnt.executeQuery();
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
									System.out.println(id + "\t" + name + "\t" + age +"\t"+ location );
								}
						   }
							
						}
						
					}
					break;
				}
				case 3:
				{
					
					String sqlUpdateQuery = "update employee set emp_name=?,emp_age=?,emp_loc=? where emp_id=?";
					pstmnt = connection.prepareStatement(sqlUpdateQuery);
					System.out.println("Enter employee id to update the data::");
					int empid = scan.nextInt();
					if(pstmnt != null)
					{
						
						System.out.println("Enter employee name to update::");
						String emp_name = scan.next();
						System.out.println("Enter employee age to update::");
						int emp_age = scan.nextInt();
						System.out.println("Enter employee Location to update::");
						String emp_loc = scan.next();
						
						
						
						pstmnt.setString(1, emp_name);
						pstmnt.setInt(2, emp_age);
						pstmnt.setString(3, emp_loc);
						pstmnt.setInt(4, empid);
						
						int noOfRows = pstmnt.executeUpdate();
						System.out.println("Details for employee id " + empid + " updated successfully..");
						System.out.println("No of rows affected :: " + noOfRows);
					}
					
					break;
				}
				case 4:
				{
					String sqlDeleteQuery ="delete from employee where emp_id=?";
					pstmnt=connection.prepareStatement(sqlDeleteQuery);
					System.out.println("Enter employee id to delete the data::");
					int empid = scan.nextInt();
					if(pstmnt != null)
					{
						pstmnt.setInt(1, empid);
						int noOfRows = pstmnt.executeUpdate();
						System.out.println("Employee details of id " + empid + " deleted successfully..");
						System.out.println("No of rows affected :: " + noOfRows);
					}
				
					
					break;
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
		finally {
			JdbcUtil.closeConnection(resultset, pstmnt, connection);
			if(scan != null)
			{
				scan.close();
			}
		}
		

	}

}
