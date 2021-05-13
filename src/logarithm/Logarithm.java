package logarithm;
import java.util.Scanner;
import ptolemy.plot.*;

public class Logarithm {
	public void run() {
		Scanner scanner = new Scanner(System.in);
		

	
		
		System.out.println("What do you want your base to be?");
		double base = scanner.nextDouble();
	
		System.out.println ("What number do you want to take the logarithm of?");
		double input = scanner.nextDouble();
			log(base, input);
//		Plot plotObj = new Plot();
//		plotObj.setXLabel("i");
//		plotObj.setYLabel(base + " to the power of i");
		
		
//		PlotApplication app = new PlotApplication(plotObj); // display
	}
	public void log(double base, double input) {
		for (double i = 0; i < input; i += 0.00001) {
//			plotObj.addPoint(0, i, Math.pow(base, i), true);
			if (Math.pow(base, i) >= input) {
				System.out.println("Base " + base + " log " + input + " = ");
				System.out.printf("%.4f", i);
				break;
			}
		}
	}
}
