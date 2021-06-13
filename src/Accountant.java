import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Accountant {
	PreparedStatement p;
	Connection conn;
	ResultSet r;
	Accountant(Connection conn)
	{
		this.conn = conn;
	}
	public int depositMoney(int accNum, double amount)
	{
		//Check existence
		if ( verifyAccountExistence(accNum) == 0 )
		{
			return 0;
		}
		else if ( verifyAccountExistence(accNum) == -1 )
		{
			return -1;
		}
		//Update
		try
		{
			String deposit = "UPDATE account set balance = round( balance + " + amount + ",4) where number = " + accNum;
			
			p = conn.prepareStatement(deposit);
			p.execute();
		}
		catch(Exception e)
		{
			return -1;
		}
		return 1;
	}
	public int withDrawMoney(int accNum, double amount)
	{
		//Check existence
		if ( verifyAccountExistence(accNum) == 0 )
		{
			return 0;
		}
		else if ( verifyAccountExistence(accNum) == -1 )
		{
			return -1;
		}
		//Check current amount
		try
		{
			String deposit = "select balance from account where number = " + accNum;
			
			p = conn.prepareStatement(deposit);
			r = p.executeQuery();
			
			while ( r.next() )
			{
				if ( r.getDouble(1) < amount )
				{
					return 0;
				}
			}
		}
		catch(Exception e)
		{
			return -1;
		}
		//Update
		try
		{
			String deposit = "UPDATE account set balance = round( balance - " + amount + ",4) where number = " + accNum;
			
			p = conn.prepareStatement(deposit);
			p.execute();
		}
		catch(Exception e)
		{
			return -1;
		}
		return 1;
	}
	public int verifyAccountExistence(int accNum)
	{
		try
		{
			String verify = "select number from account where number = " + Integer.toString(accNum);
			p = conn.prepareStatement(verify);
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
		catch( Exception e )
		{
			return -1;
		}
		return 1;
	}
}
