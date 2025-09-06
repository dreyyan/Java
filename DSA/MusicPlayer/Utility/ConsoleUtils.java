package Utility;

// IMPORTS
import java.util.Scanner;

public class ConsoleUtils {
    // ATTRIBUTES
    static Scanner scanner = new Scanner(System.in); // Create an instance of 'Scanner'

    // METHODS
    // [METHOD]: Prompts the user to press any key to continue
    public static void pressToContinue() {
        System.out.println("Press any key to continue...");
        scanner.nextLine();
    }

    // [METHOD]: Display error message to the console
    public static void errorMessage(String message, int sDelay) {
        animatedCharPrint("ERROR: " + message, sDelay);
        
        try {
            Thread.sleep(sDelay * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // [METHOD]: "Clear" the screen by pushing old content out of view
    public static void clearScreen() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }

    // [METHOD]: Display a {length}-wide line format using {symbol}
    public static void displayFormat(char symbol, int length) {
        for (int i = 0; i < length; ++i) {
            System.out.print(symbol);
        } System.out.println();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // [METHOD]: Display the string /w character delay
    public static void animatedCharPrint(String str, int msDelay) {
        for (char c : str.toCharArray()) {
            System.out.print(c);

            try {
                Thread.sleep(msDelay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // [METHOD]: Display the string /w line delay
    public static void animatedLinePrint(String str, int msDelay) {
        System.out.print(str);
        try {
            Thread.sleep(msDelay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        animatedCharPrint("The quick brown fox jumps over the fence", 20);
    }
}