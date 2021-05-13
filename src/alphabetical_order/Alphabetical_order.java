/*
 * This program alphabetically sorts the input values from user in a dictionary like format
 */

package alphabetical_order;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import fortuneTeller.FortuneTeller;

public class Alphabetical_order {
	static char letters[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	static char letters2[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ' };

	public void run() {

		ArrayList<String> words = new ArrayList<String>();
		int duplicates = JOptionPane.showConfirmDialog(null, "Do you want the program to allow duplicates or not?");
		boolean dups = true;
		if (duplicates == 1) {
			dups = false;
		}
		if (duplicates == 2) {
			System.exit(0);
		}

		// call function to prompt user to get
		int numberOfWords = getInt("How many words do you want?");
//		boolean hi = false;
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < numberOfWords; i++) {

			String input2 = null;
			boolean isValid = true;
			do {
				
				if (i + 1 == 1) {
					if (isValid == false) {
						ArrayList <String> whatWrong = whatIsWrong(input2, words, dups);
						for (int j = 0; j < whatWrong.size() - 1; j++) {
							if (!whatWrong.get(j).equalsIgnoreCase("Nothing")) {
								System.out.println(whatWrong.get(j));
							}
						}
					}
					System.out.println("What do you want your " + (i + 1) + "st word to be");
				} else if (i + 1 == 2) {
					System.out.println("What do you want your " + (i + 1) + "nd word to be");
				} else if (i + 1 == 3) {
					System.out.println("What do you want your " + (i + 1) + "rd word to be");
				} else {
					System.out.println("What do you want your " + (i + 1) + "th word to be");
				}
				input2 = scan.nextLine();
				if (userInputIsValid(input2,words,dups)) {
					isValid = false;
				}else {
					isValid = true;
				}}
			 while (userInputIsValid(input2, words, dups));
			
			words.add(input2);
			
//			boolean standered = true;
//			ArrayList<Boolean> wordList = new ArrayList<Boolean>();
		} // Changed variable hello to wordList to make is more meaningful

//			if (dups == false) {
//				for (int j = 0; j < words.size(); j++) {
//					boolean hello = false;
//					if (words.get(j).equals(input2) && hello == false) {
//						
//						System.out.println("This is a duplicate. Try again");
//						
//						hello = true;
//						hi = true;
//					}
//				}
//			}
//			
//			
//			
//			for (int j = 0; j < input2.length(); j++) {
//				
//				standered = true;
//				for (int j2 = 0; j2 < letters2.length; j2++) {
//					boolean letterStandard = true;
//					if (input2.charAt(j) != letters2[j2]) {
//						letterStandard = false;
//						
//						wordList.add(letterStandard);
//					}else {
//						letterStandard = true;
//						wordList.add(letterStandard);
//					}
//					
//				}
//			}
//			
//			int howManyTrues = 0;
//			for (int j = 0; j < wordList.size(); j++) {
//				boolean hello2 = wordList.get(j); 
//				if (hello2 == true) {
//					howManyTrues ++ ;
//				}
//			}
//			if (howManyTrues == input2.length()) {
//				standered = true;
//			}else {
//				standered = false;
//			}
//			if (standered == false) {
//				System.out.println("please do not put special characters in the word. Try again");
//				i= i - 1;
//				
//			}else if (standered == true){
//				
//				words.add(input2);
//				
//			}
//		}	
//
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
		for (int j = 0; j < words2.size(); j++) {
			for (int i = 0; i < words2.size() - 1; i++) {
			}

		}

		System.out.println(words2);
	}

//		

	public boolean userInputIsValid(String word, ArrayList<String> words, boolean allowDups) {
		int howManyTrues = 0;
		boolean toReturn = false;
		ArrayList<String> returnThis = new ArrayList<String>();
		ArrayList<Boolean> wordEqualsLetter = new ArrayList<Boolean>();
		for (int i = 0; i < word.length() - 1; i++) {
			for (int j = 0; j < letters2.length; j++) {
				if (word.charAt(i) == letters2[j]) {
					wordEqualsLetter.add(true);
				}
			}
		}
		for (int i = 0; i < wordEqualsLetter.size() -1; i++) {
			if (wordEqualsLetter.get(i) == true) {
				howManyTrues++;
			}
		}
		if (howManyTrues == word.length()) {
			returnThis.add("Please do not put any special characters. Try again");
			toReturn = true;
		} else {
			returnThis.add("Nothing");
		}
		if (allowDups == false) {
			for (int i = 0; i < words.size() - 1; i++) {
				if (word == words.get(i)) {
					returnThis.add("This is a duplicate. Try Again");
					toReturn = true;
					break;
				} else {
					returnThis.add("Nothing");
				}
			}
		}
		return toReturn;

	}public ArrayList<String> whatIsWrong(String word, ArrayList<String> words, boolean allowDups) {
		int howManyTrues = 0;
		
		ArrayList<String> returnThis = new ArrayList<String>();
		ArrayList<Boolean> wordEqualsLetter = new ArrayList<Boolean>();
		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; j < letters2.length; j++) {
				if (word.charAt(i) == letters2[j]) {
					wordEqualsLetter.add(true);
				}
			}
		}
		for (int i = 0; i < wordEqualsLetter.size(); i++) {
			if (wordEqualsLetter.get(i) == true) {
				howManyTrues++;
			}
		}
		if (howManyTrues == word.length()) {
			returnThis.add("Please do not put any special characters. Try again");
			
		} else {
			returnThis.add("Nothing");
		}
		if (allowDups == false) {
			for (int i = 0; i < words.size(); i++) {
				if (word == words.get(i)) {
					returnThis.add("This is a duplicate. Try Again");
					
					break;
				} else {
					returnThis.add("Nothing");
				}
			}}
		return returnThis;}

	// This function does what?

	public boolean stringLessThan(String string1, String string2) {

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

	// This function prompts user for a number and loops till a number is entered
	public int getInt(String prompt) {
		Scanner sc = new Scanner(System.in);
		System.out.print(prompt);
		while (!sc.hasNextInt()) {
			System.out.println("This is not a Integer. Try again");
			sc.next();
		}
		return sc.nextInt();

	}
}
