package section2;

import org.jointheleague.graphical.robot.Robot;

public class Spiral {

	public static void main(String[] args) {
		Robot cat = new Robot();
		
		cat.penDown();
		
		cat.setSpeed(100);
		
		for (int i = 0; i < 1000; i++) {
		cat.setRandomPenColor();
		cat.setPenWidth(i);
		cat.move(5*i);
		cat.turn(360/7);
		}
		
			// 7. Change the pen color to random
		
			// 6. Move the robot 5 times the loop counter (5*i)
			
			// 2. Turn the robot 360/7 degrees to the right
		
			// 8. Set the pen width to i
			
	}
}
