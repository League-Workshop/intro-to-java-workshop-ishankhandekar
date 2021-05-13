package section4;

import java.util.Random;

import javax.swing.JOptionPane;

public class QuizGame {


	public static void main(String[] args) {
		
		// 1.  Create a variable to hold the user's score 
		int score = 0;
		// 2.  Ask the user a question
		int randomNumbers[0,0,0,0];
		String question1 = null;
		String question2 = null;
		String question3 = null;
		String question4 = null;
		String question5 = null;
		String question6 = null;
		String question7 = null;
		String question8 = null;
		

		for (int i = 0; i < 4; i++) {
			
		
		Random randy = new Random();
		int randomNumber = randy.nextInt(8);
		
		System.out.println("Random number " + randomNumber );
		
		
		
		// joption -- ? will you win 1000000
		if(randomNumber == 0) {
			question1 = JOptionPane.showInputDialog("True or False. Mammals don't lay eggs");
			
			if (question1.equals("true")) {
				JOptionPane.showMessageDialog(null, "Correct");
				score = score + 1;
			}else {
				JOptionPane.showMessageDialog(null, "Incorrect");
			}
			
		} else if(randomNumber == 1) {
			question2 = JOptionPane.showInputDialog("True or False. A triangle has four sides");
			if (question2.equals("true")) {
				JOptionPane.showMessageDialog(null, "Incorrect");
				
			}else {
				JOptionPane.showMessageDialog(null, "Correct");
				score = score + 1;
			}
			
			
		} else if(randomNumber == 2) {
			question3 = JOptionPane.showInputDialog("True or False. A howaiian pizza has pinapple toppings");
			if (question3.equals("true")) {
				JOptionPane.showMessageDialog(null, "Correct");
				score = score + 1;
			}else {
				JOptionPane.showMessageDialog(null, "Incorrect");
			}
			
			
		} else if(randomNumber == 3) {
			question4 = JOptionPane.showInputDialog("True or False. Your liver pumps blood around your body");
			if (question4.equals("true")) {
				JOptionPane.showMessageDialog(null, "Incorrect");
			}else {
				JOptionPane.showMessageDialog(null, "Incorrect");
				score = score + 1;
			}
			
		} else if(randomNumber == 4) {
			question5 = JOptionPane.showInputDialog("True or False. White is a mixure of all colors");
			if (question5.equals("true")) {
				JOptionPane.showMessageDialog(null, "Correct");
				score = score + 1;
			}else {
				JOptionPane.showMessageDialog(null, "Incorrect");
			}
			
		} else if(randomNumber == 5) {
			question6 = JOptionPane.showInputDialog("True or False. 10 x 10 = 100");
			if (question6.equals("true")) {
				JOptionPane.showMessageDialog(null, "Correct");
				score = score + 1;
			}else {
				JOptionPane.showMessageDialog(null, "Incorrect");
			}
			
		} else if(randomNumber == 6) {
			question7 = JOptionPane.showInputDialog("True or False. snow white has 8 dwarfs");
			if (question7.equals("true")) {
				JOptionPane.showMessageDialog(null, "Incorrect");
			}else {
				JOptionPane.showMessageDialog(null, "Incorrect");
				score = score + 1;
			}
			
		} else if(randomNumber == 7) {
			question8 = JOptionPane.showInputDialog("True or False. When there is a earthquake happens, the ground starts shaking");
			if (question8.equals("true")) {
				JOptionPane.showMessageDialog(null, "Correct");
				score = score + 1;
			}else {
				JOptionPane.showMessageDialog(null, "Incorrect");
			}
		}
		
		
		}
		
		JOptionPane.showMessageDialog(null, "congratulations, you got " + score + "/4!");
			
			
		
		
		
		
				

		
		

		
//		
//		
//		if(num1 == 0) {
//			question1 = JOptionPane.showInputDialog("True or False. Mammals don't lay eggs");
//		}
//		if(num2 >= 1 && num2 <= 8 ) {
//			question2 = JOptionPane.showInputDialog("True or False. A triangle has four sides");
//			if(num2 == 2) {
//			question3 = JOptionPane.showInputDialog("True or False. A howaiian pizza has pinapple toppings");
//			}
//			if(num3 == 3) {
//				question4 = JOptionPane.showInputDialog("True or False. Your liver pumps blood around your body");
//			}
//		}
//		
//		
//		question5 = JOptionPane.showInputDialog("True or False. White is a mixure of all colors");
//		question6 = JOptionPane.showInputDialog("True or False. 10 x 10 = 100");
//		question7 = JOptionPane.showInputDialog("True or False. snow white has 8 dwarfs");
//		question8 = JOptionPane.showInputDialog("True or False. When there is a earthquake happens, the ground starts shaking");
//		// 3.  Use an if statement to check if their answer is correct

		//
		
		//
		
		//
		
		//
		
	//
	
	
	
//		// 4.  if the user's answer was correct, add one to their score 
//		
//		// 5.  Create more questions by repeating steps 1, 2, and 3 below. 
//		
//		// 6.  After all the questions have been asked, print the user's score 
	
	
//	
		
	}
}
