//    Copyright (c) The League of Amazing Programmers 2013-2019
//    Level 0


package _04_int._2_robot_in_space;




import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class RobotInSpace {
	static int shapeSides;
 public static void main(String[] args) {
	 boolean isCorrect = false;
	 Robot rob = new Robot("mini");
	 rob.setSpeed(10000);
	 
	 while (isCorrect == false) {
		 String shape = JOptionPane.showInputDialog(null, "How many sided shape do you want", "Shape Drawer", JOptionPane.INFORMATION_MESSAGE);
			try {
				
				int shape1 = Integer.parseInt(shape);
				shapeSides = shape1;
			} catch (Exception e) {
				System.out.println("this is not a shape, try again");
				continue;
			}
			
		isCorrect = true;
		
	}
	 int sideSteps = 2000 / shapeSides;
	 double angle = 360.0 / (float)shapeSides;
	rob.turn(90);
	rob.moveTo(1000, 250);
	rob.penDown();
	for (int i = 0; i < shapeSides; i++) {
		rob.microTurn(angle);
		rob.move(sideSteps);
	}
}
	
	
}
