package WageCalculator;
import java.awt.BorderLayout;
/*
 * On the form, the employee type will be select from a drop down list (Hourly or Wage)
 * 	disable all buttons and fields until an employee type is selected. 
 * The other fields are Employee name, wage/salary and hours worked. 
 * If hourly is chosen, show all three text boxes,
 * 	if salary is chosen, enable only the salary amount box (yearly salary).5pts
 * 
 * Clicking submit will validate the form, set up a default value called "select" for the drop down list,
 * if this value is chosen (meaning they didnt make a proper selection) then don't allow them to proceed (invalid). Validate all fields for emptyness and the wage and hours boxes as numbers.
 * If valid submit the Employee to the correct object type and display their toString in the textarea txtOutput.
 * 
 * There is also a Show Report button at the bottom underneath the txtOutput,
 * when clicked will output all the toStrings of the arraylist to txtOutput 5pts
 * **/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GUI{
	
	// Creating Frame
    private JFrame jFrame = new JFrame("Wage Calculator");
    private JFrame jFrameResult = new JFrame("Employee Wages");
    // Creating Panel
    private JPanel panel = new JPanel();
    
    // Creating Label
    private JLabel lblEmployee = new JLabel("Employee Type:");
    private JLabel lblName = new JLabel("Name:");
    private JLabel lblWage = new JLabel("Hourly Wage:");
    private JLabel lblHours = new JLabel("Hours Worked:");
    private JLabel lblSalary = new JLabel("Yearly Salary:");
    
    // Creating ComboBox
    private final String[] EMPLOYEE_TYPES = {"Select", "Hourly", "Salary"};
    private JComboBox<String> comboEmployeeType = new JComboBox<>(EMPLOYEE_TYPES);
    
    // Creating TextField
    private JTextField txtName = new JTextField();
    private JTextField txtWage = new JTextField();
    private JTextField txtHours = new JTextField();
    private JTextField txtSalary = new JTextField();
    
    // Text Area
    private JTextArea txtOutput = new JTextArea("This output will reset everytime you select another \nemployee type\n\n" +
    											"To view all of your entries, click Show Report.");
    private JScrollPane scrollPane = new JScrollPane(txtOutput);
    
    private JTextArea employeeResult = new JTextArea();
    private JScrollPane scrollPaneResult = new JScrollPane(employeeResult);
    
    // Creating Button
    private JButton btnSubmit = new JButton("Submit");
    private JButton btnShow = new JButton("Show Report");
    
    private JTextField [] textBoxes = {txtName, txtWage, txtHours, txtSalary};
	
    // Instance variable for Employees
    private Employees employees = new Employees();
	
	public GUI() {
		prepareGUI();
		checkEmployeeType();
		submitInfo();
		showReport();
	}

    public void prepareGUI() {
    	// Setting layout manager to null for absolute positioning
        panel.setLayout(null);
        
        // Positioning of components
        lblEmployee.setBounds(20, 20, 100, 25);
        comboEmployeeType.setBounds(130, 20, 150, 25);
        lblName.setBounds(20, 60, 100, 25);
        txtName.setBounds(130, 60, 150, 25);
        
        lblWage.setBounds(20, 100, 100, 25);
        txtWage.setBounds(130, 100, 100, 25);
        lblHours.setBounds(20, 140, 100, 25);
        txtHours.setBounds(130, 140, 100, 25);
        
        lblSalary.setBounds(20, 100, 100, 25);
        txtSalary.setBounds(130, 100, 100, 25);

        // Buttons
        btnSubmit.setBounds(20,325, 170, 25);
        btnSubmit.setEnabled(false);
        btnShow.setBounds(190, 325, 170, 25);
        btnShow.setEnabled(false);
        
        // Adding components to the panel
        panel.add(lblEmployee);
        panel.add(comboEmployeeType);
        panel.add(lblName);
        panel.add(txtName);
        
        // Invisible and disable make it available when hourly is clicked
        panel.add(lblWage);
        panel.add(txtWage);
        panel.add(lblHours);
        panel.add(txtHours);
        
        // Invisible and disable make it available when salary is clicked
        panel.add(lblSalary);
        panel.add(txtSalary);
        
        lblWage.setVisible(false);
        txtWage.setVisible(false);
        lblHours.setVisible(false);
        txtHours.setVisible(false);
        lblSalary.setVisible(false);
        txtSalary.setVisible(false);
        //panel.add(txtOutput);
        txtOutput.setEditable(false);
        scrollPane.setBounds(10, 170, 365, 150);
        panel.add(scrollPane);
        
        panel.add(btnSubmit);
        panel.add(btnShow);
        
        
        // Creating Frame
        jFrame.setSize(400, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        
        // Adding panel to the frame
        jFrame.add(panel);
        
        // Displaying the frame
        jFrame.setVisible(true);
        
        // Show Report Frame
        jFrameResult.setSize(400, 700);  
        jFrameResult.setLocationRelativeTo(null);


        jFrameResult.add(scrollPaneResult);
        jFrameResult.add(scrollPaneResult, BorderLayout.CENTER);
        
        employeeResult.setEditable(false);
    }
    
	// Check if an employee type is selected
    public void checkEmployeeType() {
    	comboEmployeeType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String employeeType = (String) comboEmployeeType.getSelectedItem();
                if (employeeType.equals("Hourly")) {
                    lblWage.setVisible(true);
                    txtWage.setVisible(true);
                    lblHours.setVisible(true);
                    txtHours.setVisible(true);
                    lblSalary.setVisible(false);
                    txtSalary.setVisible(false);
                    btnShow.setEnabled(true);
                    btnSubmit.setEnabled(true);
                    txtOutput.setText("");
                    for (JTextField textBox  : textBoxes) {
                    	textBox.setText(null);
                    }
                } else if (employeeType.equals("Salary")) {
                    lblWage.setVisible(false);
                    txtWage.setVisible(false);
                    lblHours.setVisible(false);
                    txtHours.setVisible(false);
                    lblSalary.setVisible(true);
                    txtSalary.setVisible(true);
                    btnShow.setEnabled(true);
                    btnSubmit.setEnabled(true);
                    txtOutput.setText("");
                    for (JTextField textBox  : textBoxes) {
                    	textBox.setText("");
                    }
                } else {
                    // If "Select" is chosen, hide all fields
                    lblWage.setVisible(false);
                    txtWage.setVisible(false);
                    lblHours.setVisible(false);
                    txtHours.setVisible(false);
                    lblSalary.setVisible(false);
                    txtSalary.setVisible(false);
                    btnShow.setEnabled(false);
                    btnSubmit.setEnabled(false);
                    txtOutput.setText("");
                    for (JTextField textBox  : textBoxes) {
                    	textBox.setText("");
                    }
                }
            }
        });
    }
    
    public void submitInfo () {
    	btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	String regex = "^[a-zA-Z]+$";
	        	String regexNumber = "^\\d+(\\.\\d+)?$";
                String employeeType = (String) comboEmployeeType.getSelectedItem();
                String name = txtName.getText();
                if (employeeType.equals("Hourly")) {
                	if (!(name.matches(regex)) || !(txtWage.getText().matches(regexNumber)) || !(txtHours.getText().matches(regexNumber))) {
                		JOptionPane.showMessageDialog(null, "Please make sure to enter correct information",
                				"Missing or Incorrect Information", JOptionPane.ERROR_MESSAGE);
                	} else {
                    	double wage = Double.parseDouble(txtWage.getText());
                    	double hours = Double.parseDouble(txtHours.getText());
	                	HourlyEmployee employee = new HourlyEmployee(name, wage, hours);
	                	employee.generatePayroll();
	                	employees.addEmployee(employee.toString());
	                	txtOutput.append(employee.toString());
	                    for (JTextField textBox  : textBoxes) 
	                    	textBox.setText("");
                	}
                } else if (employeeType.equals("Salary")) {
                	if (!(name.matches(regex)) || !(txtSalary.getText().matches(regexNumber))) {
                		JOptionPane.showMessageDialog(null, "Please make sure to enter correct information",
                				"Missing or Incorrect Information", JOptionPane.ERROR_MESSAGE);
                	} else {
	                	double salary = Double.parseDouble(txtSalary.getText());
	                	SalaryEmployee employee = new SalaryEmployee(name, salary);
	                	employee.generatePayroll();
	                	txtOutput.append(employee.toString());
	                	employees.addEmployee(employee.toString());
	                	for (JTextField TextBox : textBoxes) 
	                		TextBox.setText("");
                	}
                }
    		}
    	});
    }
    
    public void showReport() {
    	 btnShow.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 jFrameResult.setVisible(true);
                 ArrayList<String> getEmployees = employees.getEmployees();
                 employeeResult.setText("");
                 
                 employeeResult.append("Employee List and Wages: \n\n");
                 for (String employee : getEmployees)
                     employeeResult.append(employee);
             }
         });
    }
}
