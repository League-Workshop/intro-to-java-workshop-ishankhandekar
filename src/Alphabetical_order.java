
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import fortuneTeller.FortuneTeller;

public class Alphabetical_order {
	static char letters[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	static char letters2[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
	public static void main(String[] args) {
		 
		ArrayList<String> words = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		System.out.println("how many words do you want?");
		int input = scan.nextInt();
		for (int i = 0; i < input; i++) {
			boolean standered = true;
			ArrayList<Boolean> hello= new ArrayList<Boolean>();
			System.out.println("What do you want your " + (i + 1) + "th word to be");
			String input2 = scan.next();
			
			
			for (int j = 0; j < input2.length(); j++) {
				
				standered = true;
				for (int j2 = 0; j2 < letters2.length; j2++) {
					boolean letterStandard = true;
					if (input2.charAt(j) != letters2[j2]) {
						letterStandard = false;
						
						hello.add(letterStandard);
					}else {
						letterStandard = true;
						hello.add(letterStandard);
					}
					
				}
			}
			int howManyTrues = 0;
			for (int j = 0; j < hello.size(); j++) {
				boolean hello2 = hello.get(j); 
				if (hello2 == true) {
					howManyTrues ++ ;
				}
			}
			if (howManyTrues == input2.length()) {
				standered = true;
			}else {
				standered = false;
			}
			if (standered == false) {
				System.out.println("please do not put special characters in the word. Try again");
				i= i - 1;
				
			}else if (standered == true){
				
				words.add(input2);
				
			}
			
		}

		for (int j = 0; j < words.size(); j++) {
			for (int i = 0; i < words.size() - 1; i++) {
				String string1 = words.get(i);
				String string2 = words.get(i + 1);
				if (stringLessThan(string1, string2)) {
					words.set(i, string2);
					words.set(i + 1, string1);
				}
			}
		}
		ArrayList<String> words2 = new ArrayList<String>();
		for (int i = words.size() - 1; i >= 0; i--) {
			words2.add(words.get(i));
		}
		System.out.println(words2);
		

	}

	public static boolean stringLessThan(String string1, String string2) {

		int j = 0;
		if (string1.length() < string2.length()) {
			j = string1.length();
		} else if (string2.length() < string1.length()) {
			j = string2.length();
		} else {
			j = string1.length();
		}
		for (int i = 0; i < j; i++) {
			int f = 0;
			int k = 0;
			for (int q = 0; q < letters.length; q++) {

				if (letters[q] == string1.charAt(i)) {
					f = q;
				}

			}
			for (int q = 0; q < letters.length; q++) {

				if (letters[q] == string2.charAt(i)) {
					k = q;
				}

			}
			if (f != k) {
				if (f > k) {
					return false;
				} else {
					return true;
				}
			}
		}
		if (string1 == string2) {
			return false;
		}
		return true;
	}
}
