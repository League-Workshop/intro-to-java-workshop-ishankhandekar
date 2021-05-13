import java.util.ArrayList;

import javax.swing.JOptionPane;

public class calculator {
public static void main(String[] args) {
	ArrayList <Integer> numbers = new ArrayList<Integer>();
	String options[] = {"x", "/","+", "-",};
	
	String x = JOptionPane.showInputDialog("Put in a number.");
	
	int y = JOptionPane.showOptionDialog(null, "choose a operation", "Calculator", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
	
}
}
