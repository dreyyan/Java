package OOP.ZooManagementSystem.animals;

import OOP.ZooManagementSystem.interfaces.Viviparous;

public class Kangaroo implements Mammal, Viviparous {
    void regulateBodyTemperature() {
        System.out.println("* regulating body temperature... *");
    }
}
