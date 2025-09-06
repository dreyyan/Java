package Utility;

// IMPORTS
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {
    // ATTRIBUTES
    static Scanner scanner = new Scanner(System.in);

    // METHODS
    // [METHOD]: Get an integer input from the user
    public static int getInt(String prompt) {
        while (true) { 
            System.out.print(prompt);
            
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                ConsoleUtils.errorMessage("Invalid input, please enter a valid number", 3); 
            } 
        }
    }

    // [METHOD]: Get a floating number input from the user
    public static float getFloat(String prompt) {
        while (true) { 
            System.out.print(prompt);
            
            try {
                float input = scanner.nextFloat();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                ConsoleUtils.errorMessage("Invalid input, please enter a valid decimal number", 3); 
            } 
        }
    }

    // [METHOD]: Get a double input from the user
    public static double getDouble(String prompt) {
        while (true) { 
            System.out.print(prompt);
            
            try {
                double input = scanner.nextDouble();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                ConsoleUtils.errorMessage("Invalid input, please enter a valid decimal number", 3); 
            } 
        }
    }

    // [METHOD]: Get a char input from the user
    public static char getChar(String prompt) {
        while (true) { 
            System.out.print(prompt);
            
            try {
                char input = scanner.nextLine().charAt(0);
                return input;
            } catch (InputMismatchException e) {
                ConsoleUtils.errorMessage("Invalid input, please enter a valid string", 3); 
            } 
        }
    }

    // [METHOD]: Get a string input from the user
    public static String getString(String prompt) {
        while (true) {
            System.out.print(prompt);
            
            try {
                String input = scanner.nextLine();

                if (input.equals(""))
                    ConsoleUtils.errorMessage("Input cannot be blank", 3);
                return input;
            } catch (InputMismatchException e) {
                ConsoleUtils.errorMessage("Invalid input, please enter a valid string", 3); 
            } 
        }
    }

    // [METHOD]: Get a boolean input from the user
    public static boolean getBool(String prompt) {
        while (true) {
            System.out.print(prompt);
            
            try {
                boolean input = scanner.nextBoolean();
                return input;
            } catch (InputMismatchException e) {
                ConsoleUtils.errorMessage("Invalid input, please enter a valid boolean", 3); 
            } 
        }
    }
    
    public static void main(String[] args) {
        
    }
}