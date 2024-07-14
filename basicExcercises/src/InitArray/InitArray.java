package InitArray;

import java.util.stream.IntStream;

public class InitArray {

	public static void main(String[] args) {
		int[] array = new int[10];
		int[] array1 = {32, 27, 64, 18, 95, 14, 90, 70, 60, 37};
		
		final int ARRAY_LENGTH = 10;
		int[] array2 = new int[ARRAY_LENGTH];
		
		// array
		System.out.printf("%s%8s%n", "Index", "Value");
		for (int counter = 0; counter < array.length; counter++)
			System.out.printf("%5d%8d%n", counter, array[counter]);
		
		// array 1
		System.out.printf("%s%8s%n", "Index", "Value");
		for (int counter = 0; counter < array1.length; counter++)
			System.out.printf("%5d%8d%n", counter, array1[counter]);
		
		// array 2
		System.out.printf("%s%8s%n", "Index", "Value");
		for (int counter = 0; counter < array2.length; counter++) {
			array2[counter] = 2 + 2 * counter;
			System.out.printf("%5d%8d%n", counter, array2[counter]);
		}
		
		// Example of Lambda IntStream
		int total = IntStream.of(array1).sum();
		System.out.printf("This is total of array2 %d", total);
	}

}
