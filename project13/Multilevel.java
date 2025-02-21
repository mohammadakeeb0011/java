// Base class
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Derived class (inherits from Animal)
class Mammal extends Animal {
    void walk() {
        System.out.println("Mammal is walking");
    }
}

// Another derived class (inherits from Mammal)
class Dog extends Mammal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

// Main class to test the multi-level inheritance
public class Multilevel {
    public static void main(String[] args) {
        Dog dog = new Dog();

        // Calling methods from all levels of inheritance
        dog.eat();    // Inherited from Animal class
        dog.walk();   // Inherited from Mammal class
        dog.bark();   // Defined in Dog class
    }
}
