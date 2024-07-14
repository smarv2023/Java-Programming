package DisplayDBwithGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayAuthors {

	public static void main(String[] args) {
		final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName =books;"
				+ "integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
		final String SELECT_QUERY =  "SELECT authorID, firstName, lastName FROM authors";
		
		try (Connection connection = DriverManager.getConnection(DATABASE_URL);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_QUERY)) {
			// getResultSet
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			
			System.out.printf("Authors Table of Book Database:%n%n");
			
			// display the names of the columns in the ResultSet (index i)
			// useful for printing Header
			for (int i = 1; i <= numberOfColumns; i++)
				System.out.printf("%-8s\t", metaData.getColumnName(i));
			System.out.println();
			
			while (resultSet.next()) {
				for (int i = 1; i <= numberOfColumns; i++)
					System.out.printf("%-8s\t", resultSet.getObject(i));
				System.out.println();
			}	
		}  catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
