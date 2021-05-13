import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Fabochini_sequence {
	public static void main(String[] args) {
		boolean doesContinue = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Fibonacci sequence");
		System.out.println("What number in the fibonacci sequence do you want?");
		 
		
		double number = scan.nextInt();
	//	ArrayList <Double> list = new ArrayList();
	//	for (int i = 0; i < number ; i++) {
	//		list.add((double) 0);
	//	}list.set(1,  (double) 1);

		BigInteger var2 = new BigInteger("0"); // (i-2)th entry
		
		BigInteger var = new BigInteger("1"); // (i-1)th entry
		
		
		for (int i = 2; i < number; i++) {
			// double var = list.get(i  - 1);
			// double var2 = list.get(i - 2);
			// list.set(i, var + var2) ;
			
			BigInteger newEntry = new BigInteger("1");
			newEntry = var.add(var2);//i'th entry
			var2 = var; //set things up for the next value of i, var2 now contains (i-2)th entry for new i
			var = newEntry; // set things up for the next value of i, var now contains (i-1)th entry for new i
		}
		
		
		System.out.println(var);
		System.out.println("Scientific notation");
		System.out.println(var.doubleValue());
	}}

	

	

