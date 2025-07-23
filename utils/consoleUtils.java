package utils;

public class consoleUtils {
    public static void clearScreen(int height) {
        for (int i = 0; i < height; ++i) {
            System.out.println();
        }
    }
}
