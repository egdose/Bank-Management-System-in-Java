import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class EstablishConnection 
{
	Connection conn;
	
	public EstablishConnection()
	{
		String url = "jdbc:mysql://localhost:3306/bms";
	    String username = "root";
	    String password = "";
	    
	    try 
	    {
	      conn = DriverManager.getConnection(url, username, password);
	      
	      System.out.println("Connected!");

	    } 
	    catch (SQLException ex) 
	    {
	        throw new Error("Error ", ex);
	    }
	}
	public Connection getConnection()
	{
		return conn;
	}
}
