import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Accountant_Login {
	Connection conn;
	PreparedStatement p;
	ResultSet r;
	
	Accountant_Login(Connection conn)
	{
		this.conn = conn;
	}
	public int Accountant_Login_Info(String username, String password)
	{
		try
		{
			String query = "select * from accountant where username = '" + username +"' and password = password('" + password + "')";
			p = conn.prepareStatement(query);
			
			r = p.executeQuery();
			int count = 0;
			
			while ( r.next() )
			{
				count++;
			}
			if ( count == 0 )
			{
				return 0;
			}
		}
		catch(Exception e)
		{
			//Error occured in backend system
			return -1;
		}
		return 1;
	}

}