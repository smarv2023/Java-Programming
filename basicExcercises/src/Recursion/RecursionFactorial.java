package Recursion;
import java.math.BigInteger;

public class RecursionFactorial {

	public static void main(String[] args){
		int number = 5;
		 // calculate the factorial of 0 through given number
        for (int counter = 0; counter <= number; counter++) {
            System.out.printf("%d! = %d%n", counter, factorial(BigInteger.valueOf(counter)));
        }
        
        // this will show the difference and limitation of long vs BigInteger
        for (int counter = 0; counter <= number; counter++) {
            System.out.printf("%d! = %d%n", counter, factorialLong(counter));
        }
	}
	    
	// recursive method factorial (assumes its parameter is >= 0)
	public static BigInteger factorial(BigInteger number)  {   
		// compareTo method(if number is less than 1 return -1) (if number is equal to 1 return 0) (if greater then return 1)
        if (number.compareTo(BigInteger.ONE) <= 0) // test for base case 
        	return BigInteger.ONE; // base cases: 0! = 1 and 1! = 1   
    
        else // recursion step
            return number.multiply(factorial(number.subtract(BigInteger.ONE)));                
     }

	public static long factorialLong(long counter) {
		if (counter <= 0)
			return 1;
		else
			return counter * factorialLong(counter - 1);
	}
}
