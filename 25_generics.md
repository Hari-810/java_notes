### **Generics in Java**

Generics in Java enable types (classes and interfaces) to be parameterized, allowing for type safety and reusability without the need for casting or runtime type errors. Generics are introduced in Java 5 and primarily used in **collections**, but they can also be applied to methods, classes, and interfaces.

---

### **Features of Generics**

1. **Type Safety**: Compile-time type checking avoids ClassCastException at runtime.
2. **Code Reusability**: Same code works for different types.
3. **Elimination of Casting**: Casting is not required as the type is defined.
4. **Flexibility**: It supports various data structures like collections.

---

### **Example 1: Generic Class**

#### **Concept: Generic Classes**

Generic classes allow defining a class with a placeholder for types.

```java
// Generic Box Class
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

public class GenericExample1 {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.set(10);
        System.out.println("Integer Box: " + integerBox.get());

        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");
        System.out.println("String Box: " + stringBox.get());
    }
}
```

**Pros:**

- Reusability: Works for `Integer` and `String` without separate classes.
- Type Safety: `set()` and `get()` enforce the correct type.

**Cons:**

- Slightly more complex syntax compared to non-generic classes.

**Real-Time Example:**
This is commonly used in custom data structures like **stack**, **queue**, or **containers**.

---

### **Example 2: Generic Method**

#### **Concept: Generic Methods**

Methods can also use generics independently of the class's generic type.

```java
class Utility {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

public class GenericExample2 {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4};
        String[] stringArray = {"A", "B", "C"};

        Utility.printArray(intArray);  // Prints: 1 2 3 4
        Utility.printArray(stringArray);  // Prints: A B C
    }
}
```

**Pros:**

- Reusable for any array type.
- Reduces redundancy.

**Cons:**

- Debugging is harder if generic type misuse occurs.

**Real-Time Example:**
Used in utility libraries like **Apache Commons** and **Guava** for sorting, filtering, or array manipulation.

---

### **Example 3: Generic Interface**

#### **Concept: Defining a Generic Interface**

A generic interface can allow flexible implementations.

```java
interface Calculator<T> {
    T add(T a, T b);
}

class IntegerCalculator implements Calculator<Integer> {
    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }
}

class StringConcatenator implements Calculator<String> {
    @Override
    public String add(String a, String b) {
        return a + b;
    }
}

public class GenericExample3 {
    public static void main(String[] args) {
        Calculator<Integer> intCalc = new IntegerCalculator();
        System.out.println("Integer Add: " + intCalc.add(10, 20));

        Calculator<String> stringCalc = new StringConcatenator();
        System.out.println("String Add: " + stringCalc.add("Hello, ", "Generics!"));
    }
}
```

**Pros:**

- Enables a single interface for diverse implementations.
- Enforces type safety for interface contracts.

**Cons:**

- Implementation complexity increases with multiple generic parameters.

**Real-Time Example:**
Generic interfaces are extensively used in frameworks like **Spring Data** for repository patterns.

---

### **Example 4: Bounded Generics**

#### **Concept: Restricting Types**

Generics can be bounded using `extends` (upper bound) or `super` (lower bound).

```java
class BoundExample<T extends Number> {
    private T value;

    public BoundExample(T value) {
        this.value = value;
    }

    public T square() {
        return (T) Double.valueOf(value.doubleValue() * value.doubleValue());
    }
}

public class GenericExample4 {
    public static void main(String[] args) {
        BoundExample<Integer> intExample = new BoundExample<>(5);
        System.out.println("Square of 5: " + intExample.square());

        BoundExample<Double> doubleExample = new BoundExample<>(4.2);
        System.out.println("Square of 4.2: " + doubleExample.square());
    }
}
```

**Pros:**

- Flexibility to apply generics with constraints.
- Ensures operations like arithmetic work correctly.

**Cons:**

- Restricts type usage to certain bounds.

**Real-Time Example:**
Used in scientific computations or **data processing frameworks** for number-based operations.

---

### **Example 5: Wildcards in Generics**

#### **Concept: Unbounded and Bounded Wildcards**

Wildcards (`?`) allow for flexibility in accepting multiple types.

```java
import java.util.List;

class WildcardExample {
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}

public class GenericExample5 {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3);
        List<String> strList = List.of("A", "B", "C");

        WildcardExample.printList(intList); // Prints: 1 2 3
        WildcardExample.printList(strList); // Prints: A B C
    }
}
```

**Pros:**

- Flexibility in method arguments.
- Suitable for read-only scenarios.

**Cons:**

- Modifications to wildcard collections are restricted.

**Real-Time Example:**
Used in methods like **Collections.sort()** or **stream pipelines** where the exact type may vary.

---

### **Advantages of Generics**

1. **Code Reusability:** One implementation works for all data types.
2. **Type Safety:** Reduces runtime errors.
3. **Better Performance:** Avoids runtime casting overhead.

---

### **Disadvantages of Generics**

1. **Complexity:** Syntax can be intimidating for beginners.
2. **Type Erasure:** Generics are removed at runtime, leading to limitations (e.g., no `T` arrays).
3. **Reflection Issues:** Difficult to work with generics and reflection together.

---

### **Real-Time Applications**

1. **Collections Framework:** `ArrayList<E>`, `HashMap<K, V>` are built using generics.
2. **Custom Frameworks:** Logging libraries or data structures use generic methods.
3. **APIs:** APIs like **Retrofit** use generics to handle different data models.

Would you like further elaboration on any specific topic?
