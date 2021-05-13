import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class fractionalCalculator {
	public static void main(String[] args) {

		System.out.println("Welcome to the fractional calculator. Enter in a fraction with a slash ex: 4/5. If you"
				+ " want to enter in a mixed number put it like this 4+4/5 ");

		Scanner scan = new Scanner(System.in);
//		String options[] = {"1","2","3","4","5","6","7","8","9","10"};
//		int test = JOptionPane.showOptionDialog(null, "choose your test", "", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
		
		String equation = "";
//		if (test == 0) {
//			equation = "72 / (5 /6 + 4 + (8/10)) - 24 + 9 ";
//		}else if (test == 1) {
//			equation = "96/5+(56/6) + 834 - (6 + 6/4+ (3))+1";
//		}else if (test == 2) {
//			equation = "(5/6) - 7 + 82 /9 + (99/88) + (0)";
//		}else if (test == 3) {
//			equation = "6/53-7+(64/100) + 5";
//		}else if(test == 4) {
//			equation = "9 / 5 + (4/5) + 9 * (88/4)";
//		}else if(test == 5) {
//			equation = "8 + 5 / 6 + 7 * (5/6)";
//		}else if(test == 6) {
//			equation = "8 / 6 - (6/5+2-600) + 9 /2";
//		}else if(test == 7) {
//			equation = "9 / 5 + (6/5+4) - (10/5) + 99999";
//		}else if (test == 8) {
//			equation = "46 / (78/5) + 9 /2* (6*9)+ {[(6+ 9)+8/2]*5+5}";
//		}else if (test == 9) {
//			equation = "89 + 5/2 -(5/3) /6 + 9";
//		}
	System.out.println("Put in any fractional equation and the computer will solve it for you:\n operations this supports is '+', '-', '/', '*', '^' and '),},]. \n If you want to enter a fraction, put it in parentheses \n(example: '(6/5)').\n If you want to enter a mixed number, enter an integer then a ampersand and a fraction (example: (4 & (5/6)) )\r\n");

		equation = scan.nextLine();
		
		equation = equation.replaceAll(" ", "");
		equation = equation.replaceAll("\\[", "\\(");
		equation = equation.replaceAll("\\]", "\\)");
		equation = equation.replaceAll("\\{", "\\(");
		equation = equation.replaceAll("\\}", "\\)");
		equation = equation.replaceAll("&", "+");
		
		System.out.println("Parsing equation...");
		equation = equation.replaceAll(" ", "");
		equation = putSpaces(equation, true);
		System.out.println("     Equation is now '" + equation + "'");
		while (equation.contains("(")) {
			equation = solvesLastparentheses(equation);
			
// 			equation = putSpaces(equation, false);
	// 		equation = equation.replaceAll(" _", "_");
//			equation = equation.replaceAll("+ "," + ");
//			equation = equation.replaceAll("- "," - ");
//			equation = equation.replaceAll("/ "," / ");
//			equation = equation.replaceAll("* "," * ");

		}
		int index = 0;
		String answer = solveExpression(equation);
		String numerator = "";
		String denominator = "";
		answer = answer.replaceAll(" ", "");
		answer += ' ';
		while (Character.isDigit(answer.charAt(index) )|| answer.charAt(index) == '-') {
			numerator += String.valueOf(answer.charAt(index));
			index++;
		}
		
		// check charAt(index) is an underscore

		if (answer.charAt(index) != '_') {
			System.err.println("1 Expected underscore, got " + answer.charAt(index));
			System.exit(0);
		}
		index++;

		while (Character.isDigit(answer.charAt(index))|| answer.charAt(index) == '-') {
			denominator += String.valueOf(answer.charAt(index));
			index++;
		}
		int denominator1 = Integer.parseInt(denominator);
		int numerator1 = Integer.parseInt(numerator);
		
		
		
		int remainderNumerator;
		int remainderDenominator;
		int integer;
		remainderDenominator = denominator1;
		remainderNumerator = numerator1 % denominator1;
		integer = (int)(numerator1 / denominator1);
		if (remainderNumerator == 0) {
			answer = Integer.toString(integer);
		}else {
			answer = integer + " " + remainderNumerator + "/" + remainderDenominator;
		}
		 
		System.out.println("Answer is " + answer);
	}// solves a parentheses

	public static boolean isIncorrectEquation(String equation) {
		for (int i = 0; i < equation.length(); i++) {
			if (Character.isDigit(equation.charAt(i)) == false && equation.charAt(i) != '.' && equation.charAt(i) != '-'
					&& equation.charAt(i) != '(' && equation.charAt(i) != ')' && equation.charAt(i) != '+'
					&& equation.charAt(i) != '*' && equation.charAt(i) != '/' && equation.charAt(i) != '^'
					&& equation.charAt(i) != 'E') {
				System.err.println("Some of these characters are wrong. Type another equation");
				return true;
			}
		}
		if (equation.length() - equation.replaceAll("(", "").length() != equation.length()
				- equation.replaceAll(")", "").length()) {
			System.err.println(
					"This equation has a parentheses that doesn't match up with another one. Type another  equation");
			return true;
		}

		return false;

	}

	public static String putSpaces(String equation, boolean addUnderscores) {
		boolean isOperation = true;
		int i = 0;

		equation = " " + equation;
		while (i < equation.length()) {
//				System.out.println("isOperation = " +isOperation);
			Character c = equation.charAt(i);
			if ((c.isDigit(equation.charAt(i)) == true || equation.charAt(i) == '-') && (isOperation == true)) {
				// System.out.println("Found beginning of number.");
				// System.out.println("Equation is " + equation);
				// System.out.println("Current character is " + equation.charAt(i));
				// System.out.println("End of number is at index " + endOfNumber(i, equation));
				int a = endOfNumber(i, equation);

				if (a == -1) {
					if (addUnderscores == true) {
						System.out.println("went in");
						equation += "_1";
					}
					equation += ' ';
					return equation;
				}
				
				if (addUnderscores == true) {
					equation = addChar(equation, "_1 ", a + 1);
					i = a+4;
				} else {
					equation = addChar(equation, " ", a + 1);
					i = a+2;
				}

//					if (equation.charAt(a + 2) == '(') {
//						addChar(equation, '*', a + 2);
//					}
//					System.out.println(equation);
				// System.out.println("New equation is " + equation);
				
				isOperation = false;
				continue;
			}

			if ((c == '-' || c == '^' || c == '/' || c == '*' || c == '+') && (isOperation == false)) {
				// System.out.println("Found operation.");
				// System.out.println("Equation is " + equation);
				// System.out.println("Current character is " + equation.charAt(i));
				equation = addChar(equation, " ", i + 1);
				// System.out.println("New equation is " + equation);
				i = i + 2;
				isOperation = true;
				continue;
			}

			if (c == '(' || c == ')') {
				// System.out.println("Found parentheses.");
				// System.out.println("Equation is " + equation);
				// System.out.println("Current character is " + equation.charAt(i));
				equation = addChar(equation, " ", i + 1);
				// System.out.println("New equation is " + equation);
				i += 2;
				continue;
			}
			i++;
		}

		return equation;
	}

	public static String solvesLastparentheses(String toSolve) {
		int openParenthesesIndex = -1;
		int closingParenthesesIndex = -1;
		for (int i = toSolve.length() - 1; i >= 0; i--) {
			if (toSolve.charAt(i) == '(') {
				openParenthesesIndex = i;
				break;
			}
		}
		if (openParenthesesIndex == -1) {
			return "Nothing";
		}
		for (int i = openParenthesesIndex + 1; i < toSolve.length(); i++) {
			if (toSolve.charAt(i) == ')') {
				closingParenthesesIndex = i;
				break;
			}
		}
		assert (closingParenthesesIndex >= -1) : "Mismatched parentheses";

		// System.out.println("openParanthesesIndex = " + openParenthesesIndex);
		// System.out.println("closingParanthesesIndex = " + closingParenthesesIndex);
		// toSolve = toSolve.replace("  ", " ");
		String expression = toSolve.substring(openParenthesesIndex + 1, closingParenthesesIndex);
		// toSolve = toSolve.replace("  ", " ");
		System.out.println("Now solving expression " + expression);
		String answer = solveExpression(expression);
		// System.out.println("Output of solveExpression is " + answer);
		toSolve = replace(openParenthesesIndex, closingParenthesesIndex, toSolve, answer);
		System.out.println("New equation is " + toSolve);
		return toSolve;
	}

	// solves expression without parentheses

	public static String solveExpression(String expression) {

		int indexOfOperator = -1;
		for (int i = 0; i < 3; i++) {
			String operator1 = "";
			String operator2 = "";
			if (i == 0) {
				operator1 = " ^ ";
				operator2 = " ^ ";
			} else if (i == 1) {
				operator2 = " / ";
				operator1 = " * ";
			} else if (i == 2) {
				operator1 = " + ";
				operator2 = " - ";
			}

			while (expression.indexOf(operator1) != -1 || expression.indexOf(operator2) != -1) {

				int Index = -1;
				if (expression.indexOf(operator1) == -1) {
					Index = expression.indexOf(operator2) + 1;
				} else if (expression.indexOf(operator2) == -1) {
					Index = expression.indexOf(operator1) + 1;
				} else {
					Index = expression.indexOf(operator1) < expression.indexOf(operator2)
							? expression.indexOf(operator1) + 1
							: expression.indexOf(operator2) + 1; // all the +1's are needed because operator1 and 2
																	// begin with a space
				}

				if (Index <= 0) {
					System.err.println("Index has to be bigger than 0 at this point");
					System.exit(-1);
				}

				int index1 = Index - 1;
				while (expression.charAt(index1) == ' ') {
					index1--;
				}
				index1 -=1;
				for (int j = index1; j >= 0; j--) {
					if (expression.charAt(j) == ' ') {
						index1 = j + 1;
						break;
					}
					index1 = 0;
				}
				int index2 = Index + 1;
				// how many before it is a number
				while (expression.charAt(index2) == ' ') {
					index2++;
				}
				index2+=1;
				for (int j = index2; j < expression.length(); j++) {

					if (expression.charAt(j) == ' ') {
						index2 = j - 1;
						break;
					}
					index2 = expression.length() - 1;
				}
				
				// System.out.println("i = " + i);
				// System.out.println("operator1 = " + operator1);
				// System.out.println("operator2 = " + operator2);
				// System.out.println("Index = " + Index);
				// System.out.println("index1 = " + index1);
				// System.out.println("index2 = " + index2);
				// System.out.println("Expression before input to solveOperation is " +
				// expression);
				System.out.println("        Now solving operation " + expression.substring(index1, index2 + 1));

				String answer = solveOperation(expression.substring(index1 , index2 + 1));
				// expression = expression.replace("  ", " ");

				System.out.println("Output of solveoperation is " + answer);
				expression = replace(index1 , index2, expression, answer);
				// expression = expression.replaceAll(" ", "");
				// expression = putSpaces(expression, false);
				//expression = expression.replaceAll(" _", "_");
//				expression = expression.replaceAll("+ "," + ");
//				expression = expression.replaceAll("- "," - ");
//				expression = expression.replaceAll("/ "," / ");
//				expression = expression.replaceAll("* "," * ");
				System.out.println("    New equation is " + expression);

			}
		}

		return expression;

	}

	int countCharInString(String str, char letter) {
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == letter) {
				counter++;
			}
		}
		return counter;
	}

	static String replace(int index1, int index2, String expression, String answer) {
		String expression2 = "";
		for (int i = 0; i < expression.length(); i++) {
			if (i == index1) {
				expression2 += answer;
				i = index2;
			} else {
				expression2 += expression.charAt(i);
			}
		}
		return expression2;
	}

	static String solveOperation(String toSolve) {
		toSolve += " ";
		String numerator1 = "", numerator2 = "", denominator1 = "", denominator2 = "";
		int index = 0;
		char operator;
		while (toSolve.charAt(index) == ' ') {
			index++;
		}

		while (Character.isDigit(toSolve.charAt(index) )|| toSolve.charAt(index) == '-') {
			numerator1 += String.valueOf(toSolve.charAt(index));
			index++;
		}

		// check charAt(index) is an underscore

		if (toSolve.charAt(index) != '_') {
			System.err.println("1 Expected underscore, got " + toSolve.charAt(index));
			System.exit(0);
		}
		index++;

		while (Character.isDigit(toSolve.charAt(index))|| toSolve.charAt(index) == '-') {
			denominator1 += String.valueOf(toSolve.charAt(index));
			index++;
		}
		while (toSolve.charAt(index) == ' ') {
			index++;
		}
		operator = toSolve.charAt(index);
		index++;

		while (toSolve.charAt(index) == ' ') {
			index++;
		}

		while (Character.isDigit(toSolve.charAt(index))|| toSolve.charAt(index) == '-') {
			numerator2 += String.valueOf(toSolve.charAt(index));
			index++;
		}

		if (toSolve.charAt(index) != '_') {
			System.err.println("2 Expected underscore, got " + toSolve.charAt(index));
			System.exit(0);
		}
		index++;
		while (Character.isDigit(toSolve.charAt(index))|| toSolve.charAt(index) == '-') {
			denominator2 += String.valueOf(toSolve.charAt(index));
			index++;
		}
//		System.out.println(operator + " is operator");
//		System.out.println(denominator1 + " is denominator1");
//		System.out.println(numerator1 + " is numerator1");
//		System.out.println(denominator2 + " is denominator2");
//		System.out.println(numerator2 + " is numerator2");
		int newnumerator1 = Integer.parseInt(numerator1);
		int newnumerator2 = Integer.parseInt(numerator2);
		int newdenominator1 = Integer.parseInt(denominator1);
		int newdenominator2 = Integer.parseInt(denominator2);

		if (operator == '+') {
			return " " + fractionAdd(newdenominator1, newdenominator2, newnumerator1, newnumerator2)[0] + "_"
					+ fractionAdd(newdenominator1, newdenominator2, newnumerator1, newnumerator2)[1] + " ";
		} else if (operator == '-') {
			return " " + fractionSub(newdenominator1, newdenominator2, newnumerator1, newnumerator2)[0] + "_"
					+ fractionSub(newdenominator1, newdenominator2, newnumerator1, newnumerator2)[1] + " ";

		} else if (operator == '*') {
			return " " + fractionMul(newdenominator1, newdenominator2, newnumerator1, newnumerator2)[0] + "_"
					+ fractionMul(newdenominator1, newdenominator2, newnumerator1, newnumerator2)[1] + " ";
		} else if (operator == '/') {
			return " " + fractionDiv(newdenominator1, newdenominator2, newnumerator1, newnumerator2)[0] + "_"
					+ fractionDiv(newdenominator1, newdenominator2, newnumerator1, newnumerator2)[1] + " ";
		} else if (operator == '^') {
			return " " + fractionPow(newdenominator1, newdenominator2, newnumerator1, newnumerator2)[0] + "_"
					+ fractionPow(newdenominator1, newdenominator2, newnumerator1, newnumerator2)[1] + " ";
		}

		return null;

	}

	public static String addChar(String str, String ch, int position) {
		return str.substring(0, position) + ch + str.substring(position);
	}

	public static int endOfNumber(int startIndex, String equation) {
		int endIndex = startIndex;
		Character e = equation.charAt(startIndex);
		if (equation.charAt(startIndex) != '-' && !e.isDigit(equation.charAt(startIndex))) {
			System.err.println("error");
			System.exit(0);
		}

		for (int i = startIndex; i < equation.length(); i++) {

			if (i == startIndex && equation.charAt(i) == '-') {
				endIndex++;
				continue;
			}
			if (Character.isDigit(equation.charAt(i)) || equation.charAt(i) == '.') {
				endIndex += 1;
				continue;
			}
			// System.out.println(endIndex);
			return endIndex - 1;
		}
		return -1;
	}

	public static int[] fractionMul(int denominator1, int denominator2, int numerator1, int numerator2) {
		int[] answer = { 0, 0 };
		answer[0] = numerator1 * numerator2;
		answer[1] = denominator1 * denominator2;
//		System.out.println("answer was ");
//		for (int i : answer) {
//			System.out.println(answer[i]);
//		}
		return fractionSimplification(answer[0], answer[1]);

	}

	public static int[] fractionDiv(int denominator1, int denominator2, int numerator1, int numerator2) {
		int[] answer = { 0, 0 };
		answer[0] = numerator1 * denominator2;
		answer[1] = denominator1 * numerator2;
//		System.out.println("answer was " );
//		for (int i = 0; i < answer.length; i++) {
//			System.out.println(answer[i]);
//		}
		return fractionSimplification(answer[0], answer[1]);

	}

	public static int[] fractionAdd(int denominator1, int denominator2, int numerator1, int numerator2) {
		int[] answer = { 0, 0 };
		int newNumerator1;
		int newNumerator2;
		answer[1] = denominator1 * denominator2;
		newNumerator1 = numerator1 * denominator2;
		newNumerator2 = denominator1 * numerator2;
		answer[0] = newNumerator1 + newNumerator2;
//		System.out.println("answer was ");
//		for (int i = 0; i < answer.length; i++) {
//			System.out.println(answer[i]);
//		}
		return fractionSimplification(answer[0], answer[1]);
	}

	public static int[] fractionSub(int denominator1, int denominator2, int numerator1, int numerator2) {
		int[] answer = { 0, 0 };
		int newNumerator1;
		int newNumerator2;
		answer[1] = denominator1 * denominator2;
		newNumerator1 = numerator1 * denominator2;
		newNumerator2 = denominator1 * numerator2;
		answer[0] = newNumerator1 - newNumerator2;
//		System.out.println("answer was ");
//		for (int i = 0; i < answer.length; i++) {
//			System.out.println(answer[i]);
//		}
		return fractionSimplification(answer[0], answer[1]);

	}

	public static int[] fractionPow(int denominator1, int denominator2, int numerator1, int numerator2) {
		int[] answer = { 0, 0 };
		if (denominator2 != 1) {
			System.err.println("fraction exponents are not aloud, please run again.");
			System.exit(0);
		}
		answer[0] = 1;
		answer[1] = 1;
		for (int i = 0; i < numerator2; i++) {
			answer[0] = answer[0] * numerator1;
			answer[1] = answer[1] * denominator1;
		}
//		System.out.println("answer is ");
//		for (int i = 0; i < answer.length; i++) {
//			System.out.println(answer[i]);
//		}
		return fractionSimplification(answer[0], answer[1]);

	}

	public static int[] fractionSimplification(int numerator, int denominator) {
		int[] simplified = { 0, 0 };
		ArrayList<Integer> numeratorFactors = new ArrayList<>();
		ArrayList<Integer> denominatorFactors = new ArrayList<>();
		for (int i = 1; i <= Math.abs(numerator); i++) {
			if (Math.abs(numerator) % i == 0) {
				numeratorFactors.add(i);
			}
		}
		for (int i = 1; i <= Math.abs(denominator); i++) {
			if (denominator % i == 0) {
				denominatorFactors.add(i);
			}
		}
		int gcfNumerator = 0;
		int gcfDenominator = 0;
		for (int i = 0; i < numeratorFactors.size(); i++) {
			if (denominatorFactors.contains(numeratorFactors.get(i))) {
				gcfNumerator = numeratorFactors.get(i);
			}
		}
		for (int i = 0 ; i < denominatorFactors.size(); i++) {
			if (numeratorFactors.contains(denominatorFactors.get(i))) {
				gcfDenominator = denominatorFactors.get(i);
			}
		}
		if (gcfNumerator > gcfDenominator) {
			simplified[0] = numerator / gcfNumerator;
			simplified[1] = denominator / gcfNumerator;
		} else {
			simplified[0] = numerator / gcfDenominator;
			simplified[1] = denominator / gcfDenominator;
		}
		return simplified;
	}
}
