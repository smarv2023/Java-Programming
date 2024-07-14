package MortgageCalculator;
/*
 * Connection to DB
 * **/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextArea;

public class ConnectionCRUD {
	String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=LoanAccounts;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	
	//INSERT query
	public void insertData(ArrayList<LoanAccount> loanAccount) {
		try (Connection connection = DriverManager.getConnection(connectionString)) {
				//System.out.println("Connection established.");
			    String SQL = "INSERT INTO Loans(LoanAmount, InterestRate, Term, HomeValue, MonthlyPayment, TotalInterest, Date) " +
		                 "VALUES (?, ?, ?, ?, ?, ?, ?)";
			    for (LoanAccount account : loanAccount) {
				    PreparedStatement statement = connection.prepareStatement(SQL);
			        statement.setDouble(1, account.loanAmount);
			        statement.setDouble(2, account.interestRate);
			        statement.setInt(3, account.term);
			        statement.setDouble(4, account.homeValue);
			        statement.setDouble(5, account.monthlyPayment);
			        statement.setDouble(6, account.totalInterest);
			        statement.setDate(7, new java.sql.Date(System.currentTimeMillis()));
				    
			        statement.executeUpdate();
			    }
			    connection.close();
			    	
			} catch (SQLException e) {
				System.out.println("Error connection to the database.");
				e.printStackTrace();
		}
	}
	
	// SELECT query
	public void viewData(int quantity, JTextArea listResult) {
		try (Connection connection = DriverManager.getConnection(connectionString); Statement statement = connection.createStatement();) {
            String SQL = "SELECT TOP " + quantity + " * FROM Loans";
            ResultSet rs = statement.executeQuery(SQL);
            // Iterate through the data in the result set and display it.
            
            while (rs.next()) {
                //System.out.printf("%s  $%s \t%s\t $%s%n",rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4));
            	listResult.append(String.format("%s : : $%s \t%10s\t%5s%n",
            			rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            connection.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}

