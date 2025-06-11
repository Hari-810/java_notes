**Java-style pseudocode and architecture**

---

## ☕ Java Architecture Overview

### 📦 Components & Responsibilities

| Class             | Responsibility                                 |
| ----------------- | ---------------------------------------------- |
| `MainApp`         | Entry point, orchestrates the flow             |
| `InputReader`     | Collects user input from console or file       |
| `DataProcessor`   | Validates, cleans, and transforms input data   |
| `User`            | Holds structured user information (data model) |
| `DatabaseHandler` | Handles MySQL connectivity and data insertion  |

---

## 📑 Java Pseudocode

### `MainApp`

```java
main() {
    InputReader reader = new InputReader();
    Map<String, String> rawInput = reader.readFromConsole();

    DataProcessor processor = new DataProcessor();
    User user = processor.preprocess(rawInput);

    DatabaseHandler dbHandler = new DatabaseHandler(DB_CONFIG);
    dbHandler.insertUser(user);
    dbHandler.close();
}
```

---

### `InputReader`

```java
class InputReader {
    Map<String, String> readFromConsole() {
        prompt for:
            - name
            - age
            - email
            - phone
            - gender
            - country
            - date of birth (YYYY-MM-DD)

        return map of field → raw string input
    }
}
```

---

### `DataProcessor`

```java
class DataProcessor {
    User preprocess(Map<String, String> rawData) {
        clean and validate:
            - Trim name and capitalize
            - Convert age to integer, check range
            - Lowercase email, validate format
            - Strip phone of non-numeric characters
            - Normalize gender to "Male", "Female", "Other"
            - Capitalize country name
            - Validate date format

        return new User(...cleaned values...)
    }
}
```

---

### `User`

```java
class User {
    Fields:
        String name
        int age
        String email
        String phone
        String gender
        String country
        String dateOfBirth

    Constructor:
        Initialize fields with validated values

    Getters/Setters (optional if using constructor only)
}
```

---

### `DatabaseHandler`

```java
class DatabaseHandler {
    Constructor:
        Connect to MySQL using provided DB config

    insertUser(User user):
        Prepare SQL insert query
        Bind user fields to query
        Execute insert operation

    close():
        Close DB connection
}
```

---

## 🧠 Summary

- **InputReader** → gathers raw user data
- **DataProcessor** → transforms and validates input
- **User** → holds cleaned, structured data
- **DatabaseHandler** → inserts structured data into MySQL
- **MainApp** → coordinates the full flow

---

## 🔄 **Overall Flow of the Project**

---

### **1. User Input Stage**

**Class:** `InputReader`

- Prompts the user for input fields:

  - Name, Age, Email, Phone, Gender, Country, Date of Birth

- Collects them as a `Map<String, String>` (raw data)
- Returns this map to the main application

🧠 _Raw input data is unvalidated and unformatted._

---

### **2. Data Preprocessing Stage**

**Class:** `DataProcessor`

- Takes the `Map<String, String>` from `InputReader`
- Validates and normalizes each field:

  - Trims spaces, standardizes casing (e.g., lowercase country, removes non-numeric characters in phone)
  - Converts `age` to `int`, checks valid date format for `dob`, etc.

- Constructs a `User` object with clean, structured values
- Returns the `User` object

🧠 _This stage ensures data integrity before insertion._

---

### **3. Database Handling Stage**

**Class:** `DatabaseHandler`

- Initialized with MySQL connection details
- On initialization:

  - Connects to the MySQL server
  - Checks if the target database exists; creates it if not
  - Connects to the target DB
  - Checks if the `users` table exists; creates it if not

- Uses the `User` object to insert a new record into the table
- Closes the connection

🧠 _Handles schema setup and inserts data safely using prepared statements._

---

### **4. Orchestration Layer**

**Class:** `MainApp` (or equivalent)

- Entry point of the application
- Coordinates the whole flow:

  ```java
  InputReader reader = new InputReader();
  Map<String, String> rawInput = reader.readFromConsole();

  DataProcessor processor = new DataProcessor();
  User user = processor.preprocess(rawInput);

  DatabaseHandler db = new DatabaseHandler(...);
  db.insertUser(user);
  db.close();
  ```

🧠 _Acts as the glue between input, preprocessing, and storage._

---

## 🔁 **Visual Flow**

```text
User (console input)
   ↓
InputReader.readFromConsole()
   ↓
Raw Map<String, String>
   ↓
DataProcessor.preprocess()
   ↓
Clean User object
   ↓
DatabaseHandler.insertUser(user)
   ↓
Stored in MySQL database ✅
```

---
