
public class BusinessManagerLogin 
{
	//MANAGER LOGIN
	Manager_Login bmLogin;
	
	//CONNECTION TO THE DATABASE LAYER
	EstablishConnection connection;
		
	BusinessManagerLogin(){
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
}
