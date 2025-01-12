# File read

In Java, I/O (Input/Output) streams are used to read and write data from and to different sources like files, network connections, memory, etc. Java provides two main categories of streams: **byte streams** and **character streams**.

### 1. **Byte Streams**

Byte streams handle raw binary data. They read and write data one byte at a time. The most commonly used byte stream classes are:

- `FileInputStream`
- `FileOutputStream`

### 2. **Character Streams**

Character streams handle text data. They read and write data one character at a time. They are more suitable for reading and writing text files because they handle character encoding automatically. The most commonly used character stream classes are:

- `FileReader`
- `FileWriter`

---

### Example 1: **Reading a File and Printing its Content**

#### Code (Using FileInputStream - Byte Stream)

```java
import java.io.FileInputStream;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            // Creating a FileInputStream object
            fis = new FileInputStream("example.txt");

            int content;
            // Reading the content of the file
            while ((content = fis.read()) != -1) {
                // Print each byte as a character
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Closing the file stream
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

#### Description:

- The `FileInputStream` reads data byte-by-byte.
- It is efficient for binary data (e.g., images, audio), but for text files, `FileReader` is recommended.
- We open the file `"example.txt"`, read its content, and print each byte as a character.

---

### Example 2: **Reading a File and Saving It in a Folder**

#### Code (Using FileReader and FileWriter - Character Stream)

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyExample {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // Creating FileReader and FileWriter objects
            fr = new FileReader("example.txt");
            fw = new FileWriter("outputFolder/copied_example.txt");

            int content;
            // Reading the content of the file
            while ((content = fr.read()) != -1) {
                fw.write(content);  // Writing content to the new file
            }
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Closing the streams
            try {
                if (fr != null) {
                    fr.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

```

#### Description:

- The `FileReader` reads the content from `"example.txt"`, and the FileWriter writes the content to a new file in the `outputFolder` .
- Character streams are better for text files because they handle the encoding automatically.
- This example copies a file into a specified folder.

---

### Pros and Cons of Java I/O Streams:

#### **Byte Streams (FileInputStream / FileOutputStream)**

- **Pros**:
  - Suitable for binary data (images, audio, etc.).
  - More efficient when working with raw binary files.
- **Cons**:
  - Not ideal for text files (they don't handle character encoding and may produce incorrect output for text files with special characters).

#### **Character Streams (FileReader / FileWriter)**

- **Pros**:
  - Designed for text files, automatically handles character encoding (like UTF-8 or ASCII).
  - Easier to use with textual data as it ensures data is read/written as characters.
- **Cons**:
  - Not suitable for binary data (image, audio, etc.), as it may corrupt binary data.

---

### Real-Time Example Scenarios:

1. **File Transfer**:

   - Byte streams can be used to copy a binary file (e.g., an image or a zip file) from one system to another.

2. **Text File Processing**:

   - Character streams are great for reading and writing text files such as configuration files, logs, or documents that store user-readable information.

3. **Network Data Communication**:
   - Both byte and character streams are commonly used in network communication, where data can be read from or written to sockets using appropriate streams.

---

# User-input read

In Java, there are several ways to read user input, including using `Scanner`, `BufferedReader`, and `Console`. Each method has its advantages and drawbacks depending on the use case. Below are examples of each method to read input and how to read a file, print its content, and save it in a folder.

### 1. Using `Scanner`:

`Scanner` is the most common class used for reading user input in Java. It is easy to use and can read various types of input, including strings, integers, and more.

#### Example:

```java
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ScannerExample {
    public static void main(String[] args) {
        // Reading user input using Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        // Reading a file and printing its content
        try {
            File file = new File("input.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();

            // Saving content in a folder
            FileWriter writer = new FileWriter("output_folder/output.txt");
            writer.write("User name: " + name + "\n");
            writer.write("Content from file: \n");
            fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                writer.write(fileScanner.nextLine() + "\n");
            }
            writer.close();
            fileScanner.close();
            System.out.println("Content saved in output_folder/output.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### Pros:

- Simple and easy to use.
- Can handle different data types like strings, numbers, etc.
- Read data from both the keyboard and files.

#### Cons:

- Can throw `InputMismatchException` if the user inputs a type that does not match the expected type.
- Not thread-safe.

#### Real-time example:

You can use `Scanner` in applications like user login forms where input validation is necessary, and you might also read configuration files.

---

### 2. Using `BufferedReader`:

`BufferedReader` is another way to read text input from the console or a file. It is more efficient than `Scanner` when reading large amounts of text because it reads data in larger chunks.

#### Example:

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderExample {
    public static void main(String[] args) {
        // Reading user input using BufferedReader
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your favorite color: ");
            String color = reader.readLine();
            System.out.println("Your favorite color is " + color);

            // Reading file and printing content
            BufferedReader fileReader = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }

            // Saving content in a folder
            FileWriter writer = new FileWriter("output_folder/output.txt");
            writer.write("Favorite color: " + color + "\n");
            fileReader.close();
            fileReader = new BufferedReader(new FileReader("input.txt"));
            while ((line = fileReader.readLine()) != null) {
                writer.write(line + "\n");
            }
            writer.close();
            fileReader.close();
            System.out.println("Content saved in output_folder/output.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### Pros:

- More efficient for reading large files due to buffering.
- Handles larger amounts of text input more efficiently than `Scanner`.
- Ideal for reading files line by line.

#### Cons:

- You need to manually handle exceptions and close resources.
- Cannot parse different types of data directly (e.g., you would need to manually convert strings to integers).

#### Real-time example:

`BufferedReader` can be used in server applications where large log files are read, and efficient processing of text input is needed.

---

### 3. Using `Console`:

`Console` is used for reading password inputs or other sensitive data from the console. It does not work well with IDEs like Eclipse but works fine in command-line applications.

#### Example:

```java
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConsoleExample {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("No console available.");
            return;
        }

        // Reading password using Console
        char[] passwordArray = console.readPassword("Enter your password: ");
        String password = new String(passwordArray);
        System.out.println("Password entered: " + password);

        // Reading a file and printing its content
        try {
            File file = new File("input.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();

            // Saving content in a folder
            FileWriter writer = new FileWriter("output_folder/output.txt");
            writer.write("Password: " + password + "\n");
            fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                writer.write(fileScanner.nextLine() + "\n");
            }
            writer.close();
            fileScanner.close();
            System.out.println("Content saved in output_folder/output.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### Pros:

- Secure input (e.g., password) because input is not displayed on the screen.
- Simple to use for sensitive data.

#### Cons:

- Not suitable for non-console applications.
- May not work in some IDEs (e.g., Eclipse).

#### Real-time example:

`Console` is commonly used in applications that handle user credentials or other sensitive data, such as in login forms or data encryption tools.

---

### Comparison of Methods:

| Method           | Pros                                             | Cons                                                           | Use Case                                    |
| ---------------- | ------------------------------------------------ | -------------------------------------------------------------- | ------------------------------------------- |
| `Scanner`        | Easy to use, works for both console and file.    | Not thread-safe, can throw exceptions for invalid input types. | Simple user input, file reading.            |
| `BufferedReader` | Efficient for large input, line-by-line reading. | Requires manual conversion of data types, more complex.        | Reading large files, line-based processing. |
| `Console`        | Secure input for sensitive data.                 | Works only in console, not in IDEs like Eclipse.               | Password input, sensitive data handling.    |

### Conclusion:

- **Use `Scanner`** when you need an easy-to-use solution for reading various types of input, including keyboard input and files.
- **Use `BufferedReader`** when you need to process large amounts of text efficiently, especially for file reading.
- **Use `Console`** for reading secure input like passwords.

Each of these classes has its own advantages, and the choice depends on the specific requirements of your application.
