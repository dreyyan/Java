package DSA.PrintQueue;

public class PrintJob {
    // Attributes
    private int jobId;
    private String documentName;
    private int pageCount;
    private String owner;

    // Constructor
    public PrintJob(int jobId, String documentName, int pageCount, String owner) {
        this.jobId = jobId;
        this.documentName = documentName;
        this.pageCount = pageCount;
        this.owner = owner;
    }
   
    // Getters & Setters
    public int getJobId() { return this.jobId; }
    public String getDocumentName() { return this.documentName; }
    public int getPageCount() { return this.pageCount; }
    public String geOwner() { return this.owner; }
    
    public void setJobId(int jobId) { this.jobId = jobId; }
    public void setDocumentName(String documentName) { this.documentName = documentName; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }
    public void setOwner(String owner) { this.owner = owner; }

    // Methods
    
}
