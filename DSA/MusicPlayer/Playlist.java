package MusicPlayer;
import Utility.ConsoleUtils;
import java.util.LinkedList;

public class Playlist {
    // Attributes
    private String name;
    private LinkedList<Music> songs;

    // Parameterized Constructor
    public Playlist(String name) {
        this.name = name;
        this.songs = new LinkedList<>();
        ConsoleUtils.animatedPrint(String.format("Created \"%s\" playlist.\n", name), 30);
    }

    // Getters & Setters
    public String getName() { return this.name; }
    public LinkedList<Music> getSongs() { return this.songs; }

    public void setName(String name) { this.name = name; }
    public void setSongs(LinkedList<Music> songs) { this.songs = songs; }


    // Methods
    public void addSongToPlaylist(Music music) {
        songs.add(music);
        ConsoleUtils.animatedPrint(String.format("Song \"%s\" added to \"%s\" playlist.\n", music.getTitle(), getName()), 30);
    }

    public void removeSongFromPlaylist() {}
    public void renamePlaylist() {}
}
