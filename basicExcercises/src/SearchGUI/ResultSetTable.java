package SearchGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

public class ResultSetTable extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Connection connection;
	private final Statement stmt;
	private ResultSetMetaData metaData;
	private ResultSet rs;
	private int numberOfRows;
	
	private boolean connectedToDB = false;
	
	public ResultSetTable(String url, String query) throws SQLException {
		
		connection = DriverManager.getConnection(url);
		
		// move resultSet cursor move forward and backward and it Is READ ONLY
		// Result is Immediate.
		stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		connectedToDB = true;
		
		setQuery(query);
	}
	
	public Class<?> getColumnClass(int column) throws IllegalStateException {
		if (!connectedToDB)
			throw new IllegalStateException("Not Connected to Database");
		
		try {
			String className = metaData.getColumnClassName(column +1);
			
			return Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Object.class;
	}
	
	public int getColumnCount() throws IllegalStateException {
		// ensure db connection is available
		if (!connectedToDB)
			throw new IllegalStateException("Not Connected to Database");
		
		try {
			return metaData.getColumnCount();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return 0;
	}
	
	public String getColumnName(int column) throws IllegalStateException {
		// ensure connected
		if (!connectedToDB)
			throw new IllegalStateException("Not Connected to Database");
		
		try {
			return metaData.getColumnName(column + 1);
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		}
		
		return "";
	}
	
	public int getRowCount() throws IllegalStateException {
		if (!connectedToDB)
			throw new IllegalStateException("Not Connected to Database");
		
		return numberOfRows;
	}
	
	// obtain value in particular row and column
	public Object getValueAt(int row, int column) throws IllegalStateException {
		if (!connectedToDB)
			throw new IllegalStateException("Not Connected to Database");
		
		try {
			rs.absolute(row + 1);
			return rs.getObject(column + 1);
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		}
		
		return "";
	}
	
	// set new database query string
	public void setQuery(String query) throws SQLException, IllegalStateException {
		if (!connectedToDB)
			throw new IllegalStateException("Not Connected to Database");
		
		// specify query and execute it
		rs = stmt.executeQuery(query);
		
		// obtain meta data for ResultSet
		metaData = rs.getMetaData();
		
		rs.last();
		numberOfRows = rs.getRow();
		
		// notify Jtable that model has changed
		fireTableStructureChanged();
	}
	
	public void disconnectFromDatabase() {
		if (connectedToDB) {
			try {
				rs.close();
				stmt.close();
				connection.close();
			} catch (SQLException sqlE) {
				sqlE.printStackTrace();
			} finally {
				connectedToDB = false;
			}
		}
	}
	
}
