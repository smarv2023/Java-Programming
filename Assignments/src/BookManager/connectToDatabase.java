package BookManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class connectToDatabase {
	
	String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=Books;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	String SQL;
	ResultSet rs;

	public void getAllBooks(){
		// Auto Close
		try (Connection con = DriverManager.getConnection(connectionString); Statement stmt = con.createStatement();) {
			SQL = "SELECT * FROM books";
			rs = stmt.executeQuery(SQL);
			ResultSetMetaData metaData = rs.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			// Print Design
			for (int i = 1; i <= numberOfColumns; i++)
				if(i == 2)
					System.out.printf("%-35s", metaData.getColumnName(i));
				else
					System.out.printf("%-8s\t", metaData.getColumnName(i));
			System.out.println();
			
			while (rs.next()) {
				for (int i = 1; i <= numberOfColumns; i++)
					if (i == 2)
						System.out.printf("%-35s\t", rs.getString(i));
					else
						System.out.printf("%-8s\t", rs.getString(i));
				System.out.println();
			}
			stmt.close();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e) {}
		}
	}
	
	public void getBooksByAuthor(String name){	
		System.out.println(name);
		try (Connection con = DriverManager.getConnection(connectionString);) {
			SQL = "SELECT * FROM books WHERE author = ?";
			PreparedStatement stmt = con.prepareStatement(SQL);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			// Print Design
			for (int i = 1; i <= numberOfColumns; i++)
				if(i == 2)
					System.out.printf("%-35s", metaData.getColumnName(i));
				else
					System.out.printf("%-8s\t", metaData.getColumnName(i));
			System.out.println();
			
			while (rs.next()) {
				for (int i = 1; i <= numberOfColumns; i++)
					if (i == 2)
						System.out.printf("%-35s\t", rs.getString(i));
					else
						System.out.printf("%-8s\t", rs.getString(i));
				System.out.println();
			}
			stmt.close();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e) {}
		}
	}
	
	public void getBooksPublisherAfterYear(int year) {
		System.out.println(year);
		try (Connection con = DriverManager.getConnection(connectionString);) {
			SQL = "SELECT * FROM books WHERE publication_year > ?";
			PreparedStatement stmt = con.prepareStatement(SQL);
			stmt.setInt(1, year);
			rs = stmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			// Print Design
			for (int i = 1; i <= numberOfColumns; i++)
				if(i == 2)
					System.out.printf("%-35s", metaData.getColumnName(i));
				else
					System.out.printf("%-8s\t", metaData.getColumnName(i));
			System.out.println();
			
			while (rs.next()) {
				for (int i = 1; i <= numberOfColumns; i++)
					if (i == 2)
						System.out.printf("%-35s\t", rs.getString(i));
					else
						System.out.printf("%-8s\t", rs.getString(i));
				System.out.println();
			}
			stmt.close();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e) {}
		}
	}
}

