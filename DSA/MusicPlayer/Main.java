package MusicPlayer;
import Utility.ConsoleUtils;
import Utility.InputUtils;
public class Main {
    // Methods
    public static void displayHeader() {
        ConsoleUtils.animatedLinePrint("        [ Music Player ]\n", 30);
        ConsoleUtils.displayFormat('#', 33);
    }

    public void displayMenu(User user) {
        int operationsCounter = 1;
        String[] operations = {
            "Create Playlist", "Open Playlist",
            "Delete Playlist", "Exit"
        };

        // Continue to show the menu until the user chooses to exit the program
        while (true) {
            ConsoleUtils.clearScreen();

            // Display operations menu
            Main.displayHeader();

            // Prompt user to add a playlist if playlists is empty
            if (user.getPlaylists().isEmpty()) {
                ConsoleUtils.animatedLinePrint("You don't have any playlists yet.\n", 30);
                String userChoice = InputUtils.getString("Add one? [y/n]: ");

                // ERROR: Invalid choice
                if (!userChoice.equalsIgnoreCase("y") && !userChoice.equalsIgnoreCase("n"))
                    ConsoleUtils.errorMessage("Invalid input, please enter 'y' for yes and 'n' for no", 3);
            } else {
                user.displayPlaylists();                
            }

            // Display operations
            for (String operation : operations) {
                ConsoleUtils.animatedLinePrint(String.format("[%d] %s\n", operationsCounter++, operation), 200);
            } ConsoleUtils.displayFormat('#', 33);

            // Reset counter
            operationsCounter = 1;
          
            // Prompt user to enter a number input
            int userChoice = InputUtils.getInt("Enter a choice: ");

            // Do operation based on user's input
            switch (userChoice) {
                case 1 -> user.createPlaylist();
                case 2 -> user.getMusicPlayer().openPlaylist();
                case 3 -> user.deletePlaylist();
                case 4 -> System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        // Create objects
        Main main = new Main();
        User user = new User();
        Playlist popSongs = new Playlist("Pop Songs");
        Playlist rockSongs = new Playlist("Rock Songs");
        
        user.addPlaylistToPlaylists(popSongs);
        user.addPlaylistToPlaylists(rockSongs);

        // Add sample songs to the playlist
        // musicPlayer.getCurrentPlaylist().addSongToPlaylist(shapeOfYou);
        // musicPlayer.getCurrentPlaylist().addSongToPlaylist(bohemianRhapsody);
        // musicPlayer.getCurrentPlaylist().addSongToPlaylist(imagine);

        // Debug program
        main.displayMenu(user);
    }
}