package ErrorHandling;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionWithExceptionHandling {
	
	public static int quotient(int numerator, int denominator)
		// method declaration is used to specify that the method might throw certain exceptions during its execution
		throws ArithmeticException {
		return numerator / denominator;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean continueLoop = true;
		
		do {
			try {
				System.out.print("Please enter an integer numerator: ");
				int numerator = input.nextInt();
				System.out.print("Please enter an integer denaminator: ");
				int denominator = input.nextInt();
				
				int result = quotient(numerator, denominator);
				System.out.printf("%nResult: %d / %d = %d%n", numerator, denominator, result);
				continueLoop = false;
			} catch (InputMismatchException e) {
				System.err.printf("%nException: %s%n", e);
				input.nextLine(); // clear the scanner input
				System.out.println("You must enter integers. please try again.%n%n");
			} catch (ArithmeticException aE) {
				System.err.printf("%nException: %s%n", aE);
				System.out.printf("Zero is an invalid denominator.Please try again.%n%n");
			}
		} while (continueLoop);
		input.close();
	}

}
