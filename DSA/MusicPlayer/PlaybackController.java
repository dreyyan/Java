package MusicPlayer;
import Utility.ConsoleUtils;
import Utility.InputUtils;

public class PlaybackController {
    // Attributes
    private final MusicPlayer musicPlayer;
   
    // Parameterized Constructor
    public PlaybackController(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }
    
    // Methods
    public void openPlaylist() {
        // Search for a playlist's name
        PlaylistSearchResult result = musicPlayer.getUser().searchPlaylist();
        Playlist playlistToOpen = result.getPlaylist();

        // ERROR: Non-existing result
        if (playlistToOpen == null) {
            ConsoleUtils.errorMessage("Playlist does not exist", 3);
            return;
        }
     
        // Open playlist if it exists by displaying songs
        musicPlayer.setCurrentPlaylist(playlistToOpen);
        // ConsoleUtils.animatedCharPrint(String.format("\"%s\" playlist opened...\n", result.getPlaylist().getName()), 30);

        ConsoleUtils.clearScreen();
        Main.displayHeader();

        // Prompt user to add a playlist if playlists is empty
        if (musicPlayer.getUser().getPlaylists().isEmpty()) {
            ConsoleUtils.animatedLinePrint("You don't have any playlists yet.\n", 30);

            while (true) { 
                String userChoice = InputUtils.getString("Add one? [y/n]: ");

                // ERROR: Invalid choice
                if (!userChoice.equalsIgnoreCase("y") && !userChoice.equalsIgnoreCase("n"))
                    ConsoleUtils.errorMessage("Invalid input, please enter 'y' for yes and 'n' for no", 3);
                else break;
            }

            // Add a playlist to the user's playlists
            musicPlayer.getUser().createPlaylist();
        } else {
            // Prompt user to add a song if playlist is empty            
            if (playlistToOpen.getSongs().isEmpty()) {
                ConsoleUtils.animatedLinePrint("You currently have no songs yet.\n", 200);

                while (true) { 
                    String userChoice = InputUtils.getString("Add one? [y/n]: ");

                    // ERROR: Invalid choice
                    if (!userChoice.equalsIgnoreCase("y") && !userChoice.equalsIgnoreCase("n"))
                        ConsoleUtils.errorMessage("Invalid input, please enter 'y' for yes and 'n' for no", 3);
                    else if (userChoice.equalsIgnoreCase("n")) {
                        return;
                    } else break;
                }

                ConsoleUtils.clearScreen(); // Clear the screen before redirecting
                Main.displayHeader();
                
                // Add a song to the user's playlist
                musicPlayer.getCurrentPlaylist().addSongToPlaylist();
            } else {
                musicPlayer.getCurrentPlaylist().displaySongs();
            }
        }
    }
    
    public void closePlaylist(Playlist playlist) {
        // ERROR: Closed playlist
        if (musicPlayer.getCurrentPlaylist() == null) {
            ConsoleUtils.errorMessage("Playlist already closed", 3);
            return;
        }

        // Close playlist 
        ConsoleUtils.animatedCharPrint(String.format("\"%s\" playlist closed...\n", playlist.getName()), 30);
    }
    
}
