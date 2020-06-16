package section2;

import java.awt.Color;
import org.jointheleague.graphical.robot.Robot;

public class MyFirstJavaProgram {
	
	public static void main(String[] args) {
		
		// START HERE
		int speed = 100;
	Robot wally = new Robot();
	wally.setSpeed(speed);
	wally.penDown();
	for (int i = 0; i < 4; i++) {
		wally.move(70);
		wally.turn(90);
	}
		
	}
}
