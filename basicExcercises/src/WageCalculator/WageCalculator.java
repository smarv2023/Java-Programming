package WageCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

interface Payroll {
    void generatePayroll();
}

abstract class Employee {
    public double grossPay;
    public double taxes;
    public double netpay;

    //abstract void generatePayroll();
}

class HourlyEmployee extends Employee implements Payroll {
    public String name;
    public double hourlyWage;
    public double hoursWorked;

    public HourlyEmployee(String name, double hourlyWage, double hoursWorked) {
        this.name = name;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void generatePayroll() {
        grossPay = hourlyWage * hoursWorked;
        taxes = grossPay * 0.15;
        netpay = grossPay - taxes;
    }

    @Override
    public String toString() {
        return "Hourly Employee: " + name + "\nGross Pay: $" + grossPay + "\nTaxes: -$" + taxes + "\nNet Pay: $" + netpay + "\n";
    }
}

class SalaryEmployee extends Employee implements Payroll {
    public String name;
    public double salary;

    public SalaryEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void generatePayroll() {
        double weeklySalary = salary / 26;
        grossPay = weeklySalary;
        taxes = weeklySalary * 0.15;
        netpay = grossPay - taxes;
    }

    @Override
    public String toString() {
        return "Salary Employee: " + name + "\nGross Pay: $" + grossPay + "\nTaxes: $" + taxes + "\nNet Pay: $" + netpay + "\n";
    }
}

public class WageCalculator extends JFrame {
    private JComboBox<String> employeeTypeCombo;
    private JTextField nameField;
    private JTextField wageField;
    private JTextField hoursField;
    private JTextField salaryField;
    private JTextArea txtOutput;
    private ArrayList<Employee> employees;

    public WageCalculator() {
        setTitle("Wage Calculator");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        employees = new ArrayList<>();

        JLabel employeeTypeLabel = new JLabel("Employee Type:");
        employeeTypeLabel.setBounds(20, 20, 100, 25);
        add(employeeTypeLabel);

        String[] employeeTypes = {"Select", "Hourly", "Salary"};
        employeeTypeCombo = new JComboBox<>(employeeTypes);
        employeeTypeCombo.setBounds(130, 20, 100, 25);
        add(employeeTypeCombo);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 60, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(130, 60, 150, 25);
        add(nameField);

        JLabel wageLabel = new JLabel("Hourly Wage:");
        wageLabel.setBounds(20, 100, 100, 25);
        add(wageLabel);

        wageField = new JTextField();
        wageField.setBounds(130, 100, 100, 25);
        add(wageField);

        JLabel hoursLabel = new JLabel("Hours Worked:");
        hoursLabel.setBounds(20, 140, 100, 25);
        add(hoursLabel);

        hoursField = new JTextField();
        hoursField.setBounds(130, 140, 100, 25);
        add(hoursField);

        JLabel salaryLabel = new JLabel("Yearly Salary:");
        salaryLabel.setBounds(20, 180, 100, 25);
        add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setBounds(130, 180, 100, 25);
        add(salaryField);
        salaryField.setEnabled(false);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(20, 220, 100, 25);
        add(submitButton);

        txtOutput = new JTextArea();
        txtOutput.setBounds(20, 260, 440, 100);
        add(txtOutput);

        JButton showReportButton = new JButton("Show Report");
        showReportButton.setBounds(20, 370, 150, 25);
        add(showReportButton);

        employeeTypeCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) employeeTypeCombo.getSelectedItem();
                if (selectedType.equals("Hourly")) {
                    wageField.setEnabled(true);
                    hoursField.setEnabled(true);
                    salaryField.setEnabled(false);
                } else if (selectedType.equals("Salary")) {
                    wageField.setEnabled(false);
                    hoursField.setEnabled(false);
                    salaryField.setEnabled(true);
                } else {
                    wageField.setEnabled(false);
                    hoursField.setEnabled(false);
                    salaryField.setEnabled(false);
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String employeeType = (String) employeeTypeCombo.getSelectedItem();
                String name = nameField.getText();
                if (employeeType.equals("Hourly")) {
                    double wage = Double.parseDouble(wageField.getText());
                    double hours = Double.parseDouble(hoursField.getText());
                    HourlyEmployee employee = new HourlyEmployee(name, wage, hours);
                    employee.generatePayroll();
                    employees.add(employee);
                    txtOutput.append(employee.toString() + "\n");
                } else if (employeeType.equals("Salary")) {
                    double salary = Double.parseDouble(salaryField.getText());
                    SalaryEmployee employee = new SalaryEmployee(name, salary);
                    employee.generatePayroll();
                    employees.add(employee);
                    txtOutput.append(employee.toString() + "\n");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an employee type.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        showReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Employee employee : employees) {
                    txtOutput.append(employee.toString() + "\n");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new WageCalculator();
    }
}

