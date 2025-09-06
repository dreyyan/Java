package TowerOfHanoi;

import TowerOfHanoi.Utility.ConsoleUtils;
import TowerOfHanoi.Utility.InputUtils;
import java.util.Stack;

public class Game {
    // Attributes
    private int numOfDisks;
    Stack<String> tower1;
    Stack<String> tower2;
    Stack<String> tower3;

    // Constructor
    public Game() {
        numOfDisks = 3; // Default # of disks
        tower1 = new Stack();
        tower2 = new Stack();
        tower3 = new Stack();

        for (int i = numOfDisks; i > 0; --i) {
            tower1.push("-".repeat(i));
        }
    }

    // Getters & Setters
    public int getNumOfDisks() { return numOfDisks; }
    public void setNumOfDisks(int numOfDisks) { this.numOfDisks = numOfDisks; }

    // Methods
    public void changeNumOfDisks() {
        int numOfDisks;
        while (true) {
            numOfDisks = InputUtils.getInt("Enter # of disks: ");

            if (numOfDisks < 3) {
                System.out.println("ERROR: # of disks must be at least 3");
            } else break;
        } setNumOfDisks(numOfDisks); // Update # of disks
    }

    public void playGame() {
        while (true) { 
            ConsoleUtils.clearScreen();
            System.out.println(" [ Tower of Hanoi ]");
            System.out.println("# of disks: " + getNumOfDisks());
            ConsoleUtils.displayFormat('#', 20);
            String startGameChoice = InputUtils.getString("Start game? [y/n]: ");

            if (!startGameChoice.equalsIgnoreCase("y") && !startGameChoice.equalsIgnoreCase("n")) {
                System.out.println("ERROR: Invalid input");
            } else break;
        } ConsoleUtils.clearScreen();

        // Start the actual game
        while (true) { 
            // for (String disk : tower1) {
            //     System.out.println(disk);
            // }

            // for (String disk : tower2) {
            //     System.out.println(disk);
            // }

            // for (String disk : tower3) {
            //     System.out.println(disk);
            // }
            
            while (tower1.size() > 0) { System.out.println(tower1.pop()); }
                InputUtils.getString("DEBUG");
            }
    }
}
