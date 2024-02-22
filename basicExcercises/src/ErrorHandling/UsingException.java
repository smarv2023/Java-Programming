package ErrorHandling;

public class UsingException {

	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.err.printf("%s%n%n", e.getMessage());
			e.printStackTrace();
			
			// obtain the stack trace info
			StackTraceElement[] traceElements = e.getStackTrace();
			
			System.out.printf("%nStack trace from getstackTrace:");
			System.out.printf("%nClass\t\t\t\tFile\t\t\tLine\tMethod%n");
			
			for (StackTraceElement element : traceElements) {
				System.out.printf("%s\t", element.getClassName());
				System.out.printf("%s\t", element.getFileName());
				System.out.printf("%s\t", element.getLineNumber());
				System.out.printf("%s%n", element.getMethodName());
			}
		}
	}
	
	public static void method1() throws Exception {
		method2();
	}
	
	public static void method2() throws Exception {
		method3();
	}
	
	public static void method3() throws Exception {
		throw new Exception("Exception thrown in method3");
	}
}
