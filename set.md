### **Set in Java**

**Set** is an interface in Java under the `java.util` package. It is part of the Collection Framework and represents a collection of unique elements. **Set** does not allow duplicate elements and has three primary implementations:

1. **HashSet**
2. **LinkedHashSet**
3. **TreeSet**

Below are detailed explanations, examples, pros, and cons for each implementation.

---

### **1. HashSet**

- **Definition**:  
  `HashSet` is a collection that uses a **hash table** for storing elements. It does not maintain the order of elements.

- **Key Features**:
  - Allows `null` elements.
  - Best for scenarios where **order does not matter** and **fast access** is required.

#### **Example 1: Basic Usage**

```java
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> fruits = new HashSet<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // Duplicate, will be ignored.

        System.out.println("HashSet: " + fruits);
    }
}
```

**Output**:  
`HashSet: [Banana, Orange, Apple]`  
_(Order may vary)_

#### **Real-Time Use Case**:

- Maintaining a set of unique **user IDs** in an application.

#### **Pros**:

1. **Fast operations**: O(1) for add, remove, and search.
2. Handles null values (only one null is allowed).

#### **Cons**:

1. Does not maintain order.
2. Performance decreases with high load factor or poor hash function.

---

### **2. LinkedHashSet**

- **Definition**:  
  `LinkedHashSet` is an implementation of the Set interface that uses a **linked list** in conjunction with a hash table. It maintains the **insertion order**.

- **Key Features**:
  - Maintains insertion order.
  - Slower than `HashSet` due to the overhead of maintaining the order.

#### **Example 2: Maintaining Order**

```java
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<String> cities = new LinkedHashSet<>();

        cities.add("New York");
        cities.add("London");
        cities.add("Paris");
        cities.add("New York"); // Duplicate, ignored.

        System.out.println("LinkedHashSet: " + cities);
    }
}
```

**Output**:  
`LinkedHashSet: [New York, London, Paris]`

#### **Real-Time Use Case**:

- Maintaining a list of **recently visited pages** in a web browser.

#### **Pros**:

1. Maintains insertion order.
2. Provides predictable iteration order.

#### **Cons**:

1. Slower than `HashSet`.
2. More memory usage due to doubly-linked list.

---

### **3. TreeSet**

- **Definition**:  
  `TreeSet` is an implementation of the Set interface that uses a **tree structure** (Red-Black Tree). It maintains elements in **sorted order**.

- **Key Features**:
  - Does not allow `null` elements.
  - Ensures **sorted order** of elements.
  - Best for scenarios where sorted data is required.

#### **Example 3: Sorted Order**

```java
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(50);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);

        System.out.println("TreeSet (Sorted): " + numbers);
    }
}
```

**Output**:  
`TreeSet (Sorted): [10, 20, 30, 50]`

#### **Real-Time Use Case**:

- Maintaining a **leaderboard** in a gaming application.

#### **Pros**:

1. Automatically sorts elements.
2. Supports custom sorting using a comparator.

#### **Cons**:

1. Slower operations: O(log n) for add, remove, and search.
2. Does not allow null values.

---

### **Comparison of HashSet, LinkedHashSet, and TreeSet**

| Feature         | HashSet        | LinkedHashSet          | TreeSet           |
| --------------- | -------------- | ---------------------- | ----------------- |
| **Order**       | No order       | Insertion order        | Sorted order      |
| **Performance** | Fastest (O(1)) | Slower than HashSet    | Slower (O(log n)) |
| **Null values** | 1 allowed      | 1 allowed              | Not allowed       |
| **Duplicates**  | Not allowed    | Not allowed            | Not allowed       |
| **Use Case**    | Unique IDs     | Recently visited pages | Leaderboard       |

---

### **Example 4: Using a Custom Comparator with TreeSet**

```java
import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetCustomComparatorExample {
    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<>(Comparator.reverseOrder());

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println("TreeSet (Custom Sorted): " + names);
    }
}
```

**Output**:  
`TreeSet (Custom Sorted): [Charlie, Bob, Alice]`

---

### **Conclusion**

- **HashSet**: Fast and suitable for cases where order does not matter.
- **LinkedHashSet**: Best when order is important.
- **TreeSet**: Ideal for maintaining sorted data but slower than other implementations.

---

### **Differences between Set, HashSet, and TreeSet in Java**

| **Aspect**                            | **Set** (Interface)                               | **HashSet** (Implementation)                               | **TreeSet** (Implementation)                             |
| ------------------------------------- | ------------------------------------------------- | ---------------------------------------------------------- | -------------------------------------------------------- |
| **Definition**                        | A collection that ensures no duplicate elements.  | Implements `Set` using a hash table.                       | Implements `Set` using a balanced tree (Red-Black Tree). |
| **Ordering**                          | No specific ordering as it is an interface.       | No guaranteed order.                                       | Maintains elements in **sorted order**.                  |
| **Null Elements**                     | Depends on the implementation.                    | Allows **one null element**.                               | **Does not allow null elements**.                        |
| **Performance (Add/Remove/Contains)** | Depends on the implementation.                    | O(1) average time complexity.                              | O(log n) time complexity.                                |
| **Duplicates**                        | Not allowed.                                      | Not allowed.                                               | Not allowed.                                             |
| **Iterating Order**                   | Not defined.                                      | Iteration order is unpredictable.                          | Iterates in **ascending sorted order**.                  |
| **Custom Sorting**                    | Not applicable (interface).                       | Not supported.                                             | Supported via `Comparator`.                              |
| **Implementation**                    | Provided by classes like `HashSet` and `TreeSet`. | Based on a **hash table**.                                 | Based on a **Red-Black tree**.                           |
| **Best Use Case**                     | Generic operations for unique collections.        | Fast access to unique elements without caring about order. | Maintaining a collection in sorted order.                |
| **Thread Safety**                     | Not inherently thread-safe.                       | Not thread-safe.                                           | Not thread-safe.                                         |
| **Memory Usage**                      | Depends on the implementation.                    | Relatively low.                                            | Higher due to tree structure overhead.                   |
| **Example**                           | `Set<Integer> set = new HashSet<>();`             | `HashSet<String> set = new HashSet<>();`                   | `TreeSet<Integer> set = new TreeSet<>();`                |
| **Use in Real Life**                  | A general contract for unique collections.        | Maintaining a list of unique IDs.                          | Creating a leaderboard or sorted log data.               |
