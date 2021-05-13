package zebra.section4;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class FortuneTeller {
	public static void main(String[] args) {

		String set = "none";
		String animal = null;
		String[] colors = { "Blue", "Yellow", "Lime", "Gray", "Green", "Orange", "Pink", "White" };

		String[] animals = { "whale or dolphin", "girrafe or puffer fish", "snake or frog", "dolphin or walrus",
				"parakeet or sloth", "tiger or fox", "flamingos or pig", "penguins or polarbears" };

		String[] animals2 = { "whale", "dolphin", "girrafe", "puffer fish", "snake", "frog", "dolphin", "walrus",
				"parakeet", "sloth", "tiger", "fox", "flamingos", "pig", "penguins", "polarbears" };

		String[] fortunes = { "A faithful friend will defend you in your most trouble",
				"A golden egg of opportunity falls into your lap this month",
				"A lifetime of happiness lies ahead of you", "A soft voice may be awfully persuasive",
				"A friend will ask only for your time not your money", "A new perspective will come with the new year",
				"A dubious friend may be an enemy in camouflage", "Determination is what you need now",
				"A fresh start will put you on your way", "A chance meeting opens new doors to success and friendship",
				"Your shoes will make you happy today", "You will marry your lover",
				"every choice you make tomorow is a good one", "A dream you have will come true",
				"you will get stung by a snake and go to the hospital", "serious trouble will bypass you" };

		while (set.equals("none")) {
			set = askForNumber();
		}

		int index = findIndex(colors, set);
		System.out.println(index);
		animal = JOptionPane.showInputDialog("pick an animal " + animals[index]);
		index = findIndex(animals2, animal);
		JOptionPane.showMessageDialog(null, fortunes[index]);
	}

	static int findIndex(String[] array, String value) {
		int index = -1;

		for (int i = 0; i < array.length; i++) {

			if (array[i].equalsIgnoreCase(value)) {
				index = i;
			}
		}
		return index;

	}

	static String askForNumber() {
		String set = "none";
		int favoriteNumber = Integer.parseInt(JOptionPane.showInputDialog("Pick a number from 1 to 10."));
		if (favoriteNumber > 0 && favoriteNumber <= 10) {

			if (favoriteNumber % 2 == 0) {
				// set = JOptionPane.showInputDialog("Pick one of the following colors: Blue,
				// Yellow, Lime, Gray");
				while (set.equals("none")) {
					set = askForColor(set, " Blue, Yellow, Lime, Gray");
				}
				
			} else {
				while (set.equals("none")) {
					set = askForColor(set, " Green, Orange, Pink, White");
				}
				// set = JOptionPane.showInputDialog("Pick one of the following colors: Green,
				// Orange, Pink, White");
			}
		} else {
			JOptionPane.showMessageDialog(null, "This number isn't between 1 and 10");
		}
		return set;
	};

	static String askForColor(String set, String options) {
		set = JOptionPane.showInputDialog("Pick one of the following colors" + options);
		if (options.toLowerCase().contains(set)) {
			return set;
		}
		return "none";
	}

}
