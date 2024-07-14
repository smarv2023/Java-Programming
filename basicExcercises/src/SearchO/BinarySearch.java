package SearchO;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	
	public static int searchBinary(int[] data, int key) {
		// perform search
		int left = 0;
		int right = data.length -1;
		int middle = (left + right + 1) / 2;
		
		int location = -1; // default quit if not found
		
		do {
			System.out.print(remainingElements(data, left, right));
			
			for (int i = 0; i < middle; i++)
				System.out.print("   ");
			System.out.println(" * ");
			
			// if the element is found at the middle
			if (key == data[middle])
				location = middle;
			else if (key < data[middle])
				right = middle -1;
			else
				left = middle + 1;
			
			// recalculate the middle
			middle = (left + right + 1) / 2;
			
		} while ((left <= right) && (location == -1));
		
		return location;
	}
	
	// method to output certain values in array
	private static String remainingElements(int[] data, int left, int right) {
		StringBuilder temporary = new StringBuilder();
		
		// append space for alignment
		for (int i = 0; i < left; i++)
			temporary.append("   ");
		
		// append elements left in array
		for (int i = left; i <= right; i++)
			temporary.append(data[i] + " ");
		
		return String.format("%s%n", temporary);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SecureRandom generator = new SecureRandom();
		
		int[] data = new int[15];
		
		// generate array value
		for (int i = 0; i < data.length; i++)
			data[i] = 10 + generator.nextInt(90);
		
		// print generated value and sort
		Arrays.sort(data);
		System.out.printf("%s%n%n", Arrays.toString(data));
		
		// take input
		System.out.printf("Please enter an integer value (-1 to quit): ");
		int searchInt = input.nextInt();
		input.close();
		
		// Loop until quit
		while (searchInt != -1) {
			// perform search by calling method
			int location = searchBinary(data, searchInt);
			
			// if not found
			if (location == -1)
				System.out.printf("%d was not found %n%n", searchInt);
			else
				System.out.printf("%d was found in index position %d%n%n", searchInt, location);
			
			// ask again
			System.out.printf("Please enter an integer value (-1 to quit): ");
			searchInt = input.nextInt();
		}
	}
}
