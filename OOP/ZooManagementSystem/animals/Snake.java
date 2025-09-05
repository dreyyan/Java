package OOP.ZooManagementSystem.animals;
import OOP.ZooManagementSystem.interfaces.Mobile;
import OOP.ZooManagementSystem.interfaces.Reptile;

public class Snake implements Mobile, Reptile {
    // Mobile (I)
    public void move() {
        System.out.println("* the snake is crawling *");
    }

    // Reptile (I)
    public void shedSkin() {
        System.out.println("* the snake is performing ecdysis... *");
    }
}
