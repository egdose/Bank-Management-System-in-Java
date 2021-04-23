import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Manage_Customer {
	PreparedStatement p;
    Connection conn;
	
    Manage_Customer(Connection conn) {
        this.conn = conn;
    }
    public int addCustomer(
	    		String name, String address, String contact,
	    		String CNIC, String username, String Password) 
    {

		try
		{
			p = conn.prepareStatement("insert into person(name,address,contact,CNIC) values (?,?,?,?)");
			p.setString(1,name);
			p.setString(2,address);
			p.setString(3,contact);
			p.setString(4,CNIC);
			//Commit like work
			p.execute();
			
			p = conn.prepareStatement("insert into customer(person_id,Username,password1) values ((select id from PERSON where CNIC = ?), ?, password(?))");
			p.setString(1,CNIC);
			p.setString(2,username);
			p.setString(3,Password);
			//Commit like work
			p.execute();
		} 
		catch (Exception e)
		{
			return -1;
			//throw e;
		}
		return 1;
    }
    
    public int changeAddress(String newAddress, int custID)
	{
		try
		{
			String modify = "update person set address = '" + newAddress + "' where id = (select person_id from customer where id = " + custID + ")";
			p = conn.prepareStatement(modify);
			p.execute();
		}
		catch(Exception e)
		{
			return 0;
		}
		return 1;
	}
	
	public int changeContact(String newContact, int custID)
	{
		try
		{
			String modify = "update person set contact = '" + newContact + "' where id = (select person_id from customer where id = " + custID + ")";
			p = conn.prepareStatement(modify);
			p.execute();
		}
		catch(Exception e)
		{
			return 0;
		}
		return 1;
	}
	
	public int changePassword(String newPassword, int custID)
	{
		try
		{
			String modify = "update customer set password1 = password('" + newPassword + "') where id = " + custID;
			p = conn.prepareStatement(modify);
			p.execute();
		}
		catch(Exception e)
		{
			return 0;
		}
		return 1;
	}
	
	public ArrayList<String> CustomerinfoID(String searchID)
	{
		
		ArrayList<String> rec = new ArrayList<>();
		try
		{
			String fetch = "select c.id,p.name,p.address,p.contact,c.username,c.password1,p.cnic from person p,customer c where c.id = " + searchID + " and p.id = (select person_id from customer where id ="+ searchID +")";
			
			p = conn.prepareStatement(fetch);
			ResultSet r = p.executeQuery();
			
			int count = 0 ;
			while ( r.next() )
			{
				rec.add("1");
				//Cust id
				rec.add(r.getString(1));
				//Name
				rec.add(r.getString(2));
				//Address
				rec.add(r.getString(3));
				//Contact
				rec.add(r.getString(4));
				//Username
				rec.add(r.getString(5));
				//Password
				rec.add(r.getString(6));
				//CNIC
				rec.add(r.getString(7));
				count++;
			}
			
			if ( count == 0 )
			{
				rec.add("0");
			}
			
		} 
		catch (Exception e)
		{
			rec.add("-1");
			return rec;
			//throw e;
		}
		return rec;
	}
	
	public ArrayList<String> CustomerinfoCNIC(String cnic)
	{
		ArrayList<String> rec = new ArrayList<>();
		try
		{
			String fetch = "select c.id,p.name,p.address,p.contact,c.username,c.password1,p.cnic from person p,customer c where p.cnic = '" + cnic + "' and c.person_id = (select id from person where cnic = '"+ cnic +"')";
			p = conn.prepareStatement(fetch);
			ResultSet r = p.executeQuery();
			
			int count = 0 ;
			while ( r.next() )
			{
				rec.add("1");
				//Cust id
				rec.add(r.getString(1));
				//Name
				rec.add(r.getString(2));
				//Address
				rec.add(r.getString(3));
				//Contact
				rec.add(r.getString(4));
				//Username
				rec.add(r.getString(5));
				//Password
				rec.add(r.getString(6));
				//CNIC
				rec.add(r.getString(7));
				count++;
			}
			
			if ( count == 0 )
			{
				rec.add("0");
			}
			
		} 
		catch (Exception e)
		{
			rec.add("-1");
			return rec;
			//throw e;
		}
		return rec;
	}

	

}