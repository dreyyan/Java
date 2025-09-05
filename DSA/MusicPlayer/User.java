package MusicPlayer;
import Utility.ConsoleUtils;
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

    // Methods
    public void createPlaylist(String playlistName) {
        playlists.add(new Playlist(playlistName));

        ConsoleUtils.animatedPrint(String.format("Playlist \"%s\" created successfully.", playlistName), 30);
    }

    public void displayPlaylists() {
        int playlistNumber = 1;
       
        ConsoleUtils.animatedPrint("[ My Playlist ]", 30);
        for (Playlist playlist : playlists) {
            ConsoleUtils.animatedPrint(String.format("%d. %s", playlistNumber, playlist.getName()), 30);
        }
    }
}