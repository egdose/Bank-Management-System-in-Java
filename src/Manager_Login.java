import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Manager_Login 
{
	Connection conn;
	PreparedStatement p;
	ResultSet r;
	
	Manager_Login(Connection conn)
	{
		this.conn = conn;
	}
	public int Manager_Login_Info(String username, String password)
	{
		try
		{
			String query = "select * from manager where username = '" + username +"' and password = password('" + password + "')";
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
			return -1;
		}
		return 1;
	}
}