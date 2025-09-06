package MusicPlayer;
import Utility.ConsoleUtils;
import Utility.InputUtils;
import java.util.LinkedList;

public class User {
    // Attributes
    private String name;
    private LinkedList<Playlist> playlists;

    // Getters & Setters
    public String getName() { return this.name; }
    public LinkedList<Playlist> getPlaylists() { return this.playlists; }

    public void setName(String name) { this.name = name; }
    public void setPlaylists(LinkedList<Playlist> playlists) { this.playlists = playlists; }

    // Parameterized Constructor
    public User(String name) {
        this.name = name;
        this.playlists = new LinkedList<>();

        // ConsoleUtils.animatedCharPrint(String.format("+ User \"%s\" created!\n", name), 30);
    }

    // Methods
    public void addPlaylistToPlaylists(Playlist newPlaylist) {
        this.getPlaylists().add(newPlaylist);
    }

    
    public void displayPlaylists() {
        int playlistNumber = 1;
       
        ConsoleUtils.animatedLinePrint("[ My Playlist ]\n", 200);
        for (Playlist playlist : playlists) {
            ConsoleUtils.animatedLinePrint(String.format("%d. %s\n", playlistNumber++, playlist.getName()), 200);
        } ConsoleUtils.displayFormat('#', 33);
    }

    public PlaylistSearchResult searchPlaylist() {
        ConsoleUtils.clearScreen();
       
        // Display header
        ConsoleUtils.animatedLinePrint("        [ Music Player ]\n", 30);
        ConsoleUtils.displayFormat('#', 33);
        displayPlaylists();

        // Prompt user to enter a playlist name
        String newPlaylistName = InputUtils.getString("Enter a playlist name: ");

        for (Playlist playlist : this.getPlaylists()) {
            // Return playlist if it exists 
            if (newPlaylistName.equals(playlist.getName())) {
                return new PlaylistSearchResult(newPlaylistName, playlist);
            }
        }

        return new PlaylistSearchResult(newPlaylistName, null);
    }

    public void createPlaylist() {
        // Search for a playlist's name
        PlaylistSearchResult result = searchPlaylist();

        // ERROR: Existing playlist
        if (result.getPlaylist() != null) {
            ConsoleUtils.errorMessage("Playlist already exists", 3);
            return;
        }

        // Add new playlist to the playlists
        addPlaylistToPlaylists(result.getPlaylist());
        ConsoleUtils.animatedCharPrint(String.format("+ Playlist \"%s\" created successfully.", result.getName()), 30);
    }
    
    public void deletePlaylist() {
        // Search for a playlist's name
        PlaylistSearchResult result = searchPlaylist();
        Playlist searchedPlaylist = result.getPlaylist();
         
        // ERROR: Non-existing playlist
        if (searchedPlaylist == null) {
            ConsoleUtils.errorMessage("Playlist does not exist", 3);
            return;
        }

        // Delete the playlist specified by the user
        if (playlists.contains(searchedPlaylist)) {
            playlists.remove(searchedPlaylist);
        }
    }
}