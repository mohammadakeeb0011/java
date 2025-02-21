// Base class
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Derived class 1 (inherits from Animal)
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

// Derived class 2 (inherits from Animal)
class Cat extends Animal {
    void meow() {
        System.out.println("Cat is meowing");
    }
}

// Derived class 3 (inherits from Animal)
class Bird extends Animal {
    void fly() {
        System.out.println("Bird is flying");
    }
}

// Main class to test hierarchical inheritance
public class Hierarchical {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Bird bird = new Bird();

        // Calling methods on Dog object
        dog.eat();     // Inherited from Animal class
        dog.bark();    // Defined in Dog class

        // Calling methods on Cat object
        cat.eat();     // Inherited from Animal class
        cat.meow();    // Defined in Cat class

        // Calling methods on Bird object
        bird.eat();    // Inherited from Animal class
        bird.fly();    // Defined in Bird class
    }
}
