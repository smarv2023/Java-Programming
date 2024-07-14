package basicGradeAverage;
import java.util.Scanner;

public class basicGradeAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalGrade = 0;
        int total = 0;
        int grade;
        
        // Sentinel  control "-1"
        System.out.println("Please enter grade, or -1 to Quit:");
        while ((grade = input.nextInt()) != -1) { // Loop until -1 is entered
            if (grade <= 100) {
                totalGrade += grade;
                total++;
            } else {
                System.out.println("Invalid grade entered. Grade must be between 0 and 100.");
            }
            System.out.println("Please enter grade, or -1 to Quit:");
        }
        input.close();

        double average = (double) totalGrade / total;
        System.out.printf("Total of %d entered is %d%n", total, totalGrade);
        System.out.printf("Class average: %.2f%n", average);
    }
}
