**File Name: `ExceptionHandlingExample.java`**

```java
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ExceptionHandlingExample {

    // Method to read file content
    public static void readFile() throws IOException {
        File file = new File("sample.txt");

        // Check if the file exists
        if (file.exists()) {
            // BufferedReader to read the file
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            System.out.println("File contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } else {
            System.out.println("File does not exist.");
        }
    }

    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("IO Exception occurred: " + e.getMessage());
        } finally {
            System.out.println("This block will always execute.");
        }

        // Throwing a custom exception as an example
        try {
            throw new IllegalArgumentException("This is a custom exception.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

### Explanation:

1. **File Existence Check**:

   - I added a check using `file.exists()` to verify if the file `sample.txt` exists before attempting to read its content.
   - If the file exists, it reads the content using a `BufferedReader` and prints it line by line.
   - If the file does not exist, it prints a message stating "File does not exist."

2. **BufferedReader**:
   - The `BufferedReader` is used to read the file line by line, which is efficient for reading larger files.
   - After reading, we close the `BufferedReader` to release resources.

### Example Output:

Assuming `sample.txt` exists and contains:

```
Hello, World!
Welcome to Exception Handling in Java.
```

The output would be:

```
File contents:
Hello, World!
Welcome to Exception Handling in Java.
This block will always execute.
This is a custom exception.
```

If the file doesn't exist, it would output:

```
File does not exist.
This block will always execute.
This is a custom exception.
```
