
public class BusinessAccountant {
	//ACCOUNTANT LOGIN
	Accountant_Login aLogin;
	Accountant aMain;
	
	//CONNECTION TO THE DATABASE LAYER
	EstablishConnection connection;
		
	BusinessAccountant(){
			connection = new EstablishConnection();
	}
	public int accountantLogin(String inputUsername, char[] inputPassword) {
		aLogin = new Accountant_Login(connection.getConnection());
		
		int response = aLogin.Accountant_Login_Info(
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

	public int accountantCredit(String accNum, String amount) {
		try {
			aMain = new Accountant(connection.getConnection());
			
			int response = aMain.withDrawMoney(Integer.parseInt(accNum), Double.parseDouble(amount));
			
			if(response == -1)
			{
				System.out.println("Database Failed!");
				System.exit(-1);
			}
			else if(response == 0)
			{
				return response;
			}
			
			return 1;
		}
		catch (Exception e) {
			return 0;
		}
		
	}

	public int accountantDebit(String accNum, String amount) {
		try {
			aMain = new Accountant(connection.getConnection());
			
			int response = aMain.depositMoney(Integer.parseInt(accNum), Double.parseDouble(amount));
			
			if(response == -1)
			{
				System.out.println("Database Failed!");
				System.exit(-1);
			}
			
			return 1;
		}
		catch (Exception e) {
			return 0;
		}
	}
}
