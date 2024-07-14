package AssignmentWeek1;

public class Account {
	
	private String name;
	private double balance;
	
	// Constructor
	public Account(String name, double balance) {
		this.name = name;
		if (balance > 0.0) {
			this.balance = balance;
		}
	}

	public void deposit(double depositAmount) {
		if (depositAmount > 0.0) {
			this.balance = this.balance + depositAmount;
		}
	}
	
	public void withdraw(double withdrawAmount) {
		if ((withdrawAmount > 0.0) && (this.balance >= withdrawAmount)) {
			//if (balance >= withdrawAmount) {
				this.balance = this.balance - withdrawAmount;
		} else {
			System.out.printf("$%.2f Decline insufficient funds %nYour remaining balance is: $%.2f%n", withdrawAmount, this.balance);
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
	// setName ready to use
	public void setName(String name) {
		this.name = name;
	}
	// method to retrieve the name from the object
	public String getName() {
		return name;
	}
}