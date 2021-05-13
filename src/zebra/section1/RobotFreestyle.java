package zebra.section1;

import javax.swing.JOptionPane;

public class RobotFreestyle {
	
	public static void main(String[] args) {
		
		// ▼ Write your code BELOW this line ▼
		
		
		// 1. Make a new Robot().  Remember to give it a name!
		
		// 2. Make your robot move()
		
		// 3. Make your robot turn()  
		
		// 4. Make your robot put its penDown()
		
		// 5. Make your robot move() some more.  What do you see?
		
		// 6. Can you make your robot draw a square?  A triangle?  Something cool?
		String[] options = {"1", "2", "3", "4"};
        int colorop = JOptionPane.showOptionDialog(null, "Choose a number",
                "Choose a number",
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        if(colorop==0)    {
             System.out.println("1");
        }
        if(colorop==1)    {
        	  System.out.println("2");
        }
        if(colorop==2) {
        	  System.out.println("3");        }
        if(colorop==3)    {
        	  System.out.println("4");        }

		
		
		
		
		
		
		
		
		// Bonus: Can you make your robot sparkle? miniaturize? draw with a different color?
		
		
		// ▲ Write your code ABOVE this line ▲
		
	}
	
}
