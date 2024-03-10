package FileAndDirectoryInfo;

public enum MenuForFileInquiry {
	// declare contents of ENUM type
	ZERO_BALANCE(1),
	CREDIT_BALANCE(2),
	DEBIT_BALANCE(3),
	END(4);
	
	private final int value; // current menu option
	
	//constructor
	private MenuForFileInquiry(int value) {
		this.value = value;
	}
}
