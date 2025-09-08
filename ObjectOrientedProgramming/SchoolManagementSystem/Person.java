public class Person {
    // Attributes
    protected String name;
    protected int age;
    protected int id;

    // Getters & Setters
    public String getName() { return this.name; }
    public int getAge() { return this.age; }
    public int getId() { return this.id; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setId(int id) { this.id = id; }

    // Default Constructor
    public Person() {}
    
    // Parameterized Constructor
    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    
    // Methods
    public void displayInformation() {
        System.out.println("[ PERSONAL INFORMATION ]");
        System.out.println("=".repeat(30));
        System.out.printf("Name: %s\n", getName());
        System.out.printf("Age: %s\n", getAge());
        System.out.printf("ID: %s\n", getId());
        System.out.println("=".repeat(30));
    }
}