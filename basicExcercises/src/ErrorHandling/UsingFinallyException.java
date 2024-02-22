package ErrorHandling;

public class UsingFinallyException {

	public static void main(String[] args) {
		try {
			throwException();
		} catch (Exception e) {
			System.err.println("Exception handle in main");
		}
		doesNotThrowException();
	}
	
	public static void throwException() throws Exception {
		try {
			System.out.println("Method throwException");
			throw new Exception();
		} catch (Exception exception) {
			System.err.println("Exception handle in method throwException");
			throw exception; // re-throw for next processing continue
		} finally {
			System.err.println("Finally exceuted in throwException");
		}
	}
	
	public static void doesNotThrowException() {
		try {
			System.out.println("Method doesNotThrowException");
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			System.err.println("Finally executed in doesNotThrowException");
		}
		System.out.println("End of method doesNotThrowException");
	}
}
