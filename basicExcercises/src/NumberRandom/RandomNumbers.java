package NumberRandom;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RandomNumbers {

	public static void main(String[] args) {
		int[] selected = new int[7];
		Scanner input = new Scanner(System.in);
		for (int numbers = 0; numbers < selected.length; numbers++ ) {
		    System.out.printf("number %d: %n", (numbers + 1));
		    selected[numbers] = input.nextInt();
		}
		input.close();
		SecureRandom randomNumbers = new SecureRandom();
		int[] frequency = new int[50];
		int numberOfRolls = 6000000;
		for (int roll = 1; roll <= numberOfRolls; roll++) {

			for (int select : selected ) {

				if (select == roll) {
					System.out.printf("Win %d", select);
					
					// toss true or false
					SecureRandom randomF = new SecureRandom();
					int torf = randomF.nextInt(2);
					if (torf == 0) {
						numberOfRolls ++;
						System.out.print(" False");
					}
				}
			}
			++frequency[1 + randomNumbers.nextInt(49)];
		}
		
	      Integer[][] frequencyPairs = new Integer[frequency.length][2];
	        for (int i = 0; i < frequency.length; i++) {
	            frequencyPairs[i][0] = i;
	            frequencyPairs[i][1] = frequency[i];
	        }

	        // Sort the pairs based on frequency in descending order
	        Arrays.sort(frequencyPairs, Comparator.comparing((Integer[] arr) -> arr[1]).reversed());

	        System.out.printf("%s%10s%n", "Number", "Frequency");

	        // Print the sorted frequencies
	        for (Integer[] pair : frequencyPairs) {
	            System.out.printf("%4d%10d%n", pair[0], pair[1]);
	        }
		
		System.out.printf("%s%10s%n", "Number", "Frequency");
		
		for (int face = 1; face <frequency.length; face++)
			System.out.printf("%4d%10d%n", face, frequency[face]);
	}
}
