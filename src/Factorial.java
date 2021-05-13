/*
 * This program calculates the factorial of really big numbers
 * */
 
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.swing.JOptionPane;

public class Factorial {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Welcome to calculate factorial");
		String inputString = JOptionPane.showInputDialog("what do you want to calculate into factorial");
		
		//Define variables
		int input = Integer.parseInt(inputString);
		double factorialAnswerDouble = 1;
		int factorialAnswerInt = 1;  
		long factorialAnswerLongInt = 1;
		
		BigDecimal factorialAnswerBigDecimal = new BigDecimal(1);
		
		//Loop through the numbers and multiply the number with incremented value
		
				for (int i = 2; i <= input; i++) {
					factorialAnswerInt = factorialAnswerInt * i;
					factorialAnswerDouble = factorialAnswerDouble * i;
					factorialAnswerLongInt = factorialAnswerLongInt * i;
					factorialAnswerBigDecimal = factorialAnswerBigDecimal.multiply(new BigDecimal(i));
		}
		
		
		JOptionPane.showMessageDialog(null, input + " factorial is " +   
				 factorialAnswerBigDecimal + "\n" );
	}
}
