package MusicPlayer;
import Utility.ConsoleUtils;
import Utility.InputUtils;

public class MusicPlayer {
    // Attributes
    private User user;
    private Playlist currentPlaylist;

    // Parameterized Constructor
    public MusicPlayer(User user, Playlist currentPlaylist) {
        this.user = user;
        this.currentPlaylist = currentPlaylist;
    }
    
    // Getters & Setters
    public User getUser() { return this.user; }
    public Playlist getCurrentPlaylist() { return this.currentPlaylist; }

    public void setUser(User user) { this.user = user; }
    public void setCurrentPlaylist(Playlist currentPlaylist) { this.currentPlaylist = currentPlaylist; }

    // Methods

    public void openPlaylist() {
        // Search for a playlist's name
        PlaylistSearchResult result = user.searchPlaylist();
        Playlist playlistToOpen = result.getPlaylist();

        // ERROR: Non-existing result
        if (playlistToOpen == null) {
            ConsoleUtils.errorMessage("Playlist does not exist", 3);
            return;
        }
      
        // Open playlist if it exists
        // ConsoleUtils.animatedCharPrint(String.format("\"%s\" playlist opened...\n", result.getPlaylist().getName()), 30);
        int musicCounter = 1;

        // Display playlist songs
        ConsoleUtils.clearScreen();
        Main.displayHeader();

        if (playlistToOpen.getSongs().isEmpty()) {
            ConsoleUtils.animatedLinePrint("You currently have no songs yet.", 200);
        } else {
            ConsoleUtils.animatedLinePrint(String.format("[ %s ]\n", result.getName()), 200);
            ConsoleUtils.displayFormat('#', 33);
            for (Music music : result.getPlaylist().getSongs()) {
                ConsoleUtils.animatedLinePrint(String.format(" %d. %s - %s\n", musicCounter++, music.getTitle(), music.getArtist()), 200);
            } ConsoleUtils.displayFormat('#', 33);
        }

        InputUtils.getString("");
    }
    
    public void closePlaylist(Playlist playlist) {
        // ERROR: Closed playlist
        if (currentPlaylist == null) {
            ConsoleUtils.errorMessage("Playlist already closed", 3);
            return;
        }

        // Close playlist 
        ConsoleUtils.animatedCharPrint(String.format("\"%s\" playlist closed...\n", playlist.getName()), 30);
    }

    public void playMusic(Music musicToPlay) {
        for (Music music : getCurrentPlaylist().getSongs()) {
            if (music == musicToPlay) {
                ConsoleUtils.animatedCharPrint(String.format("Now playing \"%s\"...\n", music.getTitle()), 30);
                return;
            }
        }

        ConsoleUtils.errorMessage(String.format("Music \"%s\" does not exist in the playlist", musicToPlay.getTitle()), 3);
    }


    public void pauseMusic() {

    }

    // [ METHOD ]: Change shuffle method
    public void changeShuffle() {
        // Methods:
        // 1. Random - Default random
        // 2. No Repeat - Random /wo repeating
        // 3. History Aware - Random /wo repeating last `n`
    }
    
    public void displayMenu() {
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

            if (user.getPlaylists().isEmpty()) {
                ConsoleUtils.animatedLinePrint("You don't have any playlists yet.\n", 30);
                String userChoice = InputUtils.getString("Add one? [y/n]: ");

                if (!userChoice.equls)
            } else {
                user.displayPlaylists();                
            }

            for (String operation : operations) {
                ConsoleUtils.animatedLinePrint(String.format("[%d] %s\n", operationsCounter++, operation), 200);
            } ConsoleUtils.displayFormat('#', 33);
          
            // Prompt user to enter a number input
            int userChoice = InputUtils.getInt("Enter a choice: ");

            // Do operation based on user's input
            switch (userChoice) {
                case 1 -> user.createPlaylist();
                case 2 -> this.openPlaylist();
                case 3 -> user.deletePlaylist();
                case 4 -> System.exit(0);
            }

            // Reset counter
            operationsCounter = 1;
        }
    }
}