package FileAndDirectoryInfo;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileInquiry {
	
	private final static MenuForFileInquiry[] choices = MenuForFileInquiry.values();
	
	public static void main(String[] args) {
		// get user's request (e.g., zero, balance)
		MenuForFileInquiry accountType = getRequest();
		
		// Show the selected option
		while (accountType != MenuForFileInquiry.END) {
			switch (accountType) {
				case ZERO_BALANCE:
					System.out.printf("%nAccounts with zero balance:%n");
					break;
				case CREDIT_BALANCE:
					System.out.printf("%nAccounts with credit balance:%n");
					break;
				case DEBIT_BALANCE:
					System.out.printf("%nAccounts with debit balance:%n");
					break;
				default:
					break;
			}
			// run the method
			readRecords(accountType);
			accountType = getRequest(); // get user's request
		}
	}
	
	private static MenuForFileInquiry getRequest() {
		int request = 4;
		
		// display request options
		System.out.printf("%nEnter request%n%s%n%s%n%s%n%s%n", 
				"1 - List accounts with zero balances",
				"2 - List accounts with credit balances",
				"3 - List accounts with debit balances",
				"4 - Terminate program");
		
		try {
			Scanner input = new Scanner(System.in);
			do {
				System.out.printf("%n? ");
				request = input.nextInt();
			} while ((request < 1) || (request > 4));
		} catch (NoSuchElementException noSuchElementE) {
			System.err.println("Invalid input. Terminating.");
		}
		return choices[request - 1]; // return ENUM value for option
	}
	
	// read records
	private static void readRecords(MenuForFileInquiry accountType) {
		// open file
		try (Scanner input = new Scanner(Paths.get("clients.txt"))) {
			while (input.hasNext()) {
				int accountNumber = input.nextInt();
				String firstName = input.next();
				String lastName = input.next();
				double balance = input.nextDouble();
				
				// verify the balance before displaying
				if (shouldDisplay(accountType, balance)) {
					System.out.printf("%-10d%-12s%-12s%10.2f%n", accountNumber, firstName, lastName, balance);
				} else {
					input.nextLine(); // clear
				}
			}		
		} catch (NoSuchElementException | IllegalStateException | IOException e) {
			System.err.println("Error processing file Terminating.");
			System.exit(1);
		}	
	}

	private static boolean shouldDisplay(MenuForFileInquiry accountType, double balance) {
		if ((accountType == MenuForFileInquiry.CREDIT_BALANCE) && (balance < 0)) {
			return true;
		}
		if ((accountType == MenuForFileInquiry.DEBIT_BALANCE) && (balance > 0)) {
			return true;
		}
		if ((accountType == MenuForFileInquiry.ZERO_BALANCE) && (balance == 0)) {
			return true;
		}
		return false;
	}
}
