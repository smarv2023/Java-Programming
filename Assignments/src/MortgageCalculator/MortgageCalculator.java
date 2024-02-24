package MortgageCalculator;
/*
 * Create a program called MortgageCalculator. Out of 44 pts
 * 
 * @instructor: Naresh Nagandla
 * @author:  Marvin Soro 
 * @version: 1.0 
 * @since:   2024-02-17 
 * **/
public class MortgageCalculator {

	public static void main(String[] args) {

		// Execute GUI
		try {
			MortgageCalculatorGUI frame = new MortgageCalculatorGUI();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
