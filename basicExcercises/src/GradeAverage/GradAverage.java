package GradeAverage;
import java.util.Scanner;

public class GradAverage {
	
	public static boolean inputValidator(Scanner input) {
		if (input.hasNextInt()) {
			return true;
		} else {
			System.out.println("Invalid input");
			input.next();
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalGrade = 0;
		int total = 0;
		boolean continueEntry = true;
		
		// Sentinel Control loop program will terminate when "Q" is Entered
		System.out.println("Please enter grade: or (Q) to Quit ");
		while (continueEntry) {
			boolean validEntry = true;

			validEntry = inputValidator(input);
			if (validEntry) {
				int grade = input.nextInt();
				if (grade <= 100 & grade > 0) {
					totalGrade += grade;
					total++;
				} else {
					System.out.println("Grade Invalid");
				}
			}
			System.out.println("Please enter grade: or (Q) to Quit ");
			if (input.hasNext("Q")) {
				continueEntry = false;
			}
		}
		input.close();
		double average = (double) totalGrade/total;
		if (average != 0) {
			System.out.printf("Total of %d entered is %d%n", total, totalGrade);
			System.out.printf("Class average: %.2f", average);
		} else {
			System.out.print("Nothing was entered");
		}
	}
}
