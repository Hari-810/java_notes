## Encapsulation

**Encapsulation in Java:**

**Definition:**
Encapsulation is one of the four fundamental Object-Oriented Programming (OOP) concepts. It is the process of bundling the data (variables) and the methods (functions) that operate on the data into a single unit called a class. In encapsulation, the data is hidden from the outside world and can only be accessed through getter and setter methods. This provides a protective barrier that prevents direct access to the data fields and ensures controlled access.

**Key Points:**

1. **Private Fields**: The data members (fields) of a class are usually made private to restrict direct access.
2. **Public Methods (Getters/Setters)**: Methods are provided to access and modify the private fields (i.e., getters and setters).
3. **Control Over Data**: It allows controlling how the fields are accessed or modified, for example, adding validation logic in the setters.

### Example:

**File: `Person.java`**

```java
// Class demonstrating encapsulation
public class Person {
    // Private fields (encapsulation)
    private String name;
    private int age;

    // Constructor to initialize the object
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter method for 'name'
    public String getName() {
        return name;
    }

    // Setter method for 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for 'age'
    public int getAge() {
        return age;
    }

    // Setter method for 'age'
    public void setAge(int age) {
        if (age > 0) {  // Validation before setting the age
            this.age = age;
        } else {
            System.out.println("Age must be positive.");
        }
    }

    // Method to display person's details
    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
    }
}
```

**File: `Main.java`**

```java
// Main class to demonstrate the usage of Person class
public class Main {
    public static void main(String[] args) {
        // Create an object of Person
        Person person = new Person("John Doe", 30);

        // Display initial details
        person.displayDetails();

        // Modify fields using setter methods (encapsulation)
        person.setName("Jane Doe");
        person.setAge(25);

        // Display modified details
        person.displayDetails();
    }
}
```

### Output:

```
Name: John Doe
Age: 30
Name: Jane Doe
Age: 25
```

### Pros of Encapsulation:

1. **Data Hiding**: It hides the internal state of objects and only exposes methods to access and update the data, preventing external interference.
2. **Controlled Access**: Through setter and getter methods, you can validate and control the data (e.g., ensuring that invalid data is not set).
3. **Flexibility and Maintainability**: The internal implementation of the class can be changed without affecting the external interface.
4. **Improved Security**: Sensitive data can be protected and access can be limited.

### Cons of Encapsulation:

1. **Increased Complexity**: For simple programs, encapsulation might feel like an overhead.
2. **Extra Code**: You need to write extra getter and setter methods, which could increase the number of lines of code.
3. **Performance Overhead**: In some cases, if excessive getter and setter methods are used, it could slightly affect performance.

### Where to Apply Encapsulation in Bigger Applications:

1. **Data Security**: Encapsulation is essential when building large systems where data security is critical. By keeping data private and controlling its access, you can ensure the integrity and validity of your data.

   - Example: In banking applications, user account details such as balance and personal information should be private and only modified through secure methods.

2. **Maintainability**: Large applications require modular code. Encapsulation helps isolate the internal workings of an object, which makes maintaining and debugging easier.

   - Example: In e-commerce applications, encapsulating product data (like price, stock count, and description) helps in managing changes to the product without affecting other parts of the application.

3. **API Design**: Encapsulation is useful in designing clean and clear APIs. It hides the complexities of the implementation while exposing simple methods for users to interact with the data.

   - Example: When building a library or framework, encapsulating internal functionality and exposing only necessary methods to the users is crucial.

4. **Data Validation**: Encapsulation is often used in business logic to ensure that any changes to an object’s state adhere to specific rules and constraints.

   - Example: In a payroll system, employee salary could be encapsulated with setter methods that ensure the salary cannot be set below a minimum threshold.

In summary, encapsulation is a core concept of OOP that helps maintain data integrity, flexibility, and security, and it is widely used in large-scale application development to ensure clean, maintainable, and modular code.

---

The `final` keyword in Java is used to declare constants, prevent method overriding, and prevent inheritance. It can be applied to variables, methods, and classes. Here's how it is used in different contexts:

## 1. **Final Variables (Constants):**

A `final` variable can only be assigned once, meaning that its value cannot be changed after initialization. This is commonly used to define constants.

```java
class Circle {
    final double PI = 3.14;  // Constant value

    double area(double radius) {
        return PI * radius * radius;  // PI cannot be changed
    }
}
```

- **Note:** If a `final` variable is a reference type (like an array or object), the reference itself cannot be changed, but the object's content can still be modified unless the object itself is immutable.

### 2. **Final Methods:**

A `final` method cannot be overridden by subclasses. This ensures that the implementation of the method remains unchanged in the child class.

```java
class Animal {
    final void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    // Error: Cannot override the final method sound() from Animal
    // void sound() {
    //     System.out.println("Dog barks");
    // }
}
```

### 3. **Final Classes:**

A `final` class cannot be subclassed (inherited from). This is used to prevent modification of the class behavior or structure.

```java
final class Immutable {
    int value;

    Immutable(int value) {
        this.value = value;
    }
}

// Error: Cannot subclass final class Immutable
// class ExtendedImmutable extends Immutable {
//     ExtendedImmutable(int value) {
//         super(value);
//     }
// }
```

### 4. **Final Parameters:**

A `final` parameter in a method or constructor means that the parameter's value cannot be changed inside the method or constructor. This ensures that the parameter remains constant.

```java
class Calculator {
    void add(final int a, final int b) {
        // a = 10;  // Error: Cannot assign a value to final variable 'a'
        System.out.println(a + b);
    }
}
```

### 5. **Final with References:**

The `final` keyword, when used with a reference variable (like an object reference), means the reference cannot be changed, but the object itself can still be modified (if it is mutable).

```java
class MyClass {
    final int[] arr = new int[5];

    void modifyArray() {
        arr[0] = 10;  // Allowed: array contents can be modified
        // arr = new int[10];  // Error: Cannot assign a new reference to 'arr'
    }
}
```

### Key Points:

- **Final Variables:** Constants, their values cannot be changed after initialization.
- **Final Methods:** Cannot be overridden in subclasses.
- **Final Classes:** Cannot be subclassed.
- **Final Parameters:** Cannot be modified within the method.
- **Final References:** Reference cannot be changed, but the object’s state may still be mutable.

The `final` keyword is crucial for controlling immutability, inheritance, and method overriding in Java, ensuring that certain aspects of the code remain unchanged or protected from modification.
