package OOP;

public class Counter {
    private static int counter = 0;
    private String id;

    // Constructor
    Counter() {
        counter++;
        this.id = "C" + counter;
        System.out.printf("Counter: %d\n", counter);
        System.out.printf("ID: %s\n", id);
    }

    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
    }
}