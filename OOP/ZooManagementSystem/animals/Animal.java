package OOP.ZooManagementSystem.animals;
import OOP.ZooManagementSystem.characteristics.Characteristics;

public class Animal {

    // ATTRIBUTES
    protected String name;
    protected int age;
    protected Characteristics.Color color;
    protected float weight;
    protected String species;
    protected String habitat;
    protected Characteristics.HealthStatus healthStatus;

    // Default Constructor
    public Animal() {}

    // Parameterized Constructor
    public Animal(String name, int age, Characteristics.Color color, float weight, String species, String habitat, Characteristics.HealthStatus healthStatus) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
        this.species = species;
        this.habitat = habitat;
        this.healthStatus = healthStatus;
    }

    // METHODS
    public void displayCharacteristics() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Color: " + color);
        System.out.println("Weight: " + weight);
        System.out.println("Species: " + species);
        System.out.println("Habitat: " + habitat);
        System.out.println("Health Status: " + healthStatus);
    }
}
