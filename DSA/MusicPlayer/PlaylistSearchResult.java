package MusicPlayer;

public class PlaylistSearchResult {
    // Attributes
    private String name;
    private Playlist playlist;
   
    // Parameterized Constructor
    public PlaylistSearchResult(String name, Playlist playlist) {
        this.name = name;
        this.playlist = playlist;
    }

    // Methods
    public String getName() { return this.name; }
    public Playlist getPlaylist() { return this.playlist; }
}