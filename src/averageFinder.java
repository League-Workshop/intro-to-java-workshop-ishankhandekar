import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

import com.sun.speech.freetts.cart.Intonator;

public class averageFinder {
//	 mean = average of the set of numbers
//			 median = the middle number
//			 mode = the most frequent number
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] whichAverage = { "mean", "median", "mode" };
		int choice = JOptionPane.showOptionDialog(null, "Which average do you want", "Average finder",
				JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, whichAverage, 0);

		if (choice == 0) {
			ArrayList<Double> allNumbers = new ArrayList<Double>();
			System.out.println("How many numbers do you want?");
			int numbers = scan.nextInt();
			for (int i = 0; i < numbers; i++) {
				System.out.println("what is your " + (i + 1) + "th mean number");
				allNumbers.add(scan.nextDouble());
			}
			double addition = 0;
			for (int i = 0; i < allNumbers.size(); i++) {
				addition += allNumbers.get(i);
			}
			System.out.println("answer is " + (addition / numbers));

		}
		if (choice == 1) {
			ArrayList<Double> allNumbers = new ArrayList<Double>();
			
			System.out.println("How many numbers do you want?");
			int numbers = scan.nextInt();
			for (int i = 0; i < numbers; i++) {
				System.out.println("what is your " + (i + 1) + "th median number");
				allNumbers.add(scan.nextDouble());
			}
			allNumbers = NumberSort(allNumbers);
			if ((allNumbers.size()) % 2 == 0) {
				Double median1 = allNumbers.get((allNumbers.size()) / 2 - 1);
				Double median2 = allNumbers.get((allNumbers.size()) / 2);
				System.out.println("median of this is " + ((median1 + median2) / 2));
			} else {
				System.out.println("median of this is " + allNumbers.get(Math.round(allNumbers.size() / 2)));
			}

		}
		if (choice == 2) {
			ArrayList<Double> allNumbers = new ArrayList<Double>();
			System.out.println("How many numbers do you want?");
			int numbers = scan.nextInt();
			for (int i = 0; i < numbers; i++) {
				System.out.println("what is your " + (i + 1) + "th mode number");
				allNumbers.add(scan.nextDouble());
			}
			ArrayList<Integer> numberOfNumbers = new ArrayList<Integer>();

			for (int i = 0; i < allNumbers.size(); i++) {
				numberOfNumbers.add(Count(allNumbers, allNumbers.get(i)));
			}
			double biggestNumber = biggestNumber(numberOfNumbers);
			ArrayList<Double> modes = new ArrayList<Double>();
			for (int i = 0; i < numberOfNumbers.size(); i++) {
				if (numberOfNumbers.get(i) == biggestNumber) {
					modes.add(allNumbers.get(i));
				}
			}
			Set<Double> modeWithoutDups = new HashSet();
			for (int i = 0; i < modes.size(); i++) {
				modeWithoutDups.add(modes.get(i));
			}
			System.out.print("The mode's are ");
			for (int i = 0; i < modeWithoutDups.size(); i++) {
				List<Double> list = new ArrayList<Double>(modeWithoutDups);
				System.out.print(list.get(i));
				if (i != list.size() - 1) {
					System.out.print(", ");
				}
			}
		}
	}

	static ArrayList<Double> NumberSort(ArrayList<Double> Array2) {
		Object[] array = Array2.toArray();
		double one = 0;
		double two = 0;
		for (int j = 0; j < array.length; j++) {
			for (int i = 0; i < array.length - 1; i++) {
				if (Array2.get(i) > Array2.get(i + 1)) {
					one = Array2.get(i);
					two = Array2.get(i + 1);
					Array2.set(i, two);
					Array2.set(i + 1, one);
				}
			}
		}
		return Array2;

	}

	static int Count(ArrayList<Double> Array2, double number) {
		int count = 0;
		for (int i = 0; i < Array2.size(); i++) {
			if (Array2.get(i) == number) {
				count++;
			}
		}
		return count;

	}

	static double biggestNumber(ArrayList<Integer> arr) {
		int currentNumber;
		int biggestNumber = arr.get(0);
		for (int i = 0; i < arr.size(); i++) {
			currentNumber = arr.get(i);
			if (currentNumber > biggestNumber) {
				biggestNumber = currentNumber;
			}
		}
		return biggestNumber;
	}

	static ArrayList<Double> removeDuplicates(ArrayList<Double> array) {
		for (int i = 0; i < array.size(); i++) {

		}
		return array;
	}
}
