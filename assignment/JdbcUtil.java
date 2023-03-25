package in.ineuron.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	private JdbcUtil()
	{
		
	}
	
	public static Connection getJdbcConnection() throws SQLException
	{
		Connection connection = null;
		//2.establishing connection 
		String url = "jdbc:mysql://localhost:3306/employeedetails";
		String username = "root";
		String password = "Admin@123";
		connection = DriverManager.getConnection(url,username,password);
		
		if(connection!=null)
			return connection;
		return connection;
		
	}

	public static void closeConnection(ResultSet resultset,Statement statement,Connection connection) throws SQLException
	{
		if(resultset != null)
		{
			resultset.close();
		}
		if(statement != null)
		{
			statement.close();
		}
		if(connection != null)
		{
			connection.close();
		}
	}

}
