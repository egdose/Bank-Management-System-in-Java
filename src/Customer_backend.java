

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Customer_backend 
{
	Connection conn;
	PreparedStatement p;
	ResultSet r;
	int custID;
	Customer_backend(Connection conn, int custID)
	{
		this.conn = conn;
		this.custID = custID;
	}
	
	public void categoryList(ArrayList<String> s)
	{
		try
		{
			String maker = "";
			p = conn.prepareStatement("select type from category");
			r = p.executeQuery();
			while ( r.next() )
			{
				maker = r.getString(1);
				s.add(maker);
			}
		}
		catch(Exception e)
		{
			
		}
	}
	public void fetchBillers(ArrayList<String> billerCategory, ArrayList<ArrayList<String>> billerList) 
	{
		try
		{
			String another;
			for ( int i = 0 ; i < billerCategory.size() ; i++ )
			{
				billerList.add(new ArrayList<String>());
				another = "select name from biller where category_id = ( select id from category where type = '" + billerCategory.get(i) + "' )";
				p = conn.prepareStatement(another);
				r = p.executeQuery();
				while ( r.next() )
				{
					billerList.get(i).add(r.getString(1));
				}
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	public int addUserBiller(String name, String reference_number)
	{
		try
		{
			String fetch = "select id from users_biller where cust_id = " + custID + " and name = '" + name + "' and reference_number = " + reference_number;
			p = conn.prepareStatement(fetch);
			
			r = p.executeQuery();
			
			int count = 0;
			while ( r.next() )
			{
				count++;
			}
			
			if ( count != 0 )
			{
				return 0;
			}
			p = conn.prepareStatement("insert into users_biller(name,cust_id,reference_number) values (?,?,?)");
			p.setString(1, name);
			p.setInt(2, custID);
			p.setInt(3, Integer.parseInt(reference_number));
			
			p.execute();
		}
		catch(Exception e)
		{
			return -1;
		}
		
		return 1;
	}
	
	public int verifyPayeeExistence(int accNum)
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
	
	public int addNewPayee(int accNum, String name )
	{
		try
		{
			String fetch = "select custid from payee where Account = " + accNum + " and name = '" + name +"'";
			p = conn.prepareStatement(fetch);
			r = p.executeQuery();
			
			int count = 0 ;
			while ( r.next() )
			{
				count++;
			}
			if ( count != 0 )
			{
				return 0;
			}
			//System.out.println("We are here");
			p = conn.prepareStatement("insert into payee(Account,name,custid) values (?,?,?)");
			p.setInt(1, accNum);
			p.setString(2, name);
			p.setInt(3, custID);
			p.execute();
		}
		catch(Exception e)
		{
			return -1;
		}
		return 1;
	}
	
	public int fetchUsersBillers(ArrayList<String> billerName, ArrayList<String> referenceNumber)
	{
		try
		{
			String data = "select name,reference_number from users_biller where cust_id = " + custID;
			
			p = conn.prepareStatement(data);
			r = p.executeQuery();
			
			while ( r.next() )
			{
				billerName.add(r.getString(1));
				referenceNumber.add(r.getString(2));
			}
		}
		catch(Exception e)
		{
			return -1;
		}
		return 1;
	}
	
	public int fetchUsersPayee(ArrayList<String> PayeeName, ArrayList<String> accountID)
	{
		try
		{
			String data = "select name,Account from Payee where custid = " + custID;
			
			p = conn.prepareStatement(data);
			r = p.executeQuery();
			
			while ( r.next() )
			{
				PayeeName.add(r.getString(1));
				accountID.add(r.getString(2));
			}
		}
		catch(Exception e)
		{
			return -1;
		}
		return 1;
	}
	
	public int addTransaction(String senderAccNum, String receiverAccNum, String amount )
	{
		try
		{
			String fetch = "UPDATE account set balance = round( balance - " + amount + ",4) where number = " + senderAccNum;
			p = conn.prepareStatement(fetch);
			
			String fetch1 = "UPDATE account set balance = round( balance + " + amount + ",4) where number = " + receiverAccNum;
			PreparedStatement p1 = conn.prepareStatement(fetch1);
			
			p.execute();
			p1.execute();
			
			//System.out.println("Done till here\n");
			p = conn.prepareStatement("insert into transaction(credit,debit,amount) values (?,?,?)");
			p.setInt(1, Integer.parseInt(senderAccNum));
			p.setInt(2, Integer.parseInt(receiverAccNum));
			p.setDouble(3, Double.parseDouble(amount));
			
			p.execute();
			
			return 1;
		}
		catch(Exception e)
		{
			return -1;
			//System.exit(-1);
		}
	}
	
	public int addBillPayment(String arguments)
	{
		String[] args = arguments.split("\n");
		try
		{
			
			//Subtract the amount from user account
			String fetch = "UPDATE account set balance = round(" + ( Double.parseDouble(args[4]) - Double.parseDouble(args[3]) ) + ",4) where number = " + args[2];
			p =conn.prepareStatement(fetch);
			p.execute();
			//Add the record to billpayment
			String getId = "select id from users_biller where cust_id = " + custID + " and name = '" + args[0] + "' and reference_number = " + args[1];
			
			p = conn.prepareStatement(getId);
			
			r = p.executeQuery();
			
			int bill_id = -1;
			while ( r.next() )
			{
				bill_id = r.getInt(1);
			}
			System.out.println("Bill id : " + bill_id);
			
			p = conn.prepareStatement("insert into billpayment(bill_id,amount,acc) values (?,?,?)");
			p.setInt(1, bill_id);
			p.setDouble(2, Double.parseDouble(args[3]));
			p.setInt(3, Integer.parseInt(args[2]));
			p.execute();
		}
		catch(Exception e)
		{
			return -1;
		}
		return 1;
	}
	
	public double TodayTransaction(int accNum)
	{
		try
		{
			String fetch = "select sum(amount) from transaction where credit = " + accNum + " and DATEPAYMENT >= CURDATE() AND DATEPAYMENT < CURDATE() + INTERVAL 1 DAY";
			p = conn.prepareStatement(fetch);
			
			ResultSet temp = p.executeQuery();
			
			double transamount = 0;
			while ( temp.next() )
			{
				transamount += temp.getDouble(1);
			}
			return transamount;
		}
		catch (Exception e)
		{
			System.out.println("Database Failed!");
			System.exit(-1);
		}
		
		return 0.0;
	}
	
	public void FetchUserAccountandLimits(ArrayList<Integer> accNum, ArrayList<Double> Limit)
	{
		
		try
		{
			String fetch = "select number,lim,status from account where custid = " + Integer.toString(custID);
			p = conn.prepareStatement(fetch);
			
			r = p.executeQuery();
			
			while ( r.next() )
			{
				String status = r.getString(3);
				if ( status.equals("frozen") || status.equals("deleted"))
				{
					continue;
				}
				int acc = r.getInt(1);
				accNum.add(acc);
				
				Limit.add(r.getDouble(2) - TodayTransaction(acc));
			}
		}
		catch (Exception e)
		{
			System.out.println("Database Failed!");
			System.exit(-1);
		}
	}
	
	public void FetchUserAccount(ArrayList<String> accTitle, ArrayList<Integer> accNum, ArrayList<Double> accBalance)
	{
		accTitle.clear();
		accNum.clear();
		accBalance.clear();
		try
		{
			String fetch = "select number,balance,status,owner from account where custid = " + Integer.toString(custID);
			p = conn.prepareStatement(fetch);
			
			r = p.executeQuery();
			
			while ( r.next() )
			{
				String status = r.getString(3);
				if ( status.equals("frozen") || status.equals("deleted"))
				{
					continue;
				}
				accTitle.add(r.getString(4));
				accNum.add(r.getInt(1));
				accBalance.add(r.getDouble(2));
			}
		}
		catch (Exception e)
		{
			System.out.println("Database Failed!");
			System.exit(-1);
		}
	}

	public void writeCsv(String filePath, int accNum, double closing_amount) 
	 {
		   	double amount = 0;
			FileWriter fileWriter = null;
			try {
			   fileWriter = new FileWriter(filePath);
			   
			   fileWriter.append("Account Number : " + "\t" + accNum + "\n");
			   //Start date
			   try
			   {
				   String fetch = "SELECT CURDATE() - INTERVAL 1 WEEK";
				   p =conn.prepareStatement(fetch);
				   
				   r = p.executeQuery();
				   
				   while ( r.next())
				   {
					   fileWriter.append("Start Date : " + "\t" + r.getString(1)+ "\n");
				   }
			   }
			   catch(Exception e)
			   {
				   System.out.println("Here1");
				   System.exit(-1);
			   }
			   //End date
			   try
			   {
				   String fetch = "SELECT CURDATE()";
				   p =conn.prepareStatement(fetch);
				   
				   r = p.executeQuery();
				   
				   while ( r.next())
				   {
					   fileWriter.append("End Date : " + "\t" + r.getString(1) + "\n\n");
				   }
			   }
			   catch(Exception e)
			   {
				   System.out.println("Here2");
				   System.exit(-1);
			   }
			   
			   //Adding the transaction column
			   fileWriter.append("Transaction #\tType\tAmount\tTo/From\tDateTime\n");
			   //Adding the transaction data using query from mysql
			   try
			   {
				   String fetch = "SELECT * FROM TRANSACTION WHERE CREDIT = " + accNum + " or DEBIT = " + accNum;
				   p =conn.prepareStatement(fetch);
				   
				   r = p.executeQuery();
				   int count = 1;
				   int credit;
				   int debit;
				   while ( r.next())
				   {
					   //Iterator
					   fileWriter.append(Integer.toString(count));
					   fileWriter.append("\t");
					   
					   credit = r.getInt(1);
					   debit = r.getInt(2);
					   double current_amount = r.getDouble(4);
					   //Type
					   if ( credit == accNum )
					   {
						   fileWriter.append("Credit");
						   fileWriter.append("\t");
						   amount += current_amount;
					   }
					   else
					   {
						   fileWriter.append("Debit");
						   fileWriter.append("\t");
						   amount -= current_amount;
					   }
					   //Amount
					   fileWriter.append(Double.toString(current_amount));
					   fileWriter.append("\t");
					   //to/From
					   if ( credit == accNum )
					   {
						   fileWriter.append(Integer.toString(debit));
						   fileWriter.append("\t");
					   }
					   else
					   {
						   fileWriter.append(Integer.toString(credit));
						   fileWriter.append("\t");
					   }
					   //DateTime
					   fileWriter.append(r.getString(3));
					   fileWriter.append("\n");
					   count++;
				   }
			   }
			   catch(Exception e)
			   {
				   System.out.println("Here3");
				   System.exit(-1);
			   }
			   fileWriter.append("\n\n");
			   
			   //Adding the bill column
			   fileWriter.append("BillPayment #\tBiller\tReference No.\tAmount\tDateTime\n");
			   //Adding the bill payment data using query from mysql
			   try
			   {
				   String fetch = "SELECT * FROM billpayment WHERE acc = " + accNum;
				   p =conn.prepareStatement(fetch);
				   
				   r = p.executeQuery();
				   int count = 1;
				   while ( r.next())
				   {
					   //Iterator
					   fileWriter.append(Integer.toString(count));
					   fileWriter.append("\t");
					   
					   //Name and reference
					   PreparedStatement p_temp;
					   ResultSet r_temp;
					   String fetch_billers = "select name,reference_number from USERS_BILLER where id = " + r.getInt(1);
					   p_temp = conn.prepareStatement(fetch_billers);
					   
					   r_temp = p_temp.executeQuery();
					   
					   while ( r_temp.next() )
					   {
						 //Name
						 fileWriter.append(r_temp.getString(1));
						 fileWriter.append("\t");
						 //Reference
						 fileWriter.append(r_temp.getString(2));
						 fileWriter.append("\t");
					   }
					   
					   
					   //Amount
					   double current_amount = r.getDouble(3);
					   fileWriter.append(Double.toString(current_amount));
					   amount += current_amount; 
					   fileWriter.append("\t");
					   //DateTime
					   fileWriter.append(r.getString(2));
					   fileWriter.append("\n");
					   count++;
				   }
			   }
			   catch(Exception e)
			   {
				   System.out.println("Here4");
				   System.exit(-1);
			   }
			   fileWriter.append("\n\n");
			   
			   //Opening and Closing Balance
			   fileWriter.append("Opening Balance\t" + Double.toString(closing_amount + amount)+"\n");
			   fileWriter.append("Closing Balance\t" + Double.toString(closing_amount)+"\n");
			   
			  } catch (Exception ex) {
			System.out.println("Here5");
			   ex.printStackTrace();
			   System.exit(-1);
			  } finally {
			   try {
			    fileWriter.flush();
			    fileWriter.close();
			   } catch (Exception e) {
			    e.printStackTrace();
			    System.exit(-1);
			   }
			  }
		 }
}
