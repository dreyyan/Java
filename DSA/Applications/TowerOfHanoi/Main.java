package  TowerOfHanoi;
import TowerOfHanoi.Utility.ConsoleUtils;
import TowerOfHanoi.Utility.InputUtils;

public class Main {
    // Attributes
    private Game game; 

    // Constructor
    public Main() { this.game = new Game(); }

    // Methods
    public void displayMenu() {
        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println(" [ Tower of Hanoi ]");
            ConsoleUtils.displayFormat('#', 20);
            System.out.println("[1] Play Game");
            System.out.println("[2] Change # of Disks");
            System.out.println("[3] Exit");
            ConsoleUtils.displayFormat('#', 20);
            int userChoice = InputUtils.getInt("Enter choice: ");

            switch (userChoice) {
                case 1 -> game.playGame();
                case 2 -> game.changeNumOfDisks();
                case 3 -> System.exit(0);
                default -> ConsoleUtils.errorMessage("Invalid input, please enter a valid choice [1-3]", 3);
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.displayMenu(); 
    }
}