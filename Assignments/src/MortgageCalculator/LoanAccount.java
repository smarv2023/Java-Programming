package MortgageCalculator;
/*
 * Computation and Loan variables
 **/
public class LoanAccount{
	public double loanAmount;
	public double interestRate;
	public int term;
	public double homeValue;
	public double monthlyPayment;
	public double totalInterest;
	
	public double total;
	
	@Override
	public String toString() {
		return String.format("LoanAmount: $%,.2f%nInterest Rate: %,.2f%nTerm in months: %d%n"
				+ "Monthly Payment: $%,.2f%nHome Value: $%,.2f%nTotal Interest: $%,.2f%nTotal: $%,.2f%n%n", 
				 loanAmount, interestRate, term, monthlyPayment, homeValue, totalInterest, total);
	}
	
	public void calculateLoan() {
		term *= 12;
		double calcInterest = interestRate / (12 * 100);
		monthlyPayment = loanAmount * (calcInterest / (1-(Math.pow(1 + calcInterest, - term))));
		homeValue = loanAmount * 1.25;
		totalInterest = monthlyPayment * term - loanAmount;
		total = homeValue + totalInterest;
	}
}
