package FileAndDirectoryInfo;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
	
	private static Formatter output; // outputs text to a file
	
	public static void main(String[] args) {
		openFile();
		addRecords();
		closeFile();
	}
	
	// open/create a file client
	public static void openFile() {
		// if you want to name a file or create a file
		//System.out.println("Enter file to open");
		//Scanner input = new Scanner(System.in);
		//String search = input.nextLine();
		try {
			//output = new Formatter(input.next() + ".txt");
			output = new Formatter("clients.txt");
		} catch (SecurityException securityE){
			System.err.println("Write permission denied. Terminating.");
			System.exit(1); // terminate the program
		} catch (FileNotFoundException fileNotFoundE) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1); // terminate the program
		}
	}

	private static void addRecords() {
		Scanner input = new Scanner(System.in);
		System.out.printf("%s%n%s%n ", "Enter account number, first name, last name and balance.", 
				"Enter end-of-file indicator to end input.");
		
		while (input.hasNext()) {
			try {
				// write new record to file; assumes valid input
				output.format("%d %s %s %.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
			} catch (FormatterClosedException formatterCloseException) {
				System.err.println("Error writing to file. Terminating.");
				break;
			} catch (NoSuchElementException elementException) {
				System.err.println("Invalid input. Please try again.");
				input.nextLine(); //  clear input, so user can try again
			} 
			System.out.print("Do you want to continue?");
			String x = input.next();
			if (x.equals("no")) {
				break;
			}
		}
		input.close();
	}
	
	private static void closeFile() {
		if (output != null)
			output.close();
	}
}
