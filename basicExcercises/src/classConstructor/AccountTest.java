package classConstructor;

import java.util.Scanner;

public class AccountTest {

	public static void main(String[] args) {
		// Obtain input from the User

		// Create an Account
		Account account1 = new Account("Marvin", 1.00);
		Account account2 = new Account("John blue", -7.53);
		
		
		// Display Initial name and balance
		displayAccount(account1);
		displayAccount(account2);
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter deposit amount for account1: ");
		double depositAmount = input.nextDouble();
		System.out.printf("%nadding %.2f to account1 balance%n%n", depositAmount);
		account1.deposit(depositAmount);
		
		displayAccount(account1);

		System.out.print("Enter deposit amount for account2: ");
		depositAmount = input.nextDouble();
		System.out.printf("%nadding %.2f to account1 balance%n%n", depositAmount);
		account2.deposit(depositAmount);
		
		displayAccount(account2);
		
		// Display updated balance
		displayAccount(account1);
		displayAccount(account2);

		input.close();
		
	}
	
	public static void displayAccount(Account accountToDisplay) {
		System.out.printf("Name: %s balance: $%.2f%n", accountToDisplay.getName(), accountToDisplay.getBalance());
	}

}
