import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Number_Sorter {
	public static void main(String[] args) {

		int one = 0;
		int two = 0;
		int[] array = { 7, 12, 30, 20, 39, 27, 7 };
		ArrayList<Integer> Array2 = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			Array2.add(array[i]);
		}

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
		System.out.println(Array2.toString());
	}

}
