package TowerOfHanoi;

import TowerOfHanoi.Utility.ConsoleUtils;
import TowerOfHanoi.Utility.InputUtils;
import java.util.Stack;

public class Game {
    // Attributes
    private int numOfDisks;
    Stack<Integer> tower1;
    Stack<Integer> tower2;
    Stack<Integer> tower3;

    int towerChoice1;
    int towerChoice2;


    // Constructor
    public Game() {
        numOfDisks = 3; // Default # of disks
        tower1 = new Stack<>();
        tower2 = new Stack<>();
        tower3 = new Stack<>();

        for (int i = numOfDisks; i > 0; --i) {
            if (i == 3) { tower1.push(i); }
            if (i == 2) { tower1.push(i); }
            if (i == 1) { tower1.push(i); }
            tower2.push(0);
            tower3.push(0);
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

        boolean gameWon = false;

        // Start the actual game
        while (!gameWon) { 
            System.out.println("=".repeat(11));
            for (int i = tower1.size() - 1; i >= 0; --i) {
                System.out.print(tower1.get(i));
                System.out.print(" ".repeat(4));
                System.out.print(tower2.get(i));
                System.out.print(" ".repeat(4));
                System.out.print(tower3.get(i));
                System.out.println();
            } System.out.println("=".repeat(11));

            // Prompt user to pick a tower
            int towerChoice1 = InputUtils.getInt(">> ");

            // ERROR: Empty tower
            switch (towerChoice1) {
                case 1 -> {
                    if (tower1.isEmpty()) {
                        System.out.println("ERROR: Tower is empty");
                        continue;
                    }
                }
                case 2 -> {
                    if (tower2.isEmpty()) {
                        System.out.println("ERROR: Tower is empty");
                        continue;
                    }
                }
                case 3 -> {
                    if (tower3.isEmpty()) {
                        System.out.println("ERROR: Tower is empty");
                        continue;
                    }
                }
            }
            
            // Retrieve disk from the chosen tower
            int poppedDisk;
            
            switch (towerChoice1) {
                case 1 -> {
                    poppedDisk = tower1.pop();                   
                    tower1.push(0);
                }
                case 2 -> {
                    poppedDisk = tower2.pop();                   
                    tower2.push(0);
                }
                case 3 -> {
                    poppedDisk = tower3.pop();                   
                    tower3.push(0);
                }
                default -> poppedDisk = -1;
            }

            if (poppedDisk == -1) {
                System.out.println("ERROR: Invalid input");
                continue;
            }

            // Update display
            System.out.println("=".repeat(11));
            for (int i = tower1.size() - 1; i >= 0; --i) {
                System.out.print(tower1.get(i));
                System.out.print(" ".repeat(4));
                System.out.print(tower2.get(i));
                System.out.print(" ".repeat(4));
                System.out.print(tower3.get(i));
                System.out.println();
            } System.out.println("=".repeat(11));
            
            int towerChoice2 = InputUtils.getInt(">> ");

            if (towerChoice1 == towerChoice2) {
                System.out.println("ERROR: Invalid move");
                continue;
            } else if (towerChoice2 == 1) {
                if (tower1.peek() == 2) {
                    tower1.pop();
                    tower1.push(poppedDisk);
                }
            } else if (towerChoice2 == 2) {
                if (tower2.peek() == 2) {
                    tower2.pop();
                    tower2.push(poppedDisk);
                }
            } else if (towerChoice2 == 3) {
                if (tower3.peek() == 2) {
                    tower3.pop();
                    tower3.push(poppedDisk);
                }
            }

            System.out.println("=".repeat(11));
            for (int i = tower1.size() - 1; i >= 0; --i) {
                System.out.print(tower1.get(i));
                System.out.print(" ".repeat(4));
                System.out.print(tower2.get(i));
                System.out.print(" ".repeat(4));
                System.out.print(tower3.get(i));
                System.out.println();
            } System.out.println("=".repeat(11));
        }
    }
}
