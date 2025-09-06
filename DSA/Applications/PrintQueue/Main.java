package DSA.PrintQueue;

public class Main {
    public static void main(String[] args) {
        // Create a 'Printer' instance
        Printer EPSON_L3250 = new Printer("EPSON L3250", 15, 0, 5);
        int numOfJobs = 3;

        // Create random queue jobs
        EPSON_L3250.createRandomJobs(EPSON_L3250, numOfJobs);

        while (numOfJobs-- > 0) {
            EPSON_L3250.processJob();
        } System.out.println(">> All jobs finished.");
    }
}
