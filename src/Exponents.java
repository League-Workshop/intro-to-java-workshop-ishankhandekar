import java.util.Scanner;

public class Exponents {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What do you want your number to be?");
		String number = scanner.nextLine();
		System.out.println("What do you want your exponent to be?");
		String exponent = scanner.nextLine();
		Double exponent2 = Double.parseDouble(exponent);
		Double answer = Double.parseDouble(number);
		answer = Math.pow(answer, exponent2);
		System.out.println(answer);
		
	}
}
