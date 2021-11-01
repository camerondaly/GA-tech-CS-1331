import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to add, subtract, multiply, divide, or alphabetize?");
		System.out.println("Enter an operation...: ");
		String operation = input.nextLine();
		operation = operation.toLowerCase();
		switch (operation) {
			case "add":
				System.out.println("Enter two integers:");
				if (input.hasNextInt()) {
					int int1 = input.nextInt();
					if (input.hasNextInt()) {
						int int2 = input.nextInt();
						System.out.println("Answer: " + add(int1, int2));
						break;
					}
				}
				else {
					System.out.println("Invalid input entered. Terminating...");
					break;
				}
			case "subtract":
				System.out.println("Enter two integers:");
				if (input.hasNextInt()) {
					int int1 = input.nextInt();
					if (input.hasNextInt()) {
						int int2 = input.nextInt();
						System.out.println("Answer: " + subtract(int1, int2));
						break;
					}
				}
				else {
					System.out.println("Invalid input entered. Terminating...");
					break;
				}
			case "multiply":
				System.out.println("Enter two numbers:");
				if (input.hasNextDouble()) {
					double double1 = input.nextDouble();
					if (input.hasNextDouble()) {
						double double2 = input.nextDouble();
						System.out.printf("Answer: %.2f\n", multiply(double1, double2));
						break;
					}
				}
				else {
					System.out.println("Invalid input entered. Terminating...");
					break;
				}
			case "divide":
				System.out.println("Enter two numbers:");
				if (input.hasNextDouble()) {
					double double1 = input.nextDouble();
					if (input.hasNextDouble()) {
						double double2 = input.nextDouble();
						System.out.printf("Answer: %.2f\n", divide(double1, double2));
						break;
					}
				}
				else {
					System.out.println("Invalid input entered. Terminating...");
					break;
				}
			case "alphabetize":
				System.out.println("Enter two words: ");
				if (input.hasNextLine()) {
					String string1 = input.next();
					if (input.hasNextLine()) {
						String string2 = input.next();
						System.out.println("Answer: " + alphabetize(string1, string2));
						break;
					}
				}
				else {
					System.out.println("Invalid input entered. Terminating...");
					break;
				}
			default:
				System.out.println("Invalid input entered. Terminating...");
				break;
		}
	}
	public static int add(int int1, int int2) {
		return int1 + int2;
	}
	public static int subtract(int int1, int int2) {
		return int1 - int2;
	}
	public static double multiply(double double1, double double2) {
		return double1 * double2;
	}
	public static double divide(double double1, double double2) {
		return double1 / double2;
	}
	public static String alphabetize(String string1, String string2) {
		string1 = string1.toLowerCase();
		string2 = string2.toLowerCase();
		int res = string1.compareTo(string2);
		if (res > 0) {
			return (string2 + " comes before " + string1 + " alpabetically.");
		}
		else if (res < 0) {
			return (string1 + " comes before " + string2 + " alpabetically.");
		}
		else {
			return "Chicken or egg.";
		}
	}
}
			
				
				

		
	
