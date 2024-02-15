package basicExcercises;
import java.util.Scanner;

public class Addition {

	public static void main(String[] args) {
		// Addition program that inputs two numbers then displays their sum.
		Scanner input =  new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
		int number1 = input.nextInt();  // read first number from user
		
		System.out.print("Enter second integer: ");
		int number2 = input.nextInt();  // read second number from user
		
		int sum = number1 + number2;  // display sum
		
		System.out.printf("%d + %d%nSum is %d%n", number1,number2, sum);
		
		input.close();
	}

}
