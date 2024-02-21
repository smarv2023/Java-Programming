package Polymorphism;

public class PolymorphismTest {

	public static void main(String[] args) {
		CommissionEmployee commissionEmployee = new CommissionEmployee(
				"Pot", "Tatoes", "111-22-3333", 10000, .06);
		
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(
				"Tom", "Matoes", "222-33-444", 5000, .04, 300);
		
		System.out.printf("%s %s:%n%n%s%n%n", "Call CommissionEmployee's toString with superclass reference ",
				"to superclass object", commissionEmployee.toString());
		
		System.out.printf("%s %s:%n%n%s%n%n", "Call BasePlusCommissionEmployee's toString with subclass",
				"reference to subclass object\",", basePlusCommissionEmployee.toString());
		
		CommissionEmployee commissionEmployee2 = basePlusCommissionEmployee;
		
		System.out.printf("%s %s:%n%n%s%n", "Call BasePlusCommisssionEmployee's toString with superclass",
				"reference to subclass object", commissionEmployee2.toString());
	}

}
