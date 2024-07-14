import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String connectionString = 
			"jdbc:sqlserver://localhost:1433;databaseName=Users;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	
	public static Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(connectionString);
		} catch (SQLException sqlE) {
			throw new SQLException("Error connecting to the DB: " + sqlE.getMessage());
		} 
	}
}
