package DSA.PrintQueue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Printer {
    static Scanner scanner = new Scanner(System.in);
    
    // Attributes
    private String name;
    private PrinterStatus status;
    private int pagesPerMinute; // speed of printer
    private int totalPagesPrinted;
    private int maxQueueSize;
    public Queue<PrintJob> queue = new LinkedList<>();

    // Constructor
    public Printer(String name, int pagesPerMinute, int totalPagesPrinted, int maxQueueSize) {
        this.name = name;
        this.pagesPerMinute = pagesPerMinute;
        this.totalPagesPrinted = totalPagesPrinted;
        this.maxQueueSize = maxQueueSize;
        status = PrinterStatus.IDLE; // Set to idle by default
    }

    // Getters & Setters
    public String getName() { return this.name; }
    public PrinterStatus getStatus() { return this.status; }
    public int getPagesPerMinute() { return this.pagesPerMinute; }
    public int getTotalPagesPrinted() { return this.totalPagesPrinted; }
    public int getMaxQueueSize() { return this.maxQueueSize; }
    
    public void setName(String name) { this.name = name; }
    public void setStatus(PrinterStatus status) { this.status = status; }
    public void setPagesPerMinute(int pagesPerMinute) { this.pagesPerMinute = pagesPerMinute; }
    public void setTotalPagesPrinted(int totalPagesPrinted) { this.totalPagesPrinted = totalPagesPrinted; }
    public void setMaxQueueSize(int maxQueueSize) { this.maxQueueSize = maxQueueSize; }

    // Methods
    public void turnOff() {
        setStatus(PrinterStatus.OFFLINE);
        System.out.printf("Printer '%s' is now OFFLINE\n", getName());
    }

    public void turnOn() {
        setStatus(PrinterStatus.IDLE);
        System.out.printf("Printer '%s' is now IDLE\n", getName());
    }

    public void setPrintingMode() {
        setStatus(PrinterStatus.PRINTING);
        System.out.printf("Printer '%s' is now PRINTING\n", getName());
    }
    

    public void setErrorMode() {
        String userChoice;

        setStatus(PrinterStatus.ERROR);
        System.out.printf("Printer '%s' had errors when printing\n", getName());

        while (true) {
            System.out.print("Resolve errors? [y/n]: ");
            userChoice = scanner.nextLine().trim();

            if (!userChoice.equalsIgnoreCase("y") && !userChoice.equalsIgnoreCase("n")) {
                System.out.println("ERROR: Invalid input, please try again");
            } else break;
        }

        if (userChoice.equalsIgnoreCase("y")) {
            System.out.println("resolving errors...");

            try {
                Thread.sleep((60 / getPagesPerMinute()) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Resolve errors
            setStatus(PrinterStatus.IDLE);
            System.out.println("* errors resolved *");
        }
    }

    // [ METHOD ]: Add a document for the printer to process
    public void addJob(PrintJob printJob) {
        queue.offer(printJob); // Queue the print job
        System.out.printf("* Print job '%d' (%s, %d pages, submitted by %s) *\n", printJob.getJobId(), printJob.getDocumentName(), printJob.getPageCount(), printJob.geOwner());
    }

    public void processJob() {
        // ERROR: Empty queue
        if (queue.isEmpty()) {
            System.out.println("No jobs in queue.");
        }

        switch (getStatus()) {
            // ERROR: Offline printer
            case PrinterStatus.OFFLINE -> { System.out.println("ERROR: Printer is offline"); return; }
            // ERROR: Busy printer
            case PrinterStatus.PRINTING -> { System.out.println("ERROR: Printer is busy"); return; }
            // ERROR: Unresolved printer errors
            case PrinterStatus.ERROR -> { System.out.println("ERROR: Printer has unresolved errors"); return; }
        }

        // Retrieve next job
        PrintJob currentJob = queue.poll();

        // Simulate printing
        System.out.printf(">> printing '%s'... (%d pages)\n", currentJob.getDocumentName(), currentJob.getPageCount());

        try {
            Thread.sleep((60 / getPagesPerMinute()) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Finish job
        setTotalPagesPrinted(getTotalPagesPrinted() + 1);
        System.out.println(">> Job completed.");
    }

    public void createRandomJobs(Printer printer, int numOfJobs) {
        Random random = new Random();

        // ERROR: Queue size exceeds max queue size
        if (printer.queue.size() >= printer.getMaxQueueSize()) {
            System.out.println("ERROR: Max queue size");
            return;
        }

        for (int i = 1; i <= numOfJobs; ++i) {
            String docName = "Doc_" + i;
            int pageCount = random.nextInt(20) + 1;
            String owner = "User" + random.nextInt(100) + 1;

            printer.addJob(new PrintJob(i, docName, pageCount, owner));
        }

        System.out.printf("* %d random queue jobs added *\n", numOfJobs);
    }
}