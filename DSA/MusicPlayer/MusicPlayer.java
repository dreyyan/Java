package MusicPlayer;
import Utility.ConsoleUtils;
public class MusicPlayer {
    // Attributes
    private final User user;
    private Playlist currentPlaylist;
    private final PlaybackController playbackController;

    // Parameterized Constructor
    public MusicPlayer(User user) {
        this.user = user;
        this.playbackController = new PlaybackController(this);
    }

    // Getters & Setters
    public User getUser() { return this.user; }
    public Playlist getCurrentPlaylist() { return this.currentPlaylist; }
    public PlaybackController getPlaybackController() { return this.playbackController; }
    
    public void setCurrentPlaylist(Playlist currentPlaylist) { this.currentPlaylist = currentPlaylist; }

    // Methods

    public void playMusic(Music musicToPlay) {
        for (Music music : getCurrentPlaylist().getSongs()) {
            if (music == musicToPlay) {
                ConsoleUtils.animatedCharPrint(String.format("Now playing \"%s\"...\n", music.getTitle()), 30);
                return;
            }
        } ConsoleUtils.errorMessage(String.format("Music \"%s\" does not exist in the playlist", musicToPlay.getTitle()), 3);
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