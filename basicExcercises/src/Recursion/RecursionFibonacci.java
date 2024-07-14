package Recursion;

public class RecursionFibonacci {

	public static void main(String[] args) {
		int number = 20;
		for(int counter = 0; counter <= number; counter++)
			System.out.printf("Fibonacci of %d is: %d%n", counter, fibonacci(counter));
	}

	private static int fibonacci(int counter) {
		if (counter < 2) {
			return counter;
		} else {
			return (fibonacci(counter - 1) + fibonacci(counter - 2));
		}
	}
}
