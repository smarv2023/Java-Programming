package JavaConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaConnection {

	public static void main(String[] args) {
		String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=LoanAccounts;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
		
		try {
			try (Connection connection = DriverManager.getConnection(connectionString)) {
				System.out.println("Connection established.");
			}
			
		} catch (SQLException e) {
			System.out.println("Error connection to the database.");
			e.printStackTrace();
		}

	}

}
