package section2;

import javax.swing.JOptionPane;
import org.jointheleague.graphical.robot.Robot;

public class FourSquare {
	
	Robot badboy = new Robot();

	void go() {
		badboy.setSpeed(100);

		badboy.setPenWidth(5);
		badboy.penDown();

		for (int i = 0; i < 4; i++) {
			
		

			badboy.setRandomPenColor();
	
			drawSquare();
			badboy.turn(90);
	}}

	
	void drawSquare() {
		JOptionPane.showMessageDialog(null, "yay! you called the drawSquare() method!");
	for (int i = 0; i < 4; i++) {
		badboy.move(50);
		
		badboy.turn(90);
	
	}
		
		
		
	}

	public static void main(String[] args) {
		new FourSquare().go();
	}

}



