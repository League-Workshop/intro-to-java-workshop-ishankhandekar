import javax.swing.JOptionPane;

import com.sun.xml.internal.ws.util.StringUtils;

public class Heat_convertion {
	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Welcome to heat convertion");
		
		String options[] = { "Celsius to Fahrenheit", "Fahrenheit to Celsius", "Celsius to Kelvin", "Kelvin to Celsius",
				"Fahrenheit to Kelvin", "Kelvin to Farenheit" };
		
		String convertionName[] = {"Farenheit", "Celcius", "Kelvin", "Celsius", "Kelvin", "Farenheit"};
		
		int whatConvertion = JOptionPane.showOptionDialog(null, "What convertion do you want to do?",
				"Heat Convertions", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
				
					String convertionNumber = JOptionPane.showInputDialog("What number do you want to convert to " + convertionName[whatConvertion]);
				
				double convertionNumber2 = Double.parseDouble(convertionNumber);
		
		if (whatConvertion == 0 || whatConvertion == 1) {
			convertionNumber2 = CelciusFarenheit(convertionNumber2, whatConvertion);
			JOptionPane.showMessageDialog(null, "Your convertion came up to " + convertionNumber2);
		} else if (whatConvertion == 2 || whatConvertion == 3) {
			convertionNumber2 = CelciusKelvin(convertionNumber2, whatConvertion);
			JOptionPane.showMessageDialog(null, "Your convertion to " + convertionName[whatConvertion] + " came up to " + convertionNumber2);
		} else if (whatConvertion == 4|| whatConvertion == 5 ) {
			convertionNumber2 = FarenheitKelvin(convertionNumber2, whatConvertion);
			JOptionPane.showMessageDialog(null, "your convertion to " + convertionName[whatConvertion] + " came up to " + convertionNumber2);
		}

	}

	static double CelciusFarenheit(double convertionNumber2, int whatConvertion) {
		if (whatConvertion == 0) {
			convertionNumber2 = convertionNumber2 * 1.8;
			convertionNumber2 = convertionNumber2 + 32;
		} else if (whatConvertion == 1) {
			convertionNumber2 = convertionNumber2 - 32;
			convertionNumber2 = convertionNumber2 / 1.8;
		}
		
		return convertionNumber2;
	}

	static double CelciusKelvin(double convertionNumber2, int whatConvertion) {
		if (whatConvertion == 2) {
			convertionNumber2 = convertionNumber2 + 273.15;
		} else if (whatConvertion == 3) {
			convertionNumber2 = convertionNumber2 - 273.15;
		}
		return convertionNumber2;
	}

	static double FarenheitKelvin(double convertionNumber2, int whatConvertion) {
		if (whatConvertion == 4) {
			convertionNumber2 = convertionNumber2 - 32;
			convertionNumber2 = convertionNumber2 / 1.8;
			convertionNumber2 = convertionNumber2 + 273.15;
		}else if (whatConvertion == 5) {
			convertionNumber2 = convertionNumber2 - 273.15;
			convertionNumber2 = convertionNumber2 * 1.8;
			convertionNumber2 = convertionNumber2 + 32;
		}
		return convertionNumber2;
	}
}
