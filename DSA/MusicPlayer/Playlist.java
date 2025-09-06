package MusicPlayer;
import Utility.ConsoleUtils;
import Utility.InputUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Playlist {
    // Attributes
    private String name;
    private LinkedList<Music> songs;

    // Parameterized Constructor
    public Playlist(String name) {
        this.name = name;
        this.songs = new LinkedList<>();
        // ConsoleUtils.animatedPrint(String.format("Created \"%s\" playlist.\n", name), 30);
    }

    // Getters & Setters
    public String getName() { return this.name; }
    public LinkedList<Music> getSongs() { return this.songs; }

    public void setName(String name) { this.name = name; }
    public void setSongs(LinkedList<Music> songs) { this.songs = songs; }

    // Methods
    public void addSongToPlaylist() {
        String songTitle, songArtist, songAlbum, songGenre, songFilePath;
        int songYear, songDuration;
        
        // Prompt user to enter song details:
        // Prompt user for title
        while (true) {
            ConsoleUtils.clearScreen();
            Main.displayHeader();
            
            songTitle = InputUtils.getString("Enter song title: ");

            // Break loop if valid title
            if (!songTitle.equals("")) {
                break;
            }

            // ERROR: Blank input
            ConsoleUtils.errorMessage("Song title cannot be blank", 3);
        }

        // Prompt user for artist
        while (true) {
            ConsoleUtils.clearScreen();
            Main.displayHeader();
            
            songArtist = InputUtils.getString("Enter song artist: ");

            // Break loop if valid artist
            if (!songArtist.equals("")) {
                break;
            }

            // ERROR: Blank input
            ConsoleUtils.errorMessage("Song artist cannot be blank", 3);
        }

        // Prompt user for album
        while (true) {
            ConsoleUtils.clearScreen();
            Main.displayHeader();
            
            songAlbum = InputUtils.getString("Enter song album: ");

            // If blank song album, set it to 'N/A'
            if (!songAlbum.equals("")) {
                songAlbum = "N/A";      
            } break;
        }

        // Prompt user for genre
        while (true) {
            ConsoleUtils.clearScreen();
            Main.displayHeader();
            
            songGenre = InputUtils.getString("Enter song genre: ");

            // Break loop if valid song genre
            if (!songGenre.equals("")) {
                break;
            }

            // ERROR: Blank input
            ConsoleUtils.errorMessage("Song genre cannot be blank", 3);
        }
        
        // Prompt user for year
        int currentYear = java.time.Year.now().getValue();

        while (true) {
            ConsoleUtils.clearScreen();
            Main.displayHeader();
            
            songYear = InputUtils.getInt("Enter song year: ");

            // Break loop if valid year
            if (songYear >= 1900 && songYear < currentYear) {
                break;
            }

            // ERROR: Invalid year
            ConsoleUtils.errorMessage(String.format("Invalid input, year must be between 1900-%d", currentYear), 3);
        }
        
        // Prompt user for duration
        while (true) {
            ConsoleUtils.clearScreen();
            Main.displayHeader();
            
            songDuration = InputUtils.getInt("Enter song duration (in seconds): ");

            // Break loop if valid duration
            if (songDuration >= 30) {
                break;
            }

            // ERROR: Invalid duration
            ConsoleUtils.errorMessage("Invalid input, song duration must at least be 30 seconds long", 3);
        }

        // Prompt user for song's file path
        while (true) {
            ConsoleUtils.clearScreen();
            Main.displayHeader();
            
            songFilePath = InputUtils.getString("Enter song file path: ");

            // ERROR: Blank input
            if (!songFilePath.equals("")) {
                break;
            }

            // Create a new file instance
            Path path = Paths.get(songFilePath);

            // If file exists, move the file to the 'music' folder
            if (Files.exists(path) && Files.isRegularFile(path) && path.toString().toLowerCase().endsWith(".mp3")) {
                Path target = Paths.get("music_collection/");
                try {
                    Files.move(path, target); 
                } catch (IOException e) {
                    ConsoleUtils.errorMessage(e.getMessage(), 3);
                } break;
            } else { // ERROR: Non-existing file
                ConsoleUtils.errorMessage("File does not exist or is not a valid format", 3);
            }
        }

        // After song info validation, create a new song and add it to the current playlist
        addSongToPlaylist((new Music(songTitle, songArtist, songAlbum, songGenre, songYear, songDuration)));
    }

    public void addSongToPlaylist(Music music) {
        songs.add(music);
        ConsoleUtils.animatedCharPrint(String.format("Song \"%s\" added to \"%s\" playlist.\n", music.getTitle(), getName()), 30);
    }
    
    public void removeSongFromPlaylist() {}

    public void renamePlaylist() {
        // Prompt user to enter a playlist name
        String newPlaylistName = InputUtils.getString("Enter a new playlist name: ");

        setName(newPlaylistName);
    }

    public void displaySongs() {
        int songNumber = 1;
       
        ConsoleUtils.animatedLinePrint(String.format("[ %s ]\n", getName()), 200);
        for (Music song : songs) {
            ConsoleUtils.animatedLinePrint(String.format("%d. %s\n", songNumber++, song.getTitle()), 200);
        } ConsoleUtils.displayFormat('#', 33);

        ConsoleUtils.pressToContinue();
    }
}
