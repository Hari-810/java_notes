### Map, HashMap, and TreeMap in Java

In Java, the `Map` interface represents a collection of key-value pairs, where each key is associated with exactly one value. It provides methods for adding, removing, and accessing elements based on keys. `HashMap` and `TreeMap` are two common implementations of the `Map` interface, each with different characteristics, behaviors, and use cases.

### 1. **Map (Interface)**

The `Map` interface is part of the `java.util` package and provides a basic contract for all map implementations. It does not allow duplicate keys and requires each key to map to one unique value.

**Key Methods in Map Interface:**

- `put(K key, V value)`: Inserts a key-value pair into the map.
- `get(Object key)`: Retrieves the value associated with the given key.
- `remove(Object key)`: Removes the key-value pair associated with the specified key.
- `containsKey(Object key)`: Checks if a key is present in the map.
- `containsValue(Object value)`: Checks if a value is present in the map.

**Example of `Map` (using `HashMap` as implementation):**

```java
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);

        System.out.println("Value for 'Banana': " + map.get("Banana"));
        System.out.println("Contains 'Cherry'? " + map.containsKey("Cherry"));
        System.out.println("Size of Map: " + map.size());
    }
}
```

**Output:**

```
Value for 'Banana': 20
Contains 'Cherry'? true
Size of Map: 3
```

---

### 2. **HashMap (Implementation of Map)**

`HashMap` is an implementation of the `Map` interface that stores key-value pairs in a hash table. It allows **null** values and **null keys**. `HashMap` does not guarantee any specific order of the elements.

**Characteristics of `HashMap`:**

- **Time Complexity:** Average `O(1)` for `put()`, `get()`, and `remove()`.
- **Order:** No ordering guarantee (elements are unordered).
- **Null Handling:** Allows one `null` key and multiple `null` values.

**Example of `HashMap`:**

```java
import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("John", 25);
        hashMap.put("Emma", 30);
        hashMap.put("Lucas", 35);

        // Accessing values
        System.out.println("Age of Emma: " + hashMap.get("Emma"));

        // Checking if a key exists
        if (hashMap.containsKey("John")) {
            System.out.println("John's age: " + hashMap.get("John"));
        }

        // Iterating over the entries
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
```

**Output:**

```
Age of Emma: 30
John's age: 25
John - 25
Emma - 30
Lucas - 35
```

**Pros of HashMap:**

- Fast lookup, insertion, and deletion on average.
- Allows `null` key and values.
- Highly suitable for scenarios where element order does not matter.

**Cons of HashMap:**

- Unpredictable order of elements.
- Not thread-safe by default.
- No guarantee of performance under high collisions.

**Real-Time Example:**

- **HashMap** is often used in situations where quick lookups are needed, like in **caching** scenarios (e.g., storing session information in a web application).

---

### 3. **TreeMap (Implementation of Map)**

`TreeMap` is another implementation of the `Map` interface that stores key-value pairs in a red-black tree. It maintains **sorted order** of the keys based on their natural ordering or according to a custom comparator.

**Characteristics of `TreeMap`:**

- **Time Complexity:** `O(log n)` for `put()`, `get()`, and `remove()` due to the underlying balanced tree structure.
- **Order:** Maintains ascending order of keys, or custom order based on comparator.
- **Null Handling:** Does not allow `null` keys, but allows `null` values.

**Example of `TreeMap`:**

```java
import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Banana", 10);
        treeMap.put("Apple", 20);
        treeMap.put("Cherry", 15);

        System.out.println("Sorted TreeMap: " + treeMap);

        // Retrieving a value
        System.out.println("Value for 'Apple': " + treeMap.get("Apple"));

        // Iterating over the TreeMap
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
```

**Output:**

```
Sorted TreeMap: {Apple=20, Banana=10, Cherry=15}
Value for 'Apple': 20
Apple - 20
Banana - 10
Cherry - 15
```

**Pros of TreeMap:**

- Keys are always sorted (either naturally or based on a comparator).
- Suitable for scenarios where sorted order or range-based queries are required.
- Provides efficient navigation methods like `firstKey()`, `lastKey()`, and `subMap()`.

**Cons of TreeMap:**

- Slower than `HashMap` for basic operations due to the tree structure (average `O(log n)` complexity).
- Does not allow `null` keys.

**Real-Time Example:**

- **TreeMap** is ideal for **sorted data storage** such as in **financial applications** where transaction history needs to be sorted by date, or in **leaderboards** where players are ranked in ascending order of their scores.

---

### Summary Comparison Table

| Feature              | **Map**          | **HashMap**                                | **TreeMap**                      |
| -------------------- | ---------------- | ------------------------------------------ | -------------------------------- |
| **Implementation**   | Interface        | Class (Hash table)                         | Class (Red-Black tree)           |
| **Order**            | No guarantee     | No guarantee                               | Sorted (Ascending)               |
| **Null keys/values** | Depends on impl. | Allows 1 null key and multiple null values | No null keys, allows null values |
| **Performance**      | Depends on impl. | O(1) average time complexity               | O(log n) for operations          |
| **Use Case**         | General purpose  | Fast lookups, caching                      | Sorted data, range queries       |
| **Thread Safety**    | No               | No                                         | No                               |

### When to Use:

- **Use HashMap** when you need fast lookups, insertions, and deletions with no need for sorted order.
- **Use TreeMap** when you require sorted keys, or need to perform operations like subMap or tailMap that depend on sorted data.
- **Map** serves as the foundation for both `HashMap` and `TreeMap` and is useful when you just need to define a map interface, leaving the choice of implementation to specific needs.

---

Here is a tabular comparison of `Map`, `HashMap`, and `TreeMap` in Java:

| **Feature**             | **Map**                                                        | **HashMap**                                                    | **TreeMap**                                                                                                |
| ----------------------- | -------------------------------------------------------------- | -------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| **Definition**          | Interface that represents a collection of key-value pairs.     | A class implementing the `Map` interface using a hash table.   | A class implementing the `Map` interface using a red-black tree.                                           |
| **Ordering of Keys**    | No guarantee                                                   | No ordering guarantee (unordered)                              | Keys are sorted in ascending order by default (or custom comparator).                                      |
| **Null Keys/Values**    | Depends on implementation                                      | Allows 1 null key and multiple null values                     | Does not allow null keys, but allows null values.                                                          |
| **Time Complexity**     | Varies by implementation                                       | O(1) on average for basic operations (put, get, remove)        | O(log n) for put, get, and remove due to the tree structure.                                               |
| **Performance**         | Varies by implementation                                       | Generally fast for non-sorted data.                            | Slower than `HashMap` for basic operations, but supports efficient range-based queries.                    |
| **Use Cases**           | General-purpose key-value mapping                              | Fast lookups, caching, and when insertion order doesn’t matter | When data needs to be sorted or requires range queries, such as in financial applications or leaderboards. |
| **Thread Safety**       | Not thread-safe by default                                     | Not thread-safe by default                                     | Not thread-safe by default                                                                                 |
| **Implementation**      | Interface (no functionality)                                   | Class (`HashMap`)                                              | Class (`TreeMap`)                                                                                          |
| **Examples of Methods** | `put(K key, V value)`, `get(Object key)`, `remove(Object key)` | `put()`, `get()`, `remove()`                                   | `put()`, `get()`, `firstKey()`, `lastKey()`, `subMap()`, `tailMap()`                                       |
| **Memory Consumption**  | Varies by implementation                                       | Lower memory consumption due to hash-based storage.            | Higher memory consumption due to tree structure (red-black tree).                                          |
| **Iteration**           | No specific iteration order                                    | No specific iteration order                                    | Iterates in ascending order of keys.                                                                       |

### Summary:

- **Map** is the general interface defining basic map operations.
- **HashMap** is an unordered, fast implementation that allows null keys and values.
- **TreeMap** is a sorted map implementation, ideal when order and range queries are important.
