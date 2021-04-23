import java.io.File;
import java.util.ArrayList;

public class BusinessLayer {
	
	//MANAGER LOGIN
	Manager_Login bmLogin;
	
	//MANAGEMENT PORTAL
	//CUSTOMER
	Manage_Customer mCustomer;
	//ACCOUNT
	Manages mAccount;

	
	//CONNECTION TO THE DATABASE LAYER
	EstablishConnection connection;
	
	BusinessLayer(){
		connection = new EstablishConnection();
	}
	public int managerLogin(String inputUsername, char[] inputPassword) {
		bmLogin = new Manager_Login(connection.getConnection());
		
		int response = bmLogin.Manager_Login_Info(
				inputUsername, 
				new String(inputPassword));
		
		if(response == -1)
		{
			System.out.println("Database Layered Failed!");
			System.out.println("System will exit now...");
			
			System.exit(-1);
		}
		
		return response;
	}
	//MANAGE CUSTOMERS
	public ArrayList<String> mCSearch(String criteria, String query){
		mCustomer = new Manage_Customer(connection.getConnection());
		if(criteria.equals("CNIC"))
		{
			return mCustomer.CustomerinfoCNIC(query);
		}
		else if(criteria.equals("ID"))
		{
			return mCustomer.CustomerinfoID(query);
		}
		
		return null;
	}

	public int mCModify(String custID, String address, String contact, String password) {
		mCustomer = new Manage_Customer(connection.getConnection());
		int response = 1;
		response &= mCustomer.changeAddress(address, Integer.parseInt(custID));
		response &= mCustomer.changeContact(contact, Integer.parseInt(custID));
		if(password.length() != 0)
		{
			response &= mCustomer.changePassword(password, Integer.parseInt(custID));
		}
		
		return response;
	}

	public int mCAdd(
	    		String name, String address, String contact,
	    		String CNIC, String username, String Password) {
		mCustomer = new Manage_Customer(connection.getConnection());
		
		return mCustomer.addCustomer(name, address, contact, CNIC, username, Password);
	}

	//MANAGE ACCOUNTS
	public ArrayList<String> mASearch(String query) {
		mAccount = new Manages(connection.getConnection());
		int response = mAccount.VerifyAccount(Integer.parseInt(query));
		
		if(response == 0)
		{
			return null;
		}
		else if(response == -1)
		{
			System.out.println("Database Failed!");
			System.exit(-1);
		}
		else
		{
			return mAccount.AccountDetailsfromAccountNumber(Integer.parseInt(query));
		}
		
		return null;
	}

	public String mAAdd_CheckCustomer(String custID) {
		mAccount = new Manages(connection.getConnection());
		
		
		String custName = mAccount.getCustomerName(Integer.parseInt(custID));
		
		if(custName.equals("-1"))
		{
			System.out.println("Database Failed!");
			System.exit(-1);
		}
		else
		{
			return custName;
		}
		
		return null;
	}
	
	//Actual insertion of Account
	public int mAAdd(String custID, String title, String type , String lim , String balance ) {
		mAccount = new Manages(connection.getConnection());
		
		int response = mAccount.InsertInDataBase_newAccount(Integer.parseInt(custID), title, type, Integer.parseInt(lim), Double.parseDouble(balance));
		
		if(response == -1)
		{
			System.out.println("Database Failed!");
			System.exit(-1);
		}

		
		return response;
	}
	
	//Deletion of Account
	public int mADelete(String accNum) {
		mAccount = new Manages(connection.getConnection());
		
		int response = mAccount.VerifyAccount(Integer.parseInt(accNum));

		if(response == -1)
		{
			System.out.println("Database Failed!");
			System.exit(-1);;
		}
		else if(response == 0)
		{
			return 0;
		}
		
		response = mAccount.deleteAccountfromDatabase(accNum);
		
		if(response == -1)
		{
			System.out.println("Database Failed!");
			System.exit(-1);;
		}
		
		return response;
	}
	
	//Modification of Account
	public int mAModify(String accNum, String title, String status, String type, String lim) {

		mAccount = new Manages(connection.getConnection());
		
		int response = mAccount.VerifyAccount(Integer.parseInt(accNum));

		if(response == -1)
		{
			System.out.println("Database Failed!");
			System.exit(-1);;
		}
		else if(response == 0)
		{
			return 0;
		}
		
		
		response = mAccount.modifyAccountfromDatabase(accNum, title, status, type, lim);
		
		if(response == -1)
		{
			System.out.println("Database Failed!");
			System.exit(-1);;
		}
		
		return response;
	}
}
