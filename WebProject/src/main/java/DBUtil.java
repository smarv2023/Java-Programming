import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String connectionString = 
			"jdbc:sqlserver://localhost:1433;databaseName=Books;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
	
	public static Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			throw new SQLException("Error connecting to the DB: " + e.getMessage());
		}
	}
}
