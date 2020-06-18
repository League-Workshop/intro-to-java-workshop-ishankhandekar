package section3;

import javax.swing.JOptionPane;

public class WorldDomination {
	
	public static void main(String[] args) {
		// 1. Ask the user if they know how to write code.
		String writeCode = JOptionPane.showInputDialog("Do you know how to wright code?");
		// 2. If they say "yes", tell them they will rule the world.
		if( writeCode.equals("yes") ) {
			JOptionPane.showMessageDialog(null, "You will rule the world");
		}else {
		JOptionPane.showMessageDialog(null, "YOU DON'T KNOW HOW TO CODE!!!!!!!!!!!!!!!!! THEN YOU HAVE TO TAKE CLASSES AT THE LEAGUE!");	
		}
		// 3. Otherwise, tell them take classes at the League.

	}
}

