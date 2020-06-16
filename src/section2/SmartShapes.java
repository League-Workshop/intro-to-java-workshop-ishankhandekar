package section2;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class SmartShapes {
	
    public static void main(String[] args) throws Exception {
        Robot Shapes = new Robot();
         int randomNun = new Random().nextInt(100) + 1;

        int turntriangle = (60);

        Shapes.penDown();


        Shapes.setSpeed(100);


        for (int i = 0; i < 4; i++) {
			Shapes.move(200);
			Shapes.turn(90);
		} 


        //         2. Move your robot 200 pixels


        //         4. Turn the robot 90 degrees to the right

    	
    		// 7. Change steps 4 and 5 to draw a different shape (e.g. triangle (3-sides), pentagon (5-sides), decagon (10-sides)).
   
    }
}
