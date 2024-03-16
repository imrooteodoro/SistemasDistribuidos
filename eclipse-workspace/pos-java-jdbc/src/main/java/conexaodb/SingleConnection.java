package conexaodb;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	private static String urldb = "jdbc:postgresql://localhost:5433/dbteste";
	private static String password = "kali";
	private static String user = "teodoro";
	private static Connection connection = null;
	
	static {
		connect();
	}
	
	public SingleConnection() {
		connect();
	}
	
	private static void connect() {
		
		try {
			
			if(connection==null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(urldb, user, password);
				connection.setAutoCommit(false);
				System.out.println("Ok!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		return connection;
	}
	

}
