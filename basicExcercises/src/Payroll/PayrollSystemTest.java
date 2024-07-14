package Payroll;

public class PayrollSystemTest {

	public static void main(String[] args) {
		// create object
		SalariedEmployee salariedEmployee = new SalariedEmployee("Pot", "Tatoes", "111-22-3333", 800.00);
		
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Tom", "Matoes", "222-33-4444", 16.75, 40);
		
		CommissionEmployee commissionEmployee = new CommissionEmployee("Mar", "Vin", "333-44-5555", 1000, .06);
		
		BasePlusCommissionEmployee baseCommissionEmployee = 
				new BasePlusCommissionEmployee("Onion", "Knight", "444-55-7777", 5000, .04, 300);
		
		System.out.println("Employees processed individually:");
		
		System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee, "earned", salariedEmployee.earnings());
		
		System.out.printf("%n%s%n%s: $%,.2f%n%n", hourlyEmployee, "earned", hourlyEmployee.earnings());
		
		System.out.printf("%s%n%s: $%,.2f%n%n", commissionEmployee, "earned", commissionEmployee.earnings());
		
		System.out.printf("%s%n%s: $%,.2f%n%n", baseCommissionEmployee, "earned", baseCommissionEmployee.earnings());
		
		Employee[] employees = new Employee[4];
		
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = baseCommissionEmployee;
		
		System.out.printf("Empoyees processed polymorphically:%n%n");
		
		for (Employee employee : employees) {
			System.out.println(employee);
			
			if (employee instanceof BasePlusCommissionEmployee) {
				// Downcast Employee reference to base plus commission employee
				BasePlusCommissionEmployee baseEmployee = (BasePlusCommissionEmployee) employee;
				
				baseEmployee.setBaseSalary(1.10 * baseEmployee.getBaseSalary());
				
				System.out.printf("new base salary with 10%% increase is $%,.2f", baseEmployee.getBaseSalary());
			}
			System.out.printf("earned $%,.2f%n%n", employee.earnings());
		}
		
		for (int j = 0; j < employees.length; j++) {
			System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
		}
	}
}
