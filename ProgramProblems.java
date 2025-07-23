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

                if (!isInvalidOperation) { isInvalidOperation = false; break; }
            }

            System.out.printf("%f %c %f = %.2f\n", x, operation, y, result);
            
            while (true) {
                System.out.print("Would you like to calculate again? [y/n]: ");
                char userChoice = scanner.next().charAt(0);

                if (Character.toLowerCase(userChoice) == 'y') {
                    consoleUtils.clearScreen(10);
                    break;
                } else if (Character.toLowerCase(userChoice) == 'n') {
                    return;
                } else {
                    System.out.println("ERROR: Invalid input, please enter 'y' for yes and 'n' for no");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    consoleUtils.clearScreen(1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isPrime(2));
        simpleCalculator();
    }
}