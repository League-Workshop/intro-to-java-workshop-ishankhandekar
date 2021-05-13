
import javax.swing.JOptionPane;

public class PalindromeDetector {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Welcome to the palindrome dectector");
		JOptionPane.showMessageDialog(null, "It sees if words are the same when they are spelled backwards");
		String word = JOptionPane.showInputDialog("What is your word");
		String backwards = makeBackwards(word);
		if (word.equals(backwards)) {
			JOptionPane.showMessageDialog(null, word + " is a palindrome");
		} else {
			JOptionPane.showMessageDialog(null, word + " is not a palindrome");
		}

	}

	static String makeBackwards(String word) {
		String toReturn = "";
		for (int i = word.length(); i > 0; i--) {
			toReturn += "" + word.charAt(i - 1);
		}
		return toReturn;
	}

}
