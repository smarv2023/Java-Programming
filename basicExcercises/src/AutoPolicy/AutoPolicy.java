package AutoPolicy;

public class AutoPolicy {
	private int accountNumber;
	private String makeAndModel;
	private String state;
	
	// Constructor
	public AutoPolicy(int accountNumber, String makeAndModel, String state) {
		this.accountNumber = accountNumber;
		this.makeAndModel = makeAndModel;
		this.state = state;
	}
	
	//// Set the accountNumber ////
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	// return the accuntNumber
	public int getAccountNumber() {
		return accountNumber;
	}
	
	//// Set the MakeAndModel ////
	public void setMakeAndModel(String makeAndModel) {
		this.makeAndModel = makeAndModel;
	}
	//return the makeAndModel
	public String getMakeAndModel() {
		return makeAndModel;
	}
	
	//// Set the state ////
	public void setState(String state) {
		this.state = state;
	}
	// return the state
	public String getState() {
		return state;
	}
	
	
	// predicate method returns whether the state has no-fault insurance
	public boolean isNoFaultState() {
		boolean noFaultState;
		
		// determine whether state has no-fault auto insurance
		switch (getState()) {
		case "MA": case "NJ": case "NY": case "PA":
			noFaultState = true;
			break;
		default:
			noFaultState = false;
			break;
		}
		return noFaultState;
	}
}
