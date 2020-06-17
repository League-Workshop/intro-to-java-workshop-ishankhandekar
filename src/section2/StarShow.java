package section2;

import org.jointheleague.graphical.robot.Robot;

/*** Teacher's note ***/
/* Before beginning recipe: 
* 1. ask students to find and explain the method in this recipe. 
* 2. ask students how they might use the method to make the picture in the laminated hand-outs. */

public class StarShow {
	
	Robot batman = new Robot("batman");
	
	void makeStars() {
			
		batman.setSpeed(8);

		// 6. Make a variable to hold the X position of the Robot and set it to 10
		int xposition= 10;

		// 7. Make a variable to hold the Y position of the Robot and set it to 600
		int yposition= 600;

		int starSize = 25;

		// 12. Use a for loop to repeat steps #19 to #18, 30 times
		for (int i = 0; i < 30; i++) {
			batman.setPenWidth(i);

			// 19. Set the pen width to i 
	
			// 10. Set the X position of the robot to your X variable
			batman.setX(xposition);
	
			// 11. Set the Y position of the robot to your Y variable
			batman.setY(yposition);
	
			// 9. Call the drawStar() method with your star size variable
			drawStar(starSize);
	
			// 14. Increase the value of the X position variable by star size. See Figure 2
			xposition = xposition + starSize;
			// 15. decrease the value of the Y position variable by star size. See Figure 3
			yposition= yposition - starSize;
			// 16. Increase the star size by 20
			starSize = starSize + 20;
			// 17. Turn the robot 12 degrees
			batman.turn(12);
			// 18. Make each star a different random color like in Figure 4
			batman.setRandomPenColor();
		
			
		}
			

	}

	private void drawStar(int starSize) {
		batman.penDown();

		for (int i = 0; i < 5; i++) {
			batman.move(starSize);
			
			batman.turn(144);
		}

			
			
	}
	
	public static void main(String[] args) {
		new StarShow().makeStars();
	}
}



