package OOP.ZooManagementSystem.animals;
import OOP.ZooManagementSystem.characteristics.Characteristics;
import OOP.ZooManagementSystem.interfaces.Domesticated;
import OOP.ZooManagementSystem.interfaces.HasPaws;
import OOP.ZooManagementSystem.interfaces.Vocalized;

public class Dog extends Animal implements Domesticated, HasPaws, Vocalized {
    // ATTRIBUTES
    protected Characteristics.Color pawColor;

    // Parameterized Constructor
    Dog(String name, int age, Characteristics.Color color, float weight, String species, String habitat, Characteristics.HealthStatus healthStatus) {
        super(name, age, color, weight, species, habitat, healthStatus);
    }

    // METHODS
    // Domesticated (I)
    @Override
    public void obeyCommand(String command) {}

    @Override
    public void followCaretaker() {}

    @Override
    public boolean isTrained() { return false; }

    // HasPaws (I)
    @Override
    public Characteristics.Color getPawColor() { return this.pawColor; }

    @Override
    public void setPawColor(Characteristics.Color color) { this.pawColor = color; }

    // Vocalized (I)
    @Override
    public void makeSound() { System.out.println("*woof*"); }
}
