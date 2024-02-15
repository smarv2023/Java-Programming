package MethodOverload;

public class MethodOverload {

	public static void main(String[] args) {
		System.out.printf("Squalre of integer 7 is %d%n", square(7));
		System.out.printf("Squalre of integer 7 is %f%n", square(7.5));

	}
	
	
	// Java can recognize which will execute base on the type
	public static int square(int intValue) {
		System.out.printf("%nCalled square with int argument: %d%n", intValue);
		return intValue * intValue;
	}
	
	public static double square(double doubleValue) {
		System.out.printf("%nCalled square with int argument: %f%n", doubleValue);
		return doubleValue * doubleValue;
	}

}
