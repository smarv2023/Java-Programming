package MortgageCalculator;
/*
 * Mortgage Calculator GUI
 * 
 * **/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class MortgageCalculatorGUI extends JFrame {
	
	private ArrayList<LoanAccount> loanAccount = new ArrayList<LoanAccount>();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textLoanAmount;
	private JTextField textInterestRate;
	private JTextField textTerm;
	private JTextField textHomeValue;
	private JTextField textMonthlyPayment;
	private JTextField textTotalInterest;
	
	private JTextArea textArea = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane(textArea);
	private JTextArea listResult = new JTextArea();
	private JScrollPane scrollPaneResult = new JScrollPane(listResult);
	
	private JButton btnCalculate = new JButton("Calculate");
	private JButton btnSubmit = new JButton("Submit to DB");
	private JButton btnCheckdb = new JButton("CheckDB");
	private JButton btnExit = new JButton("Exit");
    private JFrame jFrameResult = new JFrame("Loans List");
    private JTextField txtRows;

	// constructor
	public MortgageCalculatorGUI() {
		prepareGUI();
		calculate();
		submitToDB();
		viewDB();
	}
	
	// Create the frame using swing window builder.
	public void prepareGUI() {
        setLocationRelativeTo(null);
		setTitle("Mortgage Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Mortgage Calculator");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 11, 710, 54);
		lblTitle.setFont(new Font("Verdana", Font.BOLD, 25));
		contentPane.add(lblTitle);
		
		
		JLabel lblLoanAmount = new JLabel("Loan Amount:");
		lblLoanAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoanAmount.setBounds(10, 70, 170, 36);
		contentPane.add(lblLoanAmount);
		
		JLabel lblInterestRate = new JLabel("Interest Rate:");
		lblInterestRate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInterestRate.setBounds(10, 120, 170, 36);
		contentPane.add(lblInterestRate);
		
		JLabel lblTerminMonths = new JLabel("Term(yr):");
		lblTerminMonths.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTerminMonths.setBounds(10, 170, 170, 36);
		contentPane.add(lblTerminMonths);
		
		JLabel lblHomeValue = new JLabel("Home Value:");
		lblHomeValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHomeValue.setBounds(10, 220, 170, 36);
		contentPane.add(lblHomeValue);
		
		JLabel lblMonthlyPayment = new JLabel("Monthly Payment:");
		lblMonthlyPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMonthlyPayment.setBounds(10, 270, 170, 36);
		contentPane.add(lblMonthlyPayment);
		
		JLabel lblTotalInterest = new JLabel("Total Interest:");
		lblTotalInterest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotalInterest.setBounds(10, 320, 170, 36);
		contentPane.add(lblTotalInterest);
		
		textLoanAmount = new JTextField();
		textLoanAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textLoanAmount.setColumns(10);
		textLoanAmount.setBounds(230, 70, 200, 36);
		contentPane.add(textLoanAmount);
		
		textInterestRate = new JTextField();
		textInterestRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textInterestRate.setColumns(10);
		textInterestRate.setBounds(230, 120, 200, 36);
		contentPane.add(textInterestRate);
		
		textTerm = new JTextField();
		textTerm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTerm.setColumns(10);
		textTerm.setBounds(230, 170, 200, 36);
		contentPane.add(textTerm);
		
		textHomeValue = new JTextField();
		textHomeValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textHomeValue.setEditable(false);
		textHomeValue.setColumns(10);
		textHomeValue.setBounds(230, 220, 200, 36);
		contentPane.add(textHomeValue);
		
		textMonthlyPayment = new JTextField();
		textMonthlyPayment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textMonthlyPayment.setEditable(false);
		textMonthlyPayment.setColumns(10);
		textMonthlyPayment.setBounds(230, 270, 200, 36);
		contentPane.add(textMonthlyPayment);
		
		textTotalInterest = new JTextField();
		textTotalInterest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTotalInterest.setEditable(false);
		textTotalInterest.setColumns(10);
		textTotalInterest.setBounds(230, 320, 200, 36);
		contentPane.add(textTotalInterest);
		textArea.setEditable(false);
		
		txtRows = new JTextField();
		txtRows.setText("10");
		txtRows.setToolTipText("Enter rows to view");
		txtRows.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRows.setBounds(300, 437, 130, 35);
		contentPane.add(txtRows);
		txtRows.setColumns(10);
		
        // Show Report Frame
        jFrameResult.setSize(400, 700);  
        jFrameResult.setLocationRelativeTo(null);
        jFrameResult.getContentPane().add(scrollPaneResult);
        jFrameResult.getContentPane().add(scrollPaneResult, BorderLayout.CENTER);
        listResult.setEditable(false);

		// Output
		scrollPane.setBounds(438, 70, 272, 448);
		contentPane.add(scrollPane);
		
		// btnCalculate
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCalculate.setBounds(10, 365, 420, 36);
		contentPane.add(btnCalculate);
		
		// btnSubmit
		btnSubmit.setEnabled(false);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmit.setBounds(10, 400, 420, 36);
		contentPane.add(btnSubmit);
		
		// btnCheckdb
		btnCheckdb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCheckdb.setBounds(10, 435, 282, 36);
		contentPane.add(btnCheckdb);
		
		// btnExit
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setBounds(10, 482, 420, 36);
		contentPane.add(btnExit);
		
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
	}

	public void calculate() {
		btnCalculate.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if (validateFields()) {
					LoanAccount account = new LoanAccount();
					account.loanAmount = Double.parseDouble(textLoanAmount.getText());
					account.interestRate = Double.parseDouble(textInterestRate.getText());
					account.term = Integer.parseInt(textTerm.getText());
					account.calculateLoan();	
					textHomeValue.setText(String.valueOf(account.homeValue));
					textMonthlyPayment.setText(String.valueOf(account.monthlyPayment));
					textTotalInterest.setText(String.valueOf(account.totalInterest));
					btnSubmit.setEnabled(true);
					loanAccount.add(account);
					textArea.setText("");
					for (LoanAccount currentLoan : loanAccount) {
						textArea.append(currentLoan.toString());
					}
				}
			}

		});
	}
	
	private void submitToDB() {
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Insert to the Database
				ConnectionCRUD connect = new ConnectionCRUD();
				connect.insertData(loanAccount);
				
				btnSubmit.setEnabled(false);
				loanAccount.clear();
				textLoanAmount.setText("");
				textInterestRate.setText("");
				textTerm.setText("");
				textHomeValue.setText("");
				textMonthlyPayment.setText("");
				textTotalInterest.setText("");
				textArea.setText("");
			}	
		});
	}
	
	private void viewDB() {
		btnCheckdb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rowsCheck()) {	
					int rowCount =  Integer.parseInt(txtRows.getText());
					jFrameResult.setVisible(true);
					listResult.setText("");
					listResult.append(String.format("%s%15s  %s\t%s%n", "ID", "Loan Amount", "Interest Rate", "Term"));
					ConnectionCRUD connect = new ConnectionCRUD();
					connect.viewData(rowCount, listResult);
				}
			}
		});
	}
	
	// this will be call by calculate method to validate all entry
	private boolean validateFields() {
		try {
			double loanAmount = Double.parseDouble(textLoanAmount.getText());
			double interestRate = Double.parseDouble(textInterestRate.getText());
			double term = Double.parseDouble(textTerm.getText());
			if (loanAmount <= 0 || interestRate <= 0 || term <= 0) {
				JOptionPane.showMessageDialog(null, "Please enter valid values for Loan Amount, Interest Rate, and Term.");
				return false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter valid values for Loan Amount, Interest Rate, and Term.");
			return false;
		}
		return true;
	}
	
	// this will validate the Text field row
	private boolean rowsCheck() {
		try {
			int rowCount =  Integer.parseInt(txtRows.getText());
			if (rowCount <= 0) {
				JOptionPane.showMessageDialog(null, "Please enter valid number.");
				return false;
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Please enter valid number.");
			return false;
		}
		return true;
	}
}
