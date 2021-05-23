

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Customer_Login 
{
	Connection conn;
	PreparedStatement p;
	ResultSet r;
	
	Customer_Login(Connection conn)
	{
		this.conn = conn;
	}
	public int Customer_Login_Info(String username, String password)
	{
		try
		{
			String query = "select id from customer where username = '" + username +"' and password1 = password('" + password + "')";
			p = conn.prepareStatement(query);
			
			r = p.executeQuery();
			int count = 0;
			
			while ( r.next() )
			{
				count = r.getInt(1);
			}
			if ( count == 0 )
			{
				return 0;
			}
			return count;
		}
		catch(Exception e)
		{
			return -1;
		}
	}
}
