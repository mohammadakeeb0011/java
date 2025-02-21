// Base class
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Derived class (inherits from Animal)
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

// Main class to test the single inheritance
public class Single {
    public static void main(String[] args) {
        Dog dog = new Dog();

        // Calling methods from both the parent and child classes
        dog.eat();    // Inherited from Animal class
        dog.bark();   // Defined in Dog class
    }
}
