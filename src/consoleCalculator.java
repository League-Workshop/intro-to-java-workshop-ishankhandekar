import java.math.BigDecimal;
import java.util.Scanner;

import choose_op.Choose_operator;
import logarithm.Logarithm;
                                                                                                                                                                          
public class consoleCalculator {
	
	public void run() {
		/*
		 * CHALLENGE: Make the user type something like '2*2 or 3+3' in the console and
		 * then print out the answer. BONUS POINTS if you allow the user to type in a
		 * decimal. REQUIRED OPERATIONS: *, /, +, -
		 */
		boolean isEquation = true;
		boolean isStop = false;
		
		while(isStop == false || isEquation == true) {
			isEquation = false;
			isStop = true;
			try {
				
			
			Scanner scan = new Scanner(System.in);
			System.out.println(
					"Type in two numbers with an operator in the middle. Example:2 * 2.\r\nList of all operators: * = multiplication, / = division, + = addition, - = subtraction, ^ = exponents,L = logarithm,R = radical,C = choose operator");
			
			String equation = scan.nextLine();
			equation = equation.replaceAll(" ", "");
	
			String firstNumber = "";
			String secondNumber = "";
			int operatorIndex = 0;
			for (int i = 0; i < equation.length(); i++) {
				Character charat = new Character(equation.charAt(i));
				if (charat.isDigit(equation.charAt(i)) | equation.charAt(i) == '.' | equation.charAt(i) == '-') {
					firstNumber += equation.charAt(i);
				} else {
					operatorIndex = i;
					break;
	
				}
			}
			
			double firstNumber2 = Double.parseDouble(firstNumber);
			BigDecimal firstNumber3 = new BigDecimal(firstNumber);
			for (int i = operatorIndex + 1; i < equation.length(); i++) {
				Character charat = new Character(equation.charAt(i));
				if (charat.isDigit(equation.charAt(i)) | equation.charAt(i) == '.'| equation.charAt(i) == '-') {
					secondNumber += equation.charAt(i);
				} else {
					isEquation = false;
					break;
				}
			}
			
			double secondNumber2 = Double.parseDouble(secondNumber);
			BigDecimal secondNumber3 = new BigDecimal(secondNumber);
			if (equation.contains("+")) {
				System.out.println(firstNumber3.add(secondNumber3));
			} else if (equation.charAt(operatorIndex) == '-') {
				
				System.out.println(firstNumber3.subtract(secondNumber3));
			} else if (equation.contains("*")) {
				System.out.println(secondNumber3.multiply(firstNumber3));
			} else if (equation.contains("/")) {
				if (secondNumber2 == 0) {
					System.out.println("UNDEFINED");
				}else{
					isEquation = false;
					System.out.println(firstNumber2 / secondNumber2);
					
				}
				
			} else if (equation.contains("^")) {
				System.out.println(Math.pow(firstNumber2, secondNumber2));
			} else if (equation.contains("L")) {
				Logarithm log = new Logarithm();
				log.log(firstNumber2, secondNumber2);
			} else if (equation.contains("R")) {
				System.out.println(Math.pow(secondNumber2, 1 / firstNumber2));			
			} else if (equation.contains("C")) {
				Choose_operator co = new Choose_operator();
				co.choose(firstNumber2, secondNumber2);	
			}else {
				isEquation = false;
				System.err.println("This is not a supported operation. Try again");
				
			}
		
		}catch (Exception e) {
			System.err.println("This is not an equation. Try again");
			isEquation = false;
			
		}
	}
}

	}
