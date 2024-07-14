package FileAndDirectoryInfo;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {

	public static Scanner input;
	
	public static void main(String[] args) {
		openFile();
		readRecords();
		closeFile();
	}
	
	// open file client
	public static void openFile() {
		try {
			// get the file
			input = new Scanner(Paths.get("clients.txt"));
		} catch (IOException ioException) {
			System.err.println("Error open file. Terminating.");
			System.exit(1);
		}
	}

	private static void readRecords() {
		System.out.printf("%-10s%-12s%-12s%10s%n", "Account", "First Name", "Last Name", "Balance");
		
		try {
			while (input.hasNext()) {
				// display records from file
				System.out.printf("%-10s%-12s%-12s%10.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
			}
		} catch (NoSuchElementException elementException) {
			System.err.println("File improperly formed. Terminating.");
			input.nextLine(); //  clear input, so user can try again
		} catch (IllegalStateException stateException) {	
			System.err.println("Error reading from file. Terminating.");
		}
	}	
	
	private static void closeFile() {
		if (input != null)
			input.close();
	}
}
