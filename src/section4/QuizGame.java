package section4;

import java.util.Random;

import javax.swing.JOptionPane;

public class QuizGame {
	
	public static void main(String[] args) {
		
		// 1.  Create a variable to hold the user's score 
		int score = 0;
		// 2.  Ask the user a question 
		Random randy = new Random();
		int num1 = randy.nextInt(8);
		int num2 = randy.nextInt(8);
		int num3 = randy.nextInt(8);
		int num4 = randy.nextInt(8);
		if(num1 == 0) {
			String question1 = JOptionPane.showInputDialog("True or False. Mammals don't lay eggs");
		}
		if(num2 == 1) {
			String question2 = JOptionPane.showInputDialog("True or False. A triangle has four sides");
			if(num2 == 2) {
			String question3 = JOptionPane.showInputDialog("True or False. A howaiian pizza has pinapple toppings");
			}
			if(num2 == 3) {
				String question4 = JOptionPane.showInputDialog("True or False. Your liver pumps blood around your body");
			}
		String question1 = JOptionPane.showInputDialog("True or False. Mammals don't lay eggs");
		String question2 = JOptionPane.showInputDialog("True or False. A triangle has four sides");
		String question3 = JOptionPane.showInputDialog("True or False. A howaiian pizza has pinapple toppings");
		String question4 = JOptionPane.showInputDialog("True or False. Your liver pumps blood around your body");
		String question5 = JOptionPane.showInputDialog("True or False. White is a mixure of all colors");
		String question6 = JOptionPane.showInputDialog("True or False. 10 x 10 = 100");
		String question7 = JOptionPane.showInputDialog("True or False. snow white has 8 dwarfs");
		String question8 = JOptionPane.showInputDialog("True or False. When there is a earthquake happens, the ground starts shaking");
		// 3.  Use an if statement to check if their answer is correct
		if (question1.equals("true")) {
			JOptionPane.showMessageDialog(null, "Correct");
			score = score + 1;
		}else {
			JOptionPane.showMessageDialog(null, "Incorrect");
		}
		//
		if (question2.equals("true")) {
			JOptionPane.showMessageDialog(null, "Incorrect");
		}else {
			JOptionPane.showMessageDialog(null, "Correct");
			score = score + 1;
		}
		//
		if (question3.equals("true")) {
			JOptionPane.showMessageDialog(null, "Correct");
			score = score + 1;
		}else {
			JOptionPane.showMessageDialog(null, "Incorrect");
		}
		//
		if (question4.equals("true")) {
			JOptionPane.showMessageDialog(null, "Incorrect");
		}else {
			JOptionPane.showMessageDialog(null, "Incorrect");
			score = score + 1;
		}
		//
		if (question5.equals("true")) {
		JOptionPane.showMessageDialog(null, "Correct");
		score = score + 1;
	}else {
		JOptionPane.showMessageDialog(null, "Incorrect");
	}
	//
	if (question6.equals("true")) {
		JOptionPane.showMessageDialog(null, "Correct");
		score = score + 1;
	}else {
		JOptionPane.showMessageDialog(null, "Incorrect");
	}
	if (question7.equals("true")) {
		JOptionPane.showMessageDialog(null, "Incorrect");
	}else {
		JOptionPane.showMessageDialog(null, "Incorrect");
		score = score + 1;
	}
	if (question8.equals("true")) {
		JOptionPane.showMessageDialog(null, "Correct");
		score = score + 1;
	}else {
		JOptionPane.showMessageDialog(null, "Incorrect");
	}
		// 4.  if the user's answer was correct, add one to their score 
		
		// 5.  Create more questions by repeating steps 1, 2, and 3 below. 
		
		// 6.  After all the questions have been asked, print the user's score 
		
	}
}
