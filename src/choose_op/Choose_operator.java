package choose_op;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Choose_operator {
	public void run() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the choose operator");
		System.out.println("What do you want your number to be?");
		String n = scan.nextLine();
		System.out.println("How many numbers do you want Select?");
		String k = scan.nextLine();
		double n2 = Double.parseDouble(n);
		double k2 = Double.parseDouble(k);
		choose(n2,k2);}
		
	public void choose(double n2, double k2) {
		
		if (n2 < k2) {
			System.out.println(n2 + " choose " + k2 + " = 0");
		}
		double nFactorial = Factorial(n2);
		double kFactorial = Factorial(k2);
		double secondPart = Factorial(n2 - k2);
		double divition = kFactorial * secondPart;
		double divition2 = nFactorial / divition;
		
		System.out.println(n2 + " choose " + k2 + " = " + divition2);
	
	}
	public double Factorial(double input) {
		double answer = 0;
		answer = input;
		for (int i = 2; i < input; i++) {
			answer = answer * i;
		}
		
		return answer;
	}
}
