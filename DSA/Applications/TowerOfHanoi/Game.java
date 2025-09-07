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

    String disk1 = " - ";
    String disk2 = "- -";
    String disk3 = "---";
    

    // Constructor
    public Game() {
        numOfDisks = 3; // Default # of disks
        tower1 = new Stack<>();
        tower2 = new Stack<>();
        tower3 = new Stack<>();

        for (int i = numOfDisks; i > 0; --i) {
            if (i == 3) { tower1.push(disk3); }
            if (i == 2) { tower1.push(disk2); }
            if (i == 1) { tower1.push(disk1); }
            tower2.push("|");
            tower3.push("|");
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
            System.out.println("Tower 1");
            for (int i = tower1.size() - 1; i >= 0; --i) {
                System.out.print(tower1.get(i));
                System.out.print(" ".repeat(4));
                System.out.print(tower2.get(i));
                System.out.print(" ".repeat(4));
                System.out.print(tower3.get(i));
                System.out.println();
            }
            InputUtils.getString("");
        }
    }
}
