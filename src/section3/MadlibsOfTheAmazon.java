package section3;

import javax.swing.JOptionPane;

public class MadlibsOfTheAmazon {
	
	public static void main(String[] args) {
		// Put this sentence in a pop up:
		JOptionPane.showMessageDialog(null, "If you find yourself having to cross a piranha-infested river, here's how to do it...");
		// If you find yourself having to cross a piranha-infested river, here's how to do it...
		
		// Get the user to enter an adjective
		String adjective = JOptionPane.showInputDialog("Name an adgective");

		// Get the user to enter a type of liquid
		String liquid = JOptionPane.showInputDialog("Name a luquid");

		// Get the user to enter a body part
		String bodyPart = JOptionPane.showInputDialog("Name a part of your body");

		// Get the user to enter a verb
		String verb =JOptionPane.showInputDialog("Name a verb");
		String place =JOptionPane.showInputDialog("Name a place");

		// Get the user to enter a place
		JOptionPane.showMessageDialog(null, "Piranhas are more " + adjective + " during the day,\n"+
		 " so cross the river at night. Piranahas are attracted to fresh " + liquid + " and will most likely\n"+
		" take a bite out of your " + bodyPart + " if your " + verb + ".Whatever you do, if you have an\n" +
		 " open wound, try to find another way to get back to the " + place + ". Good luck!");
				
		
		

	}
}

