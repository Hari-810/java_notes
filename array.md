## Arrays in Java

An **array** in Java is a collection of elements of the same type, stored in contiguous memory locations. Arrays are fixed in size and allow random access to elements using their index.

### Features of Arrays:

1. **Fixed Size:** Size is defined at the time of declaration.
2. **Indexed Access:** Elements can be accessed via an index starting from `0`.
3. **Homogeneous Data:** Only one data type per array.
4. **Stored in Memory:** Stored in contiguous memory for efficient access.

---

### Example 1: **Single-Dimensional Array**

#### Concept:

A simple array storing integers.

```java
public class SingleDimensionalArray {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Array Elements:");
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
```

#### **Pros:**

- Easy to use and access elements.
- Suitable for small, fixed-size datasets.

#### **Cons:**

- Fixed size can lead to inefficient memory usage if over-allocated or under-allocated.

#### **Real-time Example:**

- Storing marks of a student in 5 subjects.

---

### Example 2: **Multi-Dimensional Array**

#### Concept:

Used to represent data in a matrix-like structure.

```java
public class MultiDimensionalArray {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

#### **Pros:**

- Ideal for complex data structures like tables, graphs, and grids.
- Simplifies access to related data.

#### **Cons:**

- More challenging to implement and debug.
- Memory-intensive for large data sets.

#### **Real-time Example:**

- Representing an image as a grid of pixels.

---

### Example 3: **Jagged Array**

#### Concept:

An array where each row has a different number of columns.

```java
public class JaggedArray {
    public static void main(String[] args) {
        int[][] jaggedArray = {
            {1, 2},
            {3, 4, 5},
            {6}
        };

        System.out.println("Jagged Array:");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

#### **Pros:**

- Flexible for varying sizes of sub-arrays.
- Saves memory compared to a full 2D array with uneven data.

#### **Cons:**

- Slightly more complex to manage.

#### **Real-time Example:**

- Representing a seating arrangement in a theater where rows have different numbers of seats.

---

### Example 4: **Array of Objects**

#### Concept:

An array can store references to objects.

```java
class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ArrayOfObjects {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("Alice", 20);
        students[1] = new Student("Bob", 22);
        students[2] = new Student("Charlie", 19);

        for (Student student : students) {
            System.out.println(student.name + " - " + student.age);
        }
    }
}
```

#### **Pros:**

- Supports object-oriented programming.
- Ideal for managing collections of objects.

#### **Cons:**

- Memory-intensive for large object arrays.
- Needs careful memory management to avoid `NullPointerException`.

#### **Real-time Example:**

- Storing information about employees in a company.

---

### Example 5: **Dynamic Behavior with ArrayList**

#### Concept:

Using `ArrayList` for dynamic resizing (alternative to fixed arrays).

```java
import java.util.ArrayList;

public class DynamicArray {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("Fruits: " + fruits);
        fruits.remove("Banana");
        System.out.println("After Removal: " + fruits);
    }
}
```

#### **Pros:**

- Dynamically resizable.
- Built-in methods for manipulation.

#### **Cons:**

- Slightly slower than arrays due to overhead.
- Requires importing Java collections.

#### **Real-time Example:**

- Storing user search history dynamically.

---

### Pros of Arrays:

1. **Efficient Access:** Fast access to elements via index.
2. **Memory Optimization:** Continuous memory allocation.
3. **Simple to Implement:** Straightforward to declare and initialize.

### Cons of Arrays:

1. **Fixed Size:** Cannot resize once declared.
2. **Homogeneous Data Only:** Cannot mix types.
3. **No Built-in Flexibility:** Need to write additional logic for operations like insertion or deletion.

---

### Real-Time Applications of Arrays:

1. **Game Development:** Storing player scores or object positions.
2. **Data Analytics:** Handling statistical datasets.
3. **Web Development:** Managing HTTP requests or server logs.
4. **System Software:** Memory management or caching mechanisms.

---

# List

In Java, a **List** is an interface from the **`java.util`** package that represents an ordered collection (also known as a sequence). It allows duplicate elements and provides positional access and manipulation.

The **`List`** interface is implemented by several classes, including:

1. **ArrayList**: A resizable array implementation.
2. **LinkedList**: A doubly-linked list implementation.
3. **Vector**: A synchronized implementation of List.
4. **Stack**: A subclass of Vector that implements a last-in-first-out stack.

---

### **Key Features of List**

1. **Ordered Collection**: Elements are stored in the order they are inserted.
2. **Allows Duplicates**: Multiple elements with the same value can exist.
3. **Indexed Access**: Elements can be accessed using their index.
4. **Dynamic Size**: Most implementations of `List` (e.g., `ArrayList`, `LinkedList`) grow dynamically.

---

### **Basic Methods of List**

- **`add(E e)`**: Adds an element to the end of the list.
- **`add(int index, E e)`**: Adds an element at a specified index.
- **`get(int index)`**: Retrieves the element at the specified index.
- **`remove(int index)`**: Removes the element at the specified index.
- **`set(int index, E e)`**: Replaces the element at the specified index.
- **`size()`**: Returns the number of elements in the list.

---

## ArrayList in Java

An **ArrayList** in Java is part of the `java.util` package and is a resizable array implementation of the `List` interface. Unlike arrays, **ArrayList** allows dynamic resizing and supports a variety of built-in methods for manipulation.

---

### Features of ArrayList:

1. **Dynamic Size:** Automatically grows and shrinks as needed.
2. **Indexed Access:** Elements can be accessed via an index, similar to arrays.
3. **Generic Support:** Can specify the type of elements stored.
4. **Part of Collections Framework:** Supports advanced operations like sorting, searching, and iterating.

---

### Example 1: **Basic ArrayList Operations**

#### Concept:

Demonstrating creation, addition, and retrieval.

```java
import java.util.ArrayList;

public class BasicArrayList {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Access elements
        System.out.println("First fruit: " + fruits.get(0));

        // Iterating using a loop
        System.out.println("All fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```

#### **Pros:**

- Simplifies data management with built-in methods.
- Dynamic resizing eliminates manual size management.

#### **Cons:**

- Overhead due to dynamic resizing.
- Requires boxing/unboxing for primitive types.

#### **Real-Time Example:**

- Managing a shopping cart in an e-commerce application.

---

### Example 2: **ArrayList with Generics**

#### Concept:

Using generics to restrict the type of elements.

```java
import java.util.ArrayList;

public class GenericArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        System.out.println("Sum of numbers: " + sum);
    }
}
```

#### **Pros:**

- Type safety avoids runtime errors.
- Eliminates the need for typecasting.

#### **Cons:**

- Generics don't support primitive types directly (uses wrapper classes).

#### **Real-Time Example:**

- Managing user ratings for products.

---

### Example 3: **Removing and Updating Elements**

#### Concept:

Manipulating elements in the ArrayList.

```java
import java.util.ArrayList;

public class ModifyArrayList {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("New York");
        cities.add("Los Angeles");
        cities.add("Chicago");

        // Remove an element
        cities.remove("Los Angeles");

        // Update an element
        cities.set(1, "Houston");

        System.out.println("Updated Cities: " + cities);
    }
}
```

#### **Pros:**

- Flexible methods for modification.
- Simplifies element management.

#### **Cons:**

- Removing or inserting elements in the middle can be inefficient.

#### **Real-Time Example:**

- Managing a travel itinerary where destinations are added or removed.

---

### Example 4: **Sorting an ArrayList**

#### Concept:

Using `Collections.sort` to arrange elements.

```java
import java.util.ArrayList;
import java.util.Collections;

public class SortArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");

        // Sort in ascending order
        Collections.sort(names);
        System.out.println("Sorted Names: " + names);

        // Sort in descending order
        Collections.sort(names, Collections.reverseOrder());
        System.out.println("Reverse Sorted Names: " + names);
    }
}
```

#### **Pros:**

- Easy to sort using built-in utilities.
- Supports both ascending and custom sorting.

#### **Cons:**

- Sorting can be time-consuming for large lists.

#### **Real-Time Example:**

- Sorting search results alphabetically or by relevance.

---

### Example 5: **Multi-Dimensional ArrayList**

#### Concept:

Creating and using nested ArrayLists.

```java
import java.util.ArrayList;

public class MultiDimensionalArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // Adding rows
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1); row1.add(2); row1.add(3);
        matrix.add(row1);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(4); row2.add(5); row2.add(6);
        matrix.add(row2);

        // Printing matrix
        for (ArrayList<Integer> row : matrix) {
            System.out.println(row);
        }
    }
}
```

#### **Pros:**

- Flexible for creating complex data structures.
- Easier than managing a 2D array.

#### **Cons:**

- More complex syntax and memory usage.

#### **Real-Time Example:**

- Representing a grid-like game board dynamically.

---

### Example 6: **Searching in ArrayList**

#### Concept:

Checking if an element exists.

```java
import java.util.ArrayList;

public class SearchArrayList {
    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>();
        books.add("Java Programming");
        books.add("Data Structures");
        books.add("Machine Learning");

        // Search
        String search = "Data Structures";
        if (books.contains(search)) {
            System.out.println(search + " is available.");
        } else {
            System.out.println(search + " is not available.");
        }
    }
}
```

#### **Pros:**

- Simple methods for searching (`contains`, `indexOf`).

#### **Cons:**

- Linear search is inefficient for large lists.

#### **Real-Time Example:**

- Checking if a specific book is in the library catalog.

---

### Pros of ArrayList:

1. **Dynamic Resizing:** Eliminates manual resizing.
2. **Built-in Methods:** Simplifies manipulation like adding, removing, and sorting.
3. **Flexible:** Supports generic types and advanced operations.
4. **Part of Collections Framework:** Seamlessly integrates with other collection types.

### Cons of ArrayList:

1. **Performance Overhead:** Slower than arrays for primitive types.
2. **Inefficient for Insertions/Deletions:** Requires shifting elements.
3. **Not Thread-Safe:** Requires external synchronization for concurrent access.

---

### Real-Time Applications of ArrayList:

1. **Shopping Cart:** Dynamic addition and removal of items.
2. **Contact List:** Storing and sorting phonebook contacts.
3. **Dynamic UI Components:** Managing items in dropdowns or lists dynamically.
4. **Search Filters:** Storing and updating filters for search results.

---

## LinkedList

A **LinkedList** in Java is a linear data structure where elements, known as nodes, are connected using pointers. Each node contains two parts:

1. **Data**: The actual data or value.
2. **Pointer/Reference**: A reference to the next (and sometimes previous) node in the list.

Java provides the **`LinkedList` class** as part of the **`java.util` package**, which implements the **`List`**, **`Deque`**, and **`Queue`** interfaces.

---

### **Characteristics of LinkedList:**

- **Dynamic Size**: Unlike arrays, linked lists grow and shrink dynamically without wasting memory.
- **Efficient Insertions/Deletions**: Adding or removing elements is efficient since there’s no need to shift elements.
- **Sequential Access**: Accessing elements is slower because you must traverse the list from the start to find an element.

---

### **Basic Operations with Examples**

#### 1. **Creating and Adding Elements**

```java
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("LinkedList: " + list); // Output: [Apple, Banana, Cherry]
    }
}
```

**Concept:** Demonstrates basic creation and usage of a LinkedList.  
**Pros:** Simple and quick setup.  
**Cons:** Does not show specific advantages over other structures like ArrayList.

---

#### 2. **Using LinkedList as a Queue**

```java
import java.util.LinkedList;

public class QueueExample {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();

        // Adding elements to the queue
        queue.offer("Task 1");
        queue.offer("Task 2");
        queue.offer("Task 3");

        // Processing elements
        while (!queue.isEmpty()) {
            System.out.println("Processing: " + queue.poll());
        }
    }
}
```

**Concept:** Use LinkedList as a queue (FIFO).  
**Real-Life Example:** Managing tasks in a print queue.  
**Pros:** Efficient for insertion and deletion at the ends.  
**Cons:** Accessing middle elements is slower.

---

#### 3. **Using LinkedList as a Deque**

```java
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        LinkedList<String> deque = new LinkedList<>();

        // Adding elements at both ends
        deque.addFirst("First");
        deque.addLast("Last");

        // Removing elements from both ends
        System.out.println("Removed First: " + deque.removeFirst());
        System.out.println("Removed Last: " + deque.removeLast());
    }
}
```

**Concept:** Use LinkedList as a double-ended queue.  
**Real-Life Example:** Implementing undo/redo functionality in an editor.  
**Pros:** Flexibility to add/remove elements from both ends.  
**Cons:** Increased overhead due to maintaining double references.

---

#### 4. **Reversing a LinkedList**

```java
import java.util.LinkedList;
import java.util.Collections;

public class ReverseExample {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Collections.reverse(list);

        System.out.println("Reversed LinkedList: " + list); // Output: [3, 2, 1]
    }
}
```

**Concept:** Reversing the order of elements.  
**Real-Life Example:** Scheduling events in reverse chronological order.  
**Pros:** Built-in methods simplify operations.  
**Cons:** Performance may degrade for large datasets due to iteration.

---

#### 5. **Iterating Through a LinkedList**

```java
import java.util.LinkedList;

public class IterateExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // Using a for-each loop
        for (String item : list) {
            System.out.println(item);
        }

        // Using an iterator
        System.out.println("Using Iterator:");
        var iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

**Concept:** Different ways to traverse a LinkedList.  
**Real-Life Example:** Displaying records from a database query.  
**Pros:** Flexible traversal methods.  
**Cons:** Iterators may throw `ConcurrentModificationException` if the list is modified during traversal.

---

#### 6. **Removing Duplicates**

```java
import java.util.LinkedList;

public class RemoveDuplicatesExample {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(2);

        LinkedList<Integer> uniqueList = new LinkedList<>();
        for (int num : list) {
            if (!uniqueList.contains(num)) {
                uniqueList.add(num);
            }
        }

        System.out.println("Original: " + list);
        System.out.println("Without Duplicates: " + uniqueList);
    }
}
```

**Concept:** Removing duplicate elements.  
**Real-Life Example:** Cleaning up duplicate user entries in a list.  
**Pros:** Simple approach for smaller datasets.  
**Cons:** Inefficient for large lists due to `contains` lookup time.

---

### **Pros of LinkedList**

1. **Dynamic Size**: Can grow or shrink dynamically.
2. **Efficient Insertions/Deletions**: Especially at the head or tail.
3. **Flexibility**: Can be used as a list, queue, or deque.

### **Cons of LinkedList**

1. **Sequential Access**: Slower access time compared to arrays.
2. **Memory Overhead**: Each node requires extra memory for storing references.
3. **Cache Unfriendliness**: Nodes are scattered in memory, causing cache misses.

---

### **Real-World Applications**

1. **Undo/Redo in Text Editors**: LinkedList is used to maintain a history of changes.
2. **Music Playlist**: Playing songs in a circular loop or jumping to the next/previous song.
3. **Task Scheduling**: Managing job queues for processing.
