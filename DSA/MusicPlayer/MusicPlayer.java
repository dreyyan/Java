package MusicPlayer;
import Utility.ConsoleUtils;

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
    public void openPlaylist(Playlist playlist) {
        ConsoleUtils.animatedPrint(String.format("\"%s\" playlist opened...\n", playlist.getName()), 30);
        int musicCounter = 1;

        // Display songs in the playlist
        for (Music music : playlist.getSongs()) {
            ConsoleUtils.animatedPrint(String.format("%d. %s - %s\n", musicCounter++, music.getTitle(), music.getArtist()), 30);
        }
    }

    public void closePlaylist(Playlist playlist) {
        ConsoleUtils.animatedPrint(String.format("\"%s\" playlist closed...\n", playlist.getName()), 30);
    }

    public void playMusic(Music musicToPlay) {
        for (Music music : getCurrentPlaylist().getSongs()) {
            if (music == musicToPlay) {
                ConsoleUtils.animatedPrint(String.format("Now playing \"%s\"...\n", music.getTitle()), 30);
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
}