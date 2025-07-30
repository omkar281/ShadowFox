package Task1;

import java.util.Scanner;

public class EnhancedCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n==== Enhanced Calculator ====");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    basicArithmetic(sc);
                    break;
                case 2:
                    scientificCalc(sc);
                    break;
                case 3:
                    unitConversion(sc);
                    break;
                case 4:
                    System.out.println("Exiting Calculator. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }

    static void basicArithmetic(Scanner sc) {
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.println("Choose operation (+, -, *, /): ");
        char op = sc.next().charAt(0);
        double result;

        switch (op) {
            case '+':
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                } else {
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                }
                break;
            default:
                System.out.println("Invalid operator.");
        }
    }

    static void scientificCalc(Scanner sc) {
        System.out.println("Choose operation:");
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation (x^y)");
        System.out.print("Choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter number: ");
                double num = sc.nextDouble();
                if (num < 0) {
                    System.out.println("Error: Cannot calculate square root of negative number.");
                } else {
                    System.out.println("Square root: " + Math.sqrt(num));
                }
                break;
            case 2:
                System.out.print("Enter base: ");
                double base = sc.nextDouble();
                System.out.print("Enter exponent: ");
                double exp = sc.nextDouble();
                System.out.println("Result: " + Math.pow(base, exp));
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    static void unitConversion(Scanner sc) {
        System.out.println("Choose conversion type:");
        System.out.println("1. Temperature (Celsius to Fahrenheit)");
        System.out.println("2. Temperature (Fahrenheit to Celsius)");
        System.out.println("3. Currency (INR to USD)");
        System.out.println("4. Currency (USD to INR)");
        System.out.print("Choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter Celsius: ");
                double c = sc.nextDouble();
                double f = (c * 9 / 5) + 32;
                System.out.println("Fahrenheit = " + f);
                break;
            case 2:
                System.out.print("Enter Fahrenheit: ");
                double fahren = sc.nextDouble();
                double celsius = (fahren - 32) * 5 / 9;
                System.out.println("Celsius = " + celsius);
                break;
            case 3:
                System.out.print("Enter INR: ");
                double inr = sc.nextDouble();
                double usd = inr / 83.0;
                System.out.println("USD = " + usd);
                break;
            case 4:
                System.out.print("Enter USD: ");
                double dollar = sc.nextDouble();
                double rupees = dollar * 83.0;
                System.out.println("INR = " + rupees);
                break;
            default:
                System.out.println("Invalid conversion type!");
        }
    }
}
