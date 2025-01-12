### Inheritance in Java

**Definition**:  
Inheritance is a mechanism in object-oriented programming (OOP) that allows one class (child/subclass) to inherit properties and behaviors (fields and methods) from another class (parent/superclass). It promotes code reuse and establishes a relationship between classes.

### Types of Inheritance in Java:

1. **Single Inheritance**
2. **Multilevel Inheritance**
3. **Hierarchical Inheritance**
4. **Multiple Inheritance (through interfaces)**
5. **Hybrid Inheritance (via interfaces)**

---

### 1. **Single Inheritance**

**Definition**:  
In single inheritance, a class inherits from one parent class only. The subclass gains the properties and behaviors of the single parent class.

**Example**:

```java
// File: Animal.java (Parent class)
class Animal {
    void eat() {
        System.out.println("Eating food...");
    }
}

// File: Dog.java (Child class)
class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();  // Inherited method
        d.bark(); // Own method
    }
}
```

**Pros**:

- Simplicity: Easy to understand and implement.
- Code Reusability: Subclasses reuse parent class methods and properties.

**Cons**:

- Limited flexibility: Can only inherit from one class, which can be limiting in some cases.

**Application**:  
Used in simple systems where relationships are straightforward, such as creating animal hierarchies (e.g., Animal -> Dog, Cat).

---

### 2. **Multilevel Inheritance**

**Definition**:  
Multilevel inheritance involves a hierarchy where a class inherits from another class, which in turn inherits from another class, forming a chain.

**Example**:

```java
// File: Animal.java (Grandparent class)
class Animal {
    void eat() {
        System.out.println("Eating food...");
    }
}

// File: Dog.java (Parent class)
class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

// File: Puppy.java (Child class)
class Puppy extends Dog {
    void play() {
        System.out.println("Playing...");
    }
}

public class Main {
    public static void main(String[] args) {
        Puppy p = new Puppy();
        p.eat();  // Inherited from Animal
        p.bark(); // Inherited from Dog
        p.play(); // Own method
    }
}
```

**Pros**:

- Code Reusability: Benefits from inherited functionality from multiple levels.
- Flexibility: It provides a clear hierarchy for extending functionalities.

**Cons**:

- Complexity: The class hierarchy can become complex and difficult to manage if it grows too deep.

**Application**:  
Used in systems with layered hierarchies, such as creating subclasses of vehicle types (e.g., Vehicle -> Car -> SportsCar).

---

### 3. **Hierarchical Inheritance**

**Definition**:  
In hierarchical inheritance, multiple subclasses inherit from a single parent class. All child classes share the same parent, but each subclass can add its own features.

**Example**:

```java
// File: Animal.java (Parent class)
class Animal {
    void eat() {
        System.out.println("Eating food...");
    }
}

// File: Dog.java (Child class 1)
class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

// File: Cat.java (Child class 2)
class Cat extends Animal {
    void meow() {
        System.out.println("Meowing...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();

        Cat c = new Cat();
        c.eat();
        c.meow();
    }
}
```

**Pros**:

- Code Reusability: Common functionality is shared across subclasses.
- Easier to manage shared behavior in one place.

**Cons**:

- Lack of flexibility: All child classes share the same parent, which can lead to issues when trying to modify or extend the parent class.

**Application**:  
Ideal for systems where several classes share common properties and methods but need their own specific behaviors (e.g., Animal -> Dog, Cat, Fish).

---

### 4. **Multiple Inheritance (Through Interfaces)**

**Definition**:  
Java does not support multiple inheritance through classes, but it allows a class to implement multiple interfaces. Multiple inheritance in Java can be achieved using interfaces, where a class can inherit behaviors from more than one interface.

**Example**:

```java
// File: Animal.java (Interface)
interface Animal {
    void eat();
}

// File: Barkable.java (Interface)
interface Barkable {
    void bark();
}

// File: Dog.java (Class implementing both interfaces)
class Dog implements Animal, Barkable {
    public void eat() {
        System.out.println("Eating food...");
    }

    public void bark() {
        System.out.println("Barking...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();
    }
}
```

**Pros**:

- Provides flexibility by allowing a class to inherit behaviors from multiple interfaces.
- Avoids ambiguity seen in multiple inheritance through classes.

**Cons**:

- Does not inherit implementation, only method signatures (so you must implement methods).
- Can become complex if too many interfaces are used.

**Application**:  
Used in systems where a class needs to adopt behaviors from multiple unrelated sources, like implementing multiple functional interfaces (e.g., Runnable, Comparable).

---

### 5. **Hybrid Inheritance (via Interfaces)**

**Definition**:  
Hybrid inheritance is a combination of more than one type of inheritance. In Java, this can be achieved using interfaces and classes together.

**Example**:

```java
// File: Animal.java (Interface)
interface Animal {
    void eat();
}

// File: Flyable.java (Interface)
interface Flyable {
    void fly();
}

// File: Bird.java (Class inheriting from Animal and Flyable)
class Bird implements Animal, Flyable {
    public void eat() {
        System.out.println("Eating...");
    }

    public void fly() {
        System.out.println("Flying...");
    }
}

public class Main {
    public static void main(String[] args) {
        Bird b = new Bird();
        b.eat();
        b.fly();
    }
}
```

**Pros**:

- Combines multiple types of inheritance and allows for more complex designs.
- Provides flexibility in design by allowing a class to implement multiple interfaces while extending another class.

**Cons**:

- Can lead to confusion and complexity if overused.
- Requires careful design to avoid conflicts and maintain clarity.

**Application**:  
Ideal for large-scale applications where classes need to inherit various capabilities from multiple sources (e.g., a class could implement both behavioral and functional interfaces).

---

### Conclusion on Where to Apply Inheritance in Bigger Application Building:

1. **Single Inheritance**:  
   Best for simple use cases where a class shares properties and methods from only one other class (e.g., base class `Vehicle` -> subclass `Car`).

2. **Multilevel Inheritance**:  
   Useful for creating a chain of responsibility or deep class hierarchies where a class progressively builds on another class (e.g., `Employee` -> `Manager` -> `Director`).

3. **Hierarchical Inheritance**:  
   Suitable when multiple classes share common functionality but have distinct behaviors (e.g., `Employee` -> `Engineer`, `HR`).

4. **Multiple Inheritance (via Interfaces)**:  
   Best when a class needs to inherit functionality from multiple sources without creating an ambiguous class hierarchy (e.g., `Runnable`, `Serializable` interfaces).

5. **Hybrid Inheritance**:  
   Ideal for complex systems where a class needs to adopt behaviors from both a class and multiple interfaces (e.g., `AbstractShape` class with interfaces like `Drawable`, `Movable`).
