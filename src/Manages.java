import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Manages {
	PreparedStatement p;
	Connection conn;
//	Manager man;
	Manages(Connection conn)
	{
		this.conn = conn;
		//this.man = new Manager();
	}
	public ArrayList<String> AccountDetailsfromAccountNumber(int accNum)
	{
		int count = 0;
		ArrayList<String> s = new ArrayList<>();
		try
		{
			String query = "select * from account where number = " + accNum;

			p = conn.prepareStatement(query);
			ResultSet r = p .executeQuery();

			while ( r.next() )
			{
				s.add(r.getString(8));
				s.add(r.getString(2));
				s.add(r.getString(3));
				s.add(r.getString(4));
				String date = r.getString(5);
				String [] args = date.split(" ");
				s.add(args[0]);
				s.add(args[1]);
				s.add(r.getString(6));
				s.add(r.getString(7));
				count++;
			}
			if ( count == 1 )
			{
				String fetchCustomerName = "select name from person where id = (select person_id from customer where id = " + s.get(0) + ")";
				p = conn.prepareStatement(fetchCustomerName);
				r = p.executeQuery();

				while ( r.next() )
				{
					//Get customer name
					s.add(1,r.getString(1));
				}
			}
		}
		catch(Exception e)
		{
			return null;
		}
		if ( count == 0 )
		{
			return null;
		}
		else
		{
			return s;
		}
	}
	public int VerifyAccount(int accNum)
	{
		try
		{
			//Checking if account Number exist or not
			String fetch = "select number from account where number = " + Integer.toString(accNum);
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(fetch);


			ResultSet r = preparedStatement.executeQuery();

			int count = 0;
			while (r.next() )
			{
				count++;
			}
			if ( count == 0 )
			{
				return 0;
			}

		} 
		catch (Exception e)
		{
			return -1;
			//throw e;
		}
		return 1;
	}

	//Check customer Existence
	public String getCustomerName(int custID)
	{
		try
		{
			//Checking customer existence
			String checkCustomerID = "select name from person where id = (select person_id from customer where id = " + Integer.toString(custID) + ")";
			p = conn.prepareStatement(checkCustomerID);
			ResultSet chk = p.executeQuery();
			if ( chk.next() )
			{
				return chk.getString(1);
			}
			
		}
		catch(Exception e)
		{
			
			return "-1";
		}
		return "0";
	}

	//Actual insertion of Account
	public int InsertInDataBase_newAccount(int custID, 
								String title, String type , 
								int lim , double balance )
	{
		try
		{
			//Customer exists, so we now create account
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement("insert into Account(custid, owner, balance, status, type, lim) values (?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, custID);
			preparedStatement.setString(2, title);
			preparedStatement.setDouble(3, balance);
			preparedStatement.setString(4, "active");
			preparedStatement.setString(5, type);
			preparedStatement.setInt(6, lim);
			//Commit like work
			preparedStatement.execute();
			
			//Fetching account number
			String fetch = "select max(number) from account";
			//Now fetch the same row against this data to show the user account number, so that he can save
			preparedStatement = conn.prepareStatement(fetch);
			
			
			ResultSet r = preparedStatement.executeQuery();
			
			
			String accNum = "";
			
			while ( r.next() )
			{
				accNum = r.getString(1);
				//System.out.println("Account Number : " + accNum);
			}
			return Integer.parseInt(accNum);
		} 
		catch (Exception e)
		{
			return -1;
			//throw e;
		}
	}
	
	//Deletion of Account.
	public int deleteAccountfromDatabase(String accNum)
	{
		try
		{
			PreparedStatement preparedStatement;
			//If we reached here that means account number exist, now we delete it
			String fetch = "UPDATE account set status = 'deleted' where number = " + accNum;
			preparedStatement = conn.prepareStatement(fetch);
			preparedStatement.execute();
			
		} 
		catch (Exception e)
		{
			return -1;
			//throw e;
		}
		return 1;
		
	}
	
	//Modification of Account.
	public int modifyAccountfromDatabase(String accNum, String title,
								String status, String type, String lim)
	{
		try
		{
			PreparedStatement preparedStatement;

			preparedStatement = conn.prepareStatement("UPDATE account SET owner = ?, status = ?, type = ?, lim = ? WHERE number = ?");
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, status);
			preparedStatement.setString(3, type);
			preparedStatement.setInt(4, Integer.parseInt(lim));
			preparedStatement.setInt(5, Integer.parseInt(accNum));
			

			
			preparedStatement.execute();
		} 
		catch (Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getMessage());
			return -1;
			//throw e;
		}
		return 1;
		
	}
}