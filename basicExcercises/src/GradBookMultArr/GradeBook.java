package GradBookMultArr;

public class GradeBook {
	private String courseName;
	private int[][] grades;
	
	// constructor
	public GradeBook(String courseName, int[][] grades) {
		this.courseName = courseName;
		this.grades = grades;
	}
	
	// method to set the course name
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	// method to retrieve the course name
	public String getCourseName() {
		return courseName;
	}
	
	// method to perform various operation on the data
	public void processGrades() {
		// output grades array
		outputGrades();
		
		// call method getMinimum to calculate the average grade
		System.out.printf("%n%s %d%n%s %d%n%n",
				"Lowest grade in the grade book is", getMinimum(),
				"Highest grad in the grade book is", getMaximum());
		
		// call outputBarChart to print grade distribution chart
		outputBarChart();
	}
	
	// find minimum grade
	public int getMinimum() {
		int lowGrade = grades[0][0]; // start with the value in index 0
		
		// loop through grades array
		for (int[] studentGrades : grades) {
			for (int grade : studentGrades) {
				if (grade < lowGrade)
					lowGrade = grade; // pass the new lowest grade
			}
		}
		return lowGrade;
	}
	
	// find maximum grade
	public int getMaximum() {
		int highGrade = grades[0][0]; // values in index 0
		
		// loop through grades array
		for (int[] studentGrades : grades) {
			for (int grade : studentGrades) {
				if (grade > highGrade)
					highGrade = grade; // pass the new highest grade
			}
		}
		return highGrade;	
	}
	
	// average grade for test
	public double getAverage(int[] setOfGrades) {
		int total = 0;
		
		// sum grades from one student
		for (int grade : setOfGrades)
			total += grade;
		
		// return average of grades
		return (double) total / setOfGrades.length;
	}
	
	// output bar chart displaying grade distribution
	public void outputBarChart() {
		System.out.println("Grade distribution:");
		
		// store frequency of grades in each range of 10 grades
		int[] frequency = new int[11];
		
		// for each grade, increment the appropriate frequency
		for (int[] studentGrades : grades) {
			for (int grade : studentGrades)
				++frequency[grade / 10];
		}
		
		// for each grade frequency, print bar in chart
		for (int count = 0; count < frequency.length; count++) {
			// output bar label ("00-09:" -  "90-99:" "100: ")
			if (count==10)
				System.out.printf("%5d:", 100);
			else
				System.out.printf("%02d-%02d: ", count * 10, count * 10 + 9);
			
			for (int stars = 0; stars < frequency[count]; stars++)
				System.out.print("*");
			
			System.out.println();
		}
	}
	
	// outputGrades
	public void outputGrades() {
		System.out.printf("The grades are:%n%n");
		System.out.print("            "); // alignment
		
		// create a column heading for each of the tests
		for (int test = 0; test  < grades[0].length; test++)
			System.out.printf(" Test %d  ", test + 1);
		
		System.out.println("Average");
		
		// output each student's grade
		for (int student = 0; student < grades.length; student++) {
			System.out.printf("Student %2d:", student + 1);
		
			for (int test : grades[student])
				System.out.printf("%8d", test);
		
		double average = getAverage(grades[student]);
		System.out.printf("%9.2f%n", average);
		}
	}
}