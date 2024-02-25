package SelectAndInsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonQueries {
	private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName =books;"
			+ "integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	
	private Connection connection;
	private PreparedStatement selectAllPeople;
	private PreparedStatement selectPeopleByLastName;
	private PreparedStatement insertNewPerson;
	
	// constructor
	public PersonQueries() {
		try {
			connection = DriverManager.getConnection(DATABASE_URL);
			
			selectAllPeople = connection.prepareStatement("SELECT * FROM Addresses");
			
			selectPeopleByLastName = connection.prepareStatement("SELECT * FROM Addresses WHERE LastName = ?");
			
			insertNewPerson = connection.prepareStatement("INSERT INTO Addresses (FirstName, LastName, Email, PhoneNumber) VALUES (?, ?, ?, ?)");
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
			System.exit(1);
		}
	}
	
	public List<Person> getAllPeople() {
		List<Person> results = null;
		ResultSet resultSet = null;
		
		try {
			// executeQuery returns ResultSet containing matching entries
			resultSet = selectAllPeople.executeQuery();
			results = new ArrayList<Person>();
			
			while (resultSet.next()) {
				results.add(new Person(resultSet.getInt("addressID"),
						resultSet.getString("firstName"),
						resultSet.getString("lastName"),
						resultSet.getString("email"),
						resultSet.getString("phoneNumber")));
			}
			
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException sqlE) {
				sqlE.printStackTrace();
				close();
			}
		}
		return results;
	}
	
	public List<Person> getPeopleByLastName(String name) {
		List<Person> results = null;
		ResultSet resultSet = null;
		
		try {
			selectPeopleByLastName.setString(1,  name);
			
			// Execute Query returns result 
			resultSet = selectPeopleByLastName.executeQuery();
			results = new ArrayList<Person>();
			
			while (resultSet.next()) {
				results.add(new Person(resultSet.getInt("addressID"),
						resultSet.getString("firstName"),
						resultSet.getString("lastName"),
						resultSet.getString("email"),
						resultSet.getString("phoneNumber")));
			}
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException sqlE) {
				sqlE.printStackTrace();
				close();
			}
		}
		return results;
	}
	
	public int addPerson(String fname, String lname, String email, String num) {
		int result = 0;
		try {
			insertNewPerson.setString(1, fname);
			insertNewPerson.setString(2, lname);
			insertNewPerson.setString(3, email);
			insertNewPerson.setString(4, num);
			
			result = insertNewPerson.executeUpdate();
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
			close();
		}
		return result;
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
			close();
		}
	}
}
