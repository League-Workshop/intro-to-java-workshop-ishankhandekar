
public class Computer {
	public static void main(String[] args) {
		Computer c = new Computer(15.5, "Windows", "intel");
		System.out.println(c.getInfo());
	}
	double ram;
	String operatingSystem;
	String processor;
	public Computer(double ram, String operatingSystem, String processor) {
		this.ram = ram;
		this.processor = processor;
		this.operatingSystem = operatingSystem;
	}public void Calculator() {
		consoleCalculator c = new consoleCalculator();
		c.run();
	}public String getInfo() {
		
		return "OS: " + operatingSystem + "\r\nRAM: " + ram + " GB" + "\r\nProcessor: " + processor;
	}
}
