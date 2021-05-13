package fortuneTeller;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class FortuneTeller {
	public void run() {

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
				"Every choice you make tomorow is a good one", "Your resemblence to the muppet will prevent anyone from taking you seriously",
				"You will die alone while poorly dressed", "Serious trouble will bypass you" };

		set = askForNumber();

		int index = findIndex(colors, set);
		int index2 = (index + 1) * 2 - 1;
		String[] Options1 = { animals2[index2], animals2[index2 - 1] };
		int AnimalIndex = JOptionPane.showOptionDialog(null, "Pick an animal", "Fortune Teller",
				JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, Options1, 0);
		if (AnimalIndex == 0) {
			animal = animals2[index2];
		} else if (AnimalIndex == 1) {
			animal = animals2[index2 - 1];
		}
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
		String finalColor = "none";
		String[] Options = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };	
			 int favoriteNumber = JOptionPane.showOptionDialog(null, "Pick a number from one to ten", "Fortune Teller",
						JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, Options, 0) + 1;

		if (favoriteNumber % 2 == 0) {
			String[] Options1 = { "Blue", "Yellow", "Lime", "Gray" };
			finalColor = askForColor(finalColor, Options1);
		} else {

			String[] Options1 = { "Green", "Orange", "Pink", "White" };
			finalColor = askForColor(finalColor, Options1);

		}

		return finalColor;
	};

	static String askForColor(String set, String[] options) {

		int colorIndex = JOptionPane.showOptionDialog(null, "Pick a color", "Fortune Teller",
				JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
		if (colorIndex == 0) {
			set = options[0];
		} else if (colorIndex == 1) {
			set = options[1];
		} else if (colorIndex == 2) {
			set = options[2];
		} else if (colorIndex == 3) {
			set = options[3];
		}
		return set;
	}

}
