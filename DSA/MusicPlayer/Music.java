package MusicPlayer;

import Utility.ConsoleUtils;

public class Music {
    // Attributes
    private String title;
    private String artist;
    private String album;
    private String genre;

    private int year;
    private int duration; // in seconds

    private String filePath;

    // Default Constructor
    public Music() {}

    // Parameterized Constructor
    public Music(String title, String artist, String album, String genre, int year, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.year = year;
        this.duration = duration;

        // Display notification when creating a new music
        ConsoleUtils.animatedPrint(String.format("'%s' by %s was added successfully.\n", title, artist), 30);
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
    public void editMusicDetails() {}
}
