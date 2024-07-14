package GradeBook;

public class GradeBook {
	private String courseName;
	private int[] grades;
	
	// constructor
	public GradeBook(String courseName, int[] grades) {
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
		
		// call method getAverage to calculate the average grade
		System.out.printf("%nClass average is %.2f%n", getAverage());
		
		// call method getMinimum to calculate the average grade
		System.out.printf("Lowest grade is %d%nHighest grade is %d%n%n", getMinimum(), getMaximum());
		
		// call outputBarChart to print grade distribution chart
		outputBarChart();
	}
	
	// find minimum grade
	public int getMinimum() {
		int lowGrade = grades[0]; // start with the value in index 0
		
		// loop through grades array
		for (int grade : grades) {
			if (grade < lowGrade)
				lowGrade = grade; // pass the new lowest grade
		}
		return lowGrade;
	}
	
	// find maximum grade
	public int getMaximum() {
		int highGrade = grades[0]; // values in index 0
		
		// loop through grades array
		for (int grade : grades) {
			if (grade > highGrade)
				highGrade = grade; // pass the new highest grade
		}
		return highGrade;	
	}
	
	// average grade for test
	public double getAverage() {
		int total = 0;
		
		// sum grades from one student
		for (int grade : grades)
			total += grade;
		
		// return average of grades
		return (double) total / grades.length;
	}
	
	// output bar chart displaying grade distribution
	public void outputBarChart() {
		System.out.println("Grade distribution:");
		
		// store frequency of grades in each range of 10 grades
		int[] frequency = new int[11];
		
		// for each grade, increment the appropriate frequency
		for (int grade : grades)
			++frequency[grade / 10];
		
		// for each grade frequency, print bar in chart
		for (int count = 0; count < frequency.length; count++) {
			// output bar labe ("00-09:" -  "90-99:" "100: ")
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
		
		// output each student's grade
		for (int student = 0; student < grades.length; student++)
			System.out.printf("Student %2d: %3d%n", student + 1, grades[student]);
	}
}
