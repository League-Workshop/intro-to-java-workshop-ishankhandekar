package section4;

import java.util.Random;

import javax.swing.JOptionPane;

public class AwesomeOrNot {

	// 1. Make a main method that includes all the steps below…
	public static void main(String[] args) {
		
	

	// 2. Make a variable that will hold a random number and put a random number 
	//into this variable using "new Random().nextInt(4)"
		Random thisRandom = new Random();
		int thisRandomjr = thisRandom.nextInt(4);
	// 3. Print out this variable
		System.out.println(thisRandomjr);

	// 4. Get the user to enter something that they think is awesome
		String awsome = JOptionPane.showInputDialog("Enter something you think is awsome");
	// 5. If the random number is 0
		if (thisRandomjr == 0) {
			JOptionPane.showMessageDialog(null, "This is awsome");
		}

	// -- tell the user whatever they entered is awesome!

	// 6. If the random number is 1
		if (thisRandomjr == 1) {
			JOptionPane.showMessageDialog(null, "This is ok");
		}

	// -- tell the user whatever they entered is ok.
		if (thisRandomjr == 2) {
			JOptionPane.showMessageDialog(null, "This is boring");
		}

	// 7. If the random number is 2

	// -- tell the user whatever they entered is boring.

	// 8. If the random number is 3
		if (thisRandomjr == 3) {
			JOptionPane.showMessageDialog(null, "I don't like you");
		}

	// -- write your own answer
	}
}


