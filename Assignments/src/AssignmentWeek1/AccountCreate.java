/**
 * <h1>Banking</h1> 
 * Bank Account Exercise
 * Create a program loop that asks the user if they want to continue.
 * If they do, ask them what kind of transaction, deposit or withdrawal
 * Otherwise thank the user and end the program.
 * They must first deposit money to withdrawal because there is no money in the bank.
 * If they try to withdrawal and they have insufficient funds, 
 * tell them and restart only allow amounts > 0 to be withdrawn.
 * Only allow Y or N as input for continuing the program, if they give the wrong
 * input, tell them and ask again.
 * Ask for Deposit (D), Withdrawal (W) or Balance(B)
 * 
 * @instructor: Naresh Nagandla
 * @author:  Marvin Soro 
 * @version: 1.0 
 * @since:   2024-02-09 
 */

package AssignmentWeek1;

import java.util.Scanner;

public class AccountCreate {

	public static void main(String[] args) {
		// Obtain input from the User
		Scanner input = new Scanner(System.in);
		boolean isValid = false;
		boolean continueTransaction = true;
		String name = null;
		String regex = "^[a-zA-Z]+$";


		// Create an Account
		// Make input name and how much Balance
		while (!(isValid)) {
			System.out.print("Enter your name: ");
			name = input.nextLine();
			if (name.matches(regex)) {
				isValid = true;
			} else {
				System.out.println("Invalid input. Please enter a name consisting only of alphabetic characters.");
			}
		}
		
		double depositAmount = amountValidator(input, "initial deposit");
		Account myAccount = new Account(name, depositAmount);
		
		while (continueTransaction) {
			System.out.println("Do you want to continue transaction? Y/N");
			String yesOrNo = input.next().toUpperCase();
			if (yesOrNo.equals("N")) {
				continueTransaction = false;
			} else if (yesOrNo.equals("Y")){
				
				// Ask if Deposit or Withdraw or Check Balance
				System.out.println("Deposit (D), Withdrawal (W) or Balance(B)");
				String transactionChoice = input.next().toUpperCase();

				// Transaction Choice
				switch(transactionChoice) {
					case "D":
						// Deposit
						depositAmount = amountValidator(input, "deposit");
						transaction("Adding", depositAmount, name, myAccount);
						myAccount.deposit(depositAmount);
						displayAccount(myAccount);
						break;
						
					case "W":	
						// Withdrawal
						double withdrawAmount = amountValidator(input, "withdraw");
						transaction("Deducting", withdrawAmount, name, myAccount);
						myAccount.withdraw(withdrawAmount);
						displayAccount(myAccount);
						break;
						
					case "B":
						//Balance
						displayAccount(myAccount);
						break;
	
					default:
						displayInvalid();
						break;
				}
			} else {
				displayInvalid();
			}
		}
		input.close();
		
		System.out.printf("Okay good bye %s%n%n", name);
	}
	
	// Display Account
	public static void displayAccount(Account accountToDisplay) {
		System.out.printf("%n====BANK ACCOUNT====%nName: %s%nBalance: $%.2f%n====================%n", accountToDisplay.getName(), accountToDisplay.getBalance());
	}
	
	// Invalid choice
	public static void displayInvalid() {
		System.out.println("Invalid transaction choice");
	}
	
	// This will show the transaction
	public static void transaction(String text, double amount, String name, Account myAcc) {
		System.out.printf("%n%s $%.2f to %s's account $%.2f %n", text, amount, name, myAcc.getBalance());
	}
	
	// Validate the amount input
	public static double amountValidator(Scanner input, String text) {
		double amount = 0.0;
		boolean validInput = false;
		
		while (!(validInput)) {
			System.out.printf("Enter %s amount: $", text);
			if (input.hasNextDouble()) {
				amount = input.nextDouble();
				if (amount > 0) {
					validInput = true;
				} else {
					System.out.println("Amount must be greater than 0.");
				}
			} else {
				System.out.println("Invalid input. Please enter a valid amount.");
	            input.next(); // Consume invalid input to avoid infinite loop
			}
		}
		return amount;
	}
}
