import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prime_factorization {
	public static void main(String[] args) {

		
Scanner scan = new Scanner(System.in);
System.out.println("What do you want to prime factorize?");
String inputString = scan.nextLine();
		
		long input = Long.parseLong(inputString);
		boolean isDone = false;
		List<Long> prime = new ArrayList<Long>();
		 
		
		while (isDone == false) {
			long PrimeAnswer3[] = firstPrime(input);
			for (long i = 0; i < PrimeAnswer3.length; i++) {
				prime.add(PrimeAnswer3[(int) i]);
			}
			if (isPrime(PrimeAnswer3[1]) == true) {
				for (int i = 0; i < prime.size(); i++) {
					if (isPrime(prime.get(i)) == false) {
						prime.remove(i);
					}
				}
				System.out.println("The prime factorization of " + inputString + " is " + prime + ".");
				isDone = true;
			}else {
				input = PrimeAnswer3[1];
			}
			
		}
	}



	public static long[] firstPrime(long input) {
		long[] firstPrime2 = { 0, 0 };
		for (int i = 2; i < input; i++) {
			if (isPrime(i) == true) {
				if (input % i == 0) {
					firstPrime2[0] = i;
					firstPrime2[1] = input / i;
					return firstPrime2;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "your a bad boy, you put in a prime number");
		System.exit(0);
		return firstPrime2;
	}

	public static boolean isPrime(long input) {
		for (int i = 2; i < input; i++) {

			if (input % i == 0) {
				// not prime
				return false;
			}
		}
		return true;
	}

	
}
