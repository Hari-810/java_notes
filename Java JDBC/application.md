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
