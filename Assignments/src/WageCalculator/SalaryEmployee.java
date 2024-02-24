package WageCalculator;
/*
 * Create a concrete class SalaryEmployee that extends Employee and implements Payroll with the following fields:   2pts
 * 	public String name
 * 	public double salary
 * 
 * Create a constructor that takes, name and salary  3pts
 * 
 * Set up toString method to output all data.   3pts
 * 
 * Set up generatePayroll to calculate based on   3pts
 * 	weekly salary = salary / 26
 * 	grossPay = weekly salary
 * 	taxes = weekly salary * 0.15
 * 	net pay = gross pay - taxes
 * **/
public class SalaryEmployee extends Employee implements Payroll{
	public double salary;
	
	public SalaryEmployee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public void generatePayroll() {
		double weeklySalary = salary / 26;
		grossPay = weeklySalary;
		taxes = weeklySalary *0.15;
		netPay = grossPay - taxes;
	}
	@Override
	public String toString() {
		return String.format("Salary Employee Name: %s%nGross Pay: $%.2f%nTaxes: -$%.2f%nNet Pay: $%.2f%n%n", 
				name, grossPay, taxes, netPay);
	}
}
