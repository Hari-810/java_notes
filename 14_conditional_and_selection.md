---
---

### **1. Conditional Statements: `if`, `else if`, `else`**

#### **Definition**

- Conditional statements allow the program to execute specific blocks of code based on whether a condition is true or false.
- These are versatile and can evaluate any boolean expression.

#### **Syntax**

```java
if (condition) {
    // Block of code to execute if the condition is true
} else if (anotherCondition) {
    // Block of code to execute if the first condition is false and this condition is true
} else {
    // Block of code to execute if none of the above conditions are true
}
```

#### **Example**

```java
public class ConditionalExample {
    public static void main(String[] args) {
        int age = 20;

        // Check the age and determine access type
        if (age < 13) {
            System.out.println("You are a child.");
        } else if (age >= 13 && age < 18) {
            System.out.println("You are a teenager.");
        } else {
            System.out.println("You are an adult.");
        }
    }
}
```

#### **Pros**

- **Flexibility**: Can handle a wide variety of conditions.
- **Readability**: Clear logic flow when there are a few conditions.
- **Nested Conditions**: Can handle complex conditions using nested `if` statements.

#### **Cons**

- **Complexity**: Becomes difficult to read and debug when there are many conditions.
- **Performance**: Slightly slower than `switch` in cases with many conditions because each condition is evaluated sequentially.

#### **Applications in Larger Systems**

- **Authentication**: To check if user credentials match.
- **Business Logic**: Decide flow based on customer age, subscription type, etc.
- **Error Handling**: Evaluate different failure scenarios and respond appropriately.

---

### **2. Selection Statements: `switch`, `case`, `default`**

#### **Definition**

- Selection statements allow the program to execute a block of code from multiple options based on the value of an expression.
- Best suited for fixed, discrete values like integers, strings, or enums.

#### **Syntax**

```java
switch (expression) {
    case value1:
        // Block of code for value1
        break;
    case value2:
        // Block of code for value2
        break;
    default:
        // Block of code if none of the cases match
}
```

#### **Example**

```java
public class SwitchExample {
    public static void main(String[] args) {
        String day = "Monday";

        // Determine the type of day
        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                System.out.println(day + " is a weekday.");
                break;
            case "Saturday":
            case "Sunday":
                System.out.println(day + " is a weekend.");
                break;
            default:
                System.out.println("Invalid day.");
        }
    }
}
```

#### **Pros**

- **Performance**: Faster than `if-else` when dealing with many discrete values.
- **Readability**: Cleaner and more concise than multiple `if-else` statements.
- **Default Case**: Handles unexpected inputs gracefully.

#### **Cons**

- **Limited Conditions**: Only works with discrete, comparable values (e.g., int, char, String, enums).
- **No Range Evaluation**: Cannot evaluate ranges directly (e.g., `case age >= 18` is invalid).
- **Code Duplication**: May require repeated code if multiple cases require the same action.

#### **Applications in Larger Systems**

- **Menu Selection**: Handle user options in command-line tools or GUI applications.
- **State Machines**: Implement finite state machines with defined states.
- **Configuration Settings**: Map specific settings or commands to predefined values.

---

### **Comparison of Use Cases**

| Feature             | `if-else`                      | `switch`                               |
| ------------------- | ------------------------------ | -------------------------------------- |
| **Complex Logic**   | Suitable for evaluating ranges | Not suitable for evaluating ranges     |
| **Discrete Values** | Less concise                   | Cleaner and faster                     |
| **Error Handling**  | Suitable                       | Can use `default` for unexpected cases |
| **Performance**     | Slower for many conditions     | Faster for discrete value comparisons  |

---

### **Example in a Bigger Application**

#### **Scenario: User Access Control**

```java
public class AccessControl {
    public static void main(String[] args) {
        String userRole = "editor";

        // Determine user access level
        switch (userRole) {
            case "admin":
                System.out.println("Full access granted.");
                break;
            case "editor":
                System.out.println("Edit access granted.");
                break;
            case "viewer":
                System.out.println("View-only access granted.");
                break;
            default:
                System.out.println("Access denied.");
        }

        int userAge = 20;

        // Additional condition: Age-based access
        if (userAge < 18) {
            System.out.println("Access restricted for users under 18.");
        } else if (userAge >= 18 && userAge < 65) {
            System.out.println("Access granted to adults.");
        } else {
            System.out.println("Access granted to senior citizens.");
        }
    }
}
```

#### **Where This is Applied**

- **Role-Based Access Control (RBAC)**: Determine user permissions based on roles (`switch`).
- **Feature Toggles**: Evaluate whether a feature is enabled or disabled (`if-else`).
- **Multi-Layered Checks**: Combine `switch` and `if-else` for layered access control.

---

### **Summary**

- Use **`if-else`** for complex conditions or when evaluating ranges.
- Use **`switch`** for cleaner, faster evaluation of discrete values.
- Both can coexist in a larger application to address varied requirements.
