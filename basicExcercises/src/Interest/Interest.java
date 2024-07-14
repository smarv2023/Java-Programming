package Interest;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Interest {

	public static void main(String[] args) {
		BigDecimal principal = BigDecimal.valueOf(1000.0);
		BigDecimal rate = BigDecimal.valueOf(0.05);
		
		System.out.printf("%s%20s%n", "Year", "Amunt on deposit");
		
		for (int year = 1; year <= 10; year++) {
			// interest          	1000 *
			BigDecimal amount = principal.multiply(rate.add(BigDecimal.ONE).pow(year));
			
			// Currency format the output on local specific/Call/method/format(variable)
			System.out.printf("%4d%20s%n", year, NumberFormat.getCurrencyInstance().format(amount));
		}
	}
}
