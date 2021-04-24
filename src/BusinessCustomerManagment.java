import java.util.ArrayList;

public class BusinessCustomerManagment {
	//CUSTOMER
	Manage_Customer mCustomer;
	
	//CONNECTION TO THE DATABASE LAYER
	EstablishConnection connection;
	
	BusinessCustomerManagment()
	{
		connection = new EstablishConnection();
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
}
