package MusicPlayer;
import Utility.ConsoleUtils;
public class Main {
    // Methods
    public static void displayHeader() {
        ConsoleUtils.animatedLinePrint("        [ Music Player ]\n", 30);
        ConsoleUtils.displayFormat('#', 33);
    }

    public static void main(String[] args) {
        // Create sample songs
        Music shapeOfYou = new Music("Shape of You", "Ed Sheeran", "Divide", "Pop", 2017, 263);
        Music bohemianRhapsody = new Music("Bohemian Rhapsody", "Queen", "A Night at the Opera", "Rock", 1975, 354);
        Music imagine = new Music("Imagine", "John Lennon", "Imagine", "Soft Rock", 1971, 183);

        // Create objects
        User adrian = new User("Adrian Dominic Tan");
        MusicPlayer musicPlayer = new MusicPlayer(adrian, null);
        
        Playlist popSongs = new Playlist("Pop Songs");
        Playlist rockSongs = new Playlist("Rock Songs");
        
        adrian.addPlaylistToPlaylists(popSongs);
        adrian.addPlaylistToPlaylists(rockSongs);

        // Add sample songs to the playlist
        // musicPlayer.getCurrentPlaylist().addSongToPlaylist(shapeOfYou);
        // musicPlayer.getCurrentPlaylist().addSongToPlaylist(bohemianRhapsody);
        // musicPlayer.getCurrentPlaylist().addSongToPlaylist(imagine);

        // Debug program
        musicPlayer.displayMenu();
    }
}