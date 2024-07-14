package WageCalculator;
/**
 * Create a concrete class HourlyEmployee that extends Employee and implements Payroll with the following fields:   3pts
 * 	public String name
 * 	public double hourlyWage
 * 	public double hoursWorked
 * Create a constructor that takes, name, wage and hours   3pts
 * 
 * Set up toString method to output all data. 3pts 
 * 
 * Set up generatePayroll to calculate based on 3 pts
 * 	grossPay = wage*hours
 * 	taxes = grossPay * 0.15
 * 	netpay = grossPay - taxes
 * */

public class HourlyEmployee extends Employee implements Payroll{
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
		netPay = grossPay - taxes;	
	}
	
	public String toString() {
		return String.format("Hourly Employee Name: %s%nGross Pay: $%.2f%nTaxes: -$%.2f%nNet Pay: $%.2f%n%n", 
				name, grossPay, taxes, netPay);
	}
}
