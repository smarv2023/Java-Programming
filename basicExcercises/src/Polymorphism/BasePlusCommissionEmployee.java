package Polymorphism;

public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary;
	
	// constructor
	public BasePlusCommissionEmployee(String firstName, String lastName,
			String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary) {
		
		// calling the recently define constructor
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		
		if (baseSalary < baseSalary) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}
		this.baseSalary = baseSalary;
	}
	
	// set base salary
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}
		this.baseSalary = baseSalary;
	}
	
	// return base salary
	public double getBaseSalary() {
		return baseSalary;
	}
	
	// calculate earnings
	@Override
	public double earnings() {
		// super recently define earnings()
		return getBaseSalary() + super.earnings();
	}
	
	// call and override the toString from superClass "super.toString" then added the base salary detail from this class.
	@Override
	public String toString() {
		return String.format("%s %s%n%s: %.2f", "base-salaried",
				super.toString(), "base salary", getBaseSalary());
	}
}

