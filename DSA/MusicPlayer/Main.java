package MusicPlayer;

import Utility.ConsoleUtils;

public class Main {
    // Methods
    public static void displayMenu() {
        int operationsCounter = 1;
        String[] operations = {
            "Create Playlist", "Open Playlist",
            "Rename Playlist", "Delete Playlist"
        };

        ConsoleUtils.animatedPrint("[ Music Player ]", 30);
        ConsoleUtils.animatedPrint("My Playlists", 30);
        ConsoleUtils.animatedPrint(String.format("[%d] %s"), 30);
        
    }

    public static void main(String[] args) {
        Music barney = new Music("Barney", "Barney the Dinosaur", "Barney I", "Kids", 2005, 300);
        Music shapeOfYou = new Music("Shape of You", "Ed Sheeran", "Divide", "Pop", 2017, 263);
        Music bohemianRhapsody = new Music("Bohemian Rhapsody", "Queen", "A Night at the Opera", "Rock", 1975, 354);
        Music imagine = new Music("Imagine", "John Lennon", "Imagine", "Soft Rock", 1971, 183);
    }
}