import java.util.Scanner;

public class Square_root {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("what root do you want it to be?");
	String root = scanner.nextLine();
	System.out.println("What do you want your number to be?");
	String number = scanner.nextLine();
	Double numberD = Double.parseDouble(number);
	
	
	
	double root2 = Double.parseDouble(root);
	double root3 = root2;
	for (double i = 0; i < numberD; i+= 0.00001) {
		root3  = Math.pow(i, root2);
		if (root3 > numberD) {
			System.out.println("The " + root2 + " root of " + numberD + " = ");
			
			System.out.printf("%.4f", i - 0.00001 );
			break;
		}}
	}
}

