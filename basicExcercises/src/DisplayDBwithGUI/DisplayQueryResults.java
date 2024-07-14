package DisplayDBwithGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import SearchGUI.ResultSetTable;

public class DisplayQueryResults {
	
	private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName =books;"
			+ "integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	
	private static final String DEFAULT_QUERY = "SELECT * FROM authors";
	
	private static ResultSetTable tableModel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			tableModel = new ResultSetTable(DATABASE_URL, DEFAULT_QUERY);
			
			final JTextArea queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
			queryArea.setWrapStyleWord(true);
			queryArea.setLineWrap(true);
			
			JScrollPane scrollPane = new JScrollPane(queryArea, 
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			
			JButton submitButton = new JButton("Submit Query");
			
			// box to place query textArea and SubmitButton
			Box boxNorth = Box.createHorizontalBox();
			boxNorth.add(scrollPane);
			boxNorth.add(submitButton);
			
			// create JTable based on the tableModel
			JTable resultTable = new JTable(tableModel);
			
			JLabel filterLabel = new JLabel("Filter:");
			final JTextField filterText = new JTextField();
			JButton filterButton = new JButton("Apply Filter");
			Box boxSouth = Box.createHorizontalBox();
			
			boxSouth.add(filterLabel);
			boxSouth.add(filterText);
			boxSouth.add(filterButton);
			
			// place GUI components on JFrame's content pane
			JFrame window = new JFrame("Displaying Query Results");
			window.add(boxNorth, BorderLayout.NORTH);
			window.add(new JScrollPane(resultTable), BorderLayout.CENTER);
			window.add(boxSouth, BorderLayout.SOUTH);
			
			submitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					try {
						tableModel.setQuery(queryArea.getText());
					} catch (SQLException sqlE) {
						JOptionPane.showMessageDialog(null, sqlE.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// try to recover from invalid user query
						// by executing default query
						try {
							tableModel.setQuery(DEFAULT_QUERY);
							queryArea.setText(DEFAULT_QUERY);
						} catch (SQLException sqlEx) {
							JOptionPane.showMessageDialog(null, sqlEx.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
							
							tableModel.disconnectFromDatabase();
							
							System.exit(1); // Terminate application
						}
					}
				}
			});
			
			final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
			resultTable.setRowSorter(sorter);
			
			// filter
			filterButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String text = filterText.getText();
					
					if (text.length() == 0)
						sorter.setRowFilter(null);
					else {
						try {
							sorter.setRowFilter(RowFilter.regexFilter(text));
						} catch (PatternSyntaxException pse){
							JOptionPane.showMessageDialog(null, "Bad regex pattern", "Bad regex pattern", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
			
			window.setSize(500, 250);
			window.setVisible(true);
			
			// ensure DB is closed when quits application
			window.addWindowListener(new WindowAdapter(){
				public void windowClosed(WindowEvent event) {
					tableModel.disconnectFromDatabase();
					System.exit(0);
				}
			});
		} catch (SQLException sqlE) {
			JOptionPane.showMessageDialog(null, sqlE.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
			tableModel.disconnectFromDatabase();
			System.exit(1);
		}
	}

}
