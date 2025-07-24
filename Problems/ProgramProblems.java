package Problems;
import java.util.InputMismatchException;
import java.util.Scanner;
import utils.consoleUtils;

public class ProgramProblems {
    public static boolean isPrime(int number) {
        for (int i = number - 1; i > 1; --i) {
            if (number % i == 0) { return false; }
        }
        return true;
    }
 
    public static void simpleCalculator() {
        Scanner scanner = new Scanner(System.in);
        float result = 0.0f;
        char operation = '\0';
        boolean isInvalidOperation = false;

        while (true) {
            System.out.println("[ Simple Calculator ]");

            System.out.print("Enter x: ");
            float x = scanner.nextFloat();

            System.out.print("Enter y: ");
            float y = scanner.nextFloat();
            
            while (true) {
                System.out.print("Enter operation [+ - * /]: ");
                operation = scanner.next().charAt(0);

                switch (operation) {
                    case '+':
                        result = x + y;
                        break;
                    case '-':
                        result = x - y;
                        break; 
                    case '*':
                        result = x * y;
                        break;
                    case '/':
                        result = x / y;
                        break; 
                    default:
                        System.out.println("ERROR: Invalid operation, please enter a valid operation");
                        isInvalidOperation = true;
                        break;
                }

                if (!isInvalidOperation) {
                    break;
                } else {
                    isInvalidOperation = false; // reset flag
                }

            }

            System.out.printf("%.2f %c %.2f = %.2f\n", x, operation, y, result);
            
            while (true) {
                System.out.print("Would you like to calculate again? [y/n]: ");
                String userChoice = scanner.next().toLowerCase();

                if (userChoice.equals("y")) {
                    consoleUtils.clearScreen(10);
                    break;
                } else if (userChoice.equals("n")) {
                    return;
                } else {
                    consoleUtils.errorMessage("Invalid input. Please enter 'y' for yes and 'n' for no.");
                    scanner.nextLine();
                }
            }
        }
    }

    public static void temperatureConverter() {
        Scanner scanner = new Scanner(System.in);
        int conversionChoice = 0;
        float inputValue = 0.0f;
        float convertedTemperature = 0.0f;

        while (true) {
            System.out.println("[ Temperature Converter ]");

            // prompt user to enter choice of conversion
            System.out.println("[1] Celsius to Fahrenheit");
            System.out.println("[2] Fahrenheit to Celsius");

            while (true) {
                try {
                    System.out.print("Enter choice: ");
                    conversionChoice = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch(InputMismatchException e) {
                    consoleUtils.errorMessage("Invalid choice. Choose [1] for Celsius to Fahrenheit or [2] for Fahrenheit to Celsius.");
                    scanner.nextLine();
                }
            }
           
            // convert temperature based on user choice
            if (conversionChoice == 1) {
                // prompt user to enter temperature in Celsius
                while (true) {
                    try {
                        System.out.print("Enter Celsius[*C]: ");
                        inputValue = scanner.nextFloat();
                        scanner.nextLine();
                        break;
                    } catch(InputMismatchException e) {
                        consoleUtils.errorMessage("Invalid input. Please enter a valid number.");
                        scanner.nextLine();
                    }
                }

                // convert Celsius to Fahrenheit
                convertedTemperature = (9.0f / 5 * inputValue) + 32;

                System.out.printf("%.2f*C = %.2f*F\n", inputValue, convertedTemperature);
            } else if (conversionChoice == 2) {
                // prompt user to enter temperature in Fahrenheit
                while (true) {
                    try {
                        System.out.print("Enter Fahrenheit[*F]: ");
                        inputValue = scanner.nextFloat();
                        scanner.nextLine();
                        break;
                    } catch(InputMismatchException e) {
                        consoleUtils.errorMessage("Invalid input. Please enter a valid number."); 
                        scanner.nextLine();
                    }
                }

                // convert Fahrenheit to Celsius
                convertedTemperature = 5.0f / 9 * (inputValue - 32);

                System.out.printf("%.2f*F = %.2f*C\n", inputValue, convertedTemperature);
            } else {
                System.out.println("ERROR: Invalid input, please enter a valid choice [1-2]");

                consoleUtils.delay(2000);
                consoleUtils.clearScreen(1);
            }

            // prompt user to do another conversion
            while (true) {
                try {
                    System.out.print("Would you like to convert again? [y/n]: ");
                    String userChoice = scanner.next().toLowerCase();
                    
                    if (userChoice.equals("y")) {
                        consoleUtils.clearScreen(10);
                        break;
                    } else if (userChoice.equals("n")) {
                        return;
                    } else {
                        consoleUtils.errorMessage("Invalid input, please enter 'y' for yes and 'n' for no.");
                    }
                } catch(InputMismatchException e) {
                    consoleUtils.errorMessage("Invalid input, please enter 'y' for yes and 'n' for no.");
                    scanner.nextLine();
                } 
            }
        }
    }

    public static void main(String[] args) {
        // System.out.println(isPrime(2));
        // simpleCalculator();
        temperatureConverter();
    }
}