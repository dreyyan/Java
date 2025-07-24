package utils;

public class consoleUtils {
    public static void clearScreen(int height) {
        for (int i = 0; i < height; ++i) {
            System.out.println();
        }
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void errorMessage(String message) {
        System.out.printf("ERROR: %s", message);
        try {
            Thread.sleep(2000);
            clearScreen(2);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
