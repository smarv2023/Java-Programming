package MortgageCalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

class LoanAccount {
    public double loanAmount;
    public double interestRate;
    public double term;
    public double homeValue;
    public double monthlyPayment;
    public double totalInterest;

    @Override
    public String toString() {
        return "LoanAmount: " + loanAmount + ", InterestRate: " + interestRate +
                ", Term: " + term + ", HomeValue: " + homeValue +
                ", MonthlyPayment: " + monthlyPayment + ", TotalInterest: " + totalInterest;
    }

    public void calculateLoan() {
        double calcInterest = interestRate / (12 * 100);
        monthlyPayment = loanAmount * (calcInterest / (1 - (Math.pow(1 + calcInterest, -term))));
        homeValue = loanAmount * 1.25;
        totalInterest = loanAmount * interestRate * (term / 12);
    }
}

public class MortgageCalculator extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtLoanAmount, txtInterestRate, txtTerm, txtHomeValue, txtMonthlyPayment;
    private JButton btnCalculate, btnSubmit, btnExit;
    private ArrayList<LoanAccount> loanAccounts = new ArrayList<>();

    public MortgageCalculator() {
        setTitle("Mortgage Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        panel.add(new JLabel("Loan Amount:"));
        txtLoanAmount = new JTextField();
        panel.add(txtLoanAmount);

        panel.add(new JLabel("Interest Rate:"));
        txtInterestRate = new JTextField();
        panel.add(txtInterestRate);

        panel.add(new JLabel("Term (in years):"));
        txtTerm = new JTextField();
        panel.add(txtTerm);

        panel.add(new JLabel("Home Value:"));
        txtHomeValue = new JTextField();
        txtHomeValue.setEditable(false);
        panel.add(txtHomeValue);

        panel.add(new JLabel("Monthly Payment:"));
        txtMonthlyPayment = new JTextField();
        txtMonthlyPayment.setEditable(false);
        panel.add(txtMonthlyPayment);

        btnCalculate = new JButton("Calculate");
        btnSubmit = new JButton("Submit to DB");
        btnExit = new JButton("Exit");

        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    LoanAccount account = new LoanAccount();
                    account.loanAmount = Double.parseDouble(txtLoanAmount.getText());
                    account.interestRate = Double.parseDouble(txtInterestRate.getText());
                    account.term = Double.parseDouble(txtTerm.getText()) * 12; // Convert years to months
                    account.calculateLoan();
                    txtHomeValue.setText(String.valueOf(account.homeValue));
                    txtMonthlyPayment.setText(String.valueOf(account.monthlyPayment));
                    loanAccounts.add(account);
                }
            }
        });

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitToDB();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(btnCalculate);
        panel.add(btnSubmit);
        panel.add(btnExit);

        add(panel);
        setVisible(true);
    }

    private boolean validateFields() {
        try {
            double loanAmount = Double.parseDouble(txtLoanAmount.getText());
            double interestRate = Double.parseDouble(txtInterestRate.getText());
            double term = Double.parseDouble(txtTerm.getText());
            if (loanAmount <= 0 || interestRate <= 0 || term <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter valid values for Loan Amount, Interest Rate, and Term.");
                return false;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter numeric values for Loan Amount, Interest Rate, and Term.");
            return false;
        }
        return true;
    }

    private void submitToDB() {
        String url = "jdbc:mysql://localhost:3306/loanaccounts";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            for (LoanAccount account : loanAccounts) {
                String query = "INSERT INTO loans (loanamount, interestrate, term, homevalue, monthlypayment, totalinterest) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setDouble(1, account.loanAmount);
                statement.setDouble(2, account.interestRate);
                statement.setDouble(3, account.term);
                statement.setDouble(4, account.homeValue);
                statement.setDouble(5, account.monthlyPayment);
                statement.setDouble(6, account.totalInterest);
                statement.executeUpdate();
            }
            loanAccounts.clear();
            JOptionPane.showMessageDialog(null, "Records submitted to database successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error submitting records to database: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new MortgageCalculator();
    }
}
