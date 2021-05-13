package fractional_Calculator;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FractionCal {
	public void run() {
		JFrame j = new JFrame();
		JTextField numerator = new JTextField();
		JTextField operation = new JTextField();
		
		JPanel p = new JPanel();
		
		j.add(p);
		
		numerator.setPreferredSize(new Dimension(100,100));
		JTextField denominator = new JTextField();
		denominator.setPreferredSize(new Dimension(100,100));
		operation.setPreferredSize(new Dimension(100,100));
		JLabel l = new JLabel("Numerator");
		JLabel l2 = new JLabel("Denominator");
		 
		p.add(l);
		p.add(numerator);
		p.add(l2);
		p.add(denominator);
		p.add(operation);
		
		j.setPreferredSize(new Dimension(150, 300));
		j.pack();
		j.setVisible(true);
		
		
	}
}

