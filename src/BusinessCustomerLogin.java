
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class BusinessCustomerLogin {
	Customer_Login custLogin;
	int custID;
	//CONNECTION TO THE DATABASE LAYER
	EstablishConnection connection;
	BusinessCustomerLogin(){
		connection = new EstablishConnection();
	}
	
	public int customerLogin(String inputUsername, char[] inputPassword) {
		custLogin = new Customer_Login(connection.getConnection());
		
		int response = custLogin.Customer_Login_Info(
				inputUsername, 
				new String(inputPassword));
		
		if(response == -1)
		{
			System.out.println("Database Layered Failed!");
			System.out.println("System will exit now...");
			
			System.exit(-1);
		}
		
		custID = response;
		
		return response;
	}
}
