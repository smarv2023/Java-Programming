package Time;

public class Time1Test {

	public static void main(String[] args) {
		Time1 time = new Time1();
		
		// display initial value
		displayTime("After time object is created", time);
		System.out.println();
		
		// display time after giving value
		time.setTime(13, 9, 6);
		displayTime("After calling setTime", time);
		System.out.println();
		
	     // attempt to set time with invalid values
		try {
			// intentional error to see error handling result
			time.setTime(99, 99, 99);
		} catch (IllegalArgumentException e) {
			System.out.printf("Exception: %s%n%n", e.getMessage());
		}
		
		displayTime("After calling setTime with invalid values", time);
	}
	

	private static void displayTime(String header, Time1 t) {
		System.out.printf("%s%nUniversal time: %s%nStandard time: %s%n",
				header, t.toUniversalString(), t.toString());
	}
}
