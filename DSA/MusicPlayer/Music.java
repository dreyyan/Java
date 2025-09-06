package MusicPlayer;
import Utility.ConsoleUtils;
import Utility.InputUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Music {
    // Attributes
    private String title;
    private String artist;
    private String album;
    private String genre;

    private int year;
    private int duration; // in seconds

    private String filePath;

    // Parameterized Constructor
    public Music(String title, String artist, String album, String genre, int year, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
    }

    // Getters
    public String getTitle() { return this.title; }
    public String getArtist() { return this.artist; }
    public String getAlbum() { return this.album; }
    public String getGenre() { return this.genre; }

    public int getYear() { return this.year; }
    public int getDuration() { return this.duration; }
    
    public String getFilePath() { return this.filePath; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setAlbum(String album) { this.album = album; }
    public void setGenre(String genre) { this.genre = genre; }

    public void setYear(int year) { this.year = year; }
    public void setDuration(int duration) { this.duration = duration; }
    
    public void setFilePath(String filePath) { this.filePath = filePath; }

    // Methods
    public void editMusicDetails() {
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
            if (songAlbum.equals("")) {
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
            if (songYear >= 1900 && songYear <= currentYear) {
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

            // Create a new file instance
            Path path = Paths.get(songFilePath);

            // If file exists, move the file to the 'music' folder
            if (Files.exists(path) && Files.isRegularFile(path) && path.toString().toLowerCase().endsWith(".mp3")) {
                Path targetDir = Paths.get("music_collection");
                try {
                    // Ensure the target directory exists
                    Files.createDirectories(targetDir);
                    Path target = targetDir.resolve(path.getFileName());
                    Files.move(path, target);
                    songFilePath = target.toString(); // Update songFilePath to new location
                    break;
                } catch (IOException e) {
                    ConsoleUtils.errorMessage("Error moving file: " + e.getMessage(), 3);
                }
            } else {
                ConsoleUtils.errorMessage("File does not exist or is not a valid MP3 format", 3);
            }
        }

        // After song info validation, update song details
        setTitle(songTitle);
        setArtist(songArtist);
        setAlbum(songAlbum);
        setGenre(songGenre);
        setYear(songYear);
        setDuration(songDuration);
        setFilePath(songFilePath);
    }
}
