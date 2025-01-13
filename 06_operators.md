In Java, operations can be broadly categorized based on the types of variables and the operations performed on them. These categories include arithmetic operations, relational operations, logical operations, assignment operations, and bitwise operations. Below is a breakdown of each category with details and examples for each type of variable.

### 1. **Arithmetic Operations**

Arithmetic operations involve basic mathematical operations like addition, subtraction, multiplication, division, and modulus.

**Example:**

```java
public class ArithmeticOperations {
    public static void main(String[] args) {
        int a = 10, b = 5;
        double x = 10.5, y = 4.2;

        // Integer arithmetic
        int sum = a + b;      // Addition
        int difference = a - b;  // Subtraction
        int product = a * b;     // Multiplication
        int quotient = a / b;    // Division
        int remainder = a % b;   // Modulus

        // Floating point arithmetic
        double floatSum = x + y;   // Addition
        double floatDiff = x - y;  // Subtraction
        double floatProduct = x * y; // Multiplication
        double floatQuotient = x / y; // Division

        // Display results
        System.out.println("Integer operations:");
        System.out.println("Sum: " + sum + ", Difference: " + difference + ", Product: " + product);
        System.out.println("Quotient: " + quotient + ", Remainder: " + remainder);

        System.out.println("Floating-point operations:");
        System.out.println("Sum: " + floatSum + ", Difference: " + floatDiff);
        System.out.println("Product: " + floatProduct + ", Quotient: " + floatQuotient);
    }
}
```

### 2. **Relational Operations**

Relational operations are used to compare two variables. The result of relational operations is a boolean value (`true` or `false`).

**Common relational operators:**

- `==` (equal to)
- `!=` (not equal to)
- `>` (greater than)
- `<` (less than)
- `>=` (greater than or equal to)
- `<=` (less than or equal to)

**Example:**

```java
public class RelationalOperations {
    public static void main(String[] args) {
        int a = 10, b = 5;

        System.out.println("a == b: " + (a == b)); // false
        System.out.println("a != b: " + (a != b)); // true
        System.out.println("a > b: " + (a > b));   // true
        System.out.println("a < b: " + (a < b));   // false
        System.out.println("a >= b: " + (a >= b)); // true
        System.out.println("a <= b: " + (a <= b)); // false
    }
}
```

### 3. **Logical Operations**

Logical operations are used to perform boolean logic. These operations are used in decision-making and condition checks.

**Common logical operators:**

- `&&` (AND)
- `||` (OR)
- `!` (NOT)

**Example:**

```java
public class LogicalOperations {
    public static void main(String[] args) {
        boolean a = true, b = false;

        System.out.println("a && b: " + (a && b)); // false
        System.out.println("a || b: " + (a || b)); // true
        System.out.println("!a: " + (!a));         // false
        System.out.println("!b: " + (!b));         // true
    }
}
```

### 4. **Assignment Operations**

Assignment operations are used to assign values to variables.

**Common assignment operators:**

- `=` (simple assignment)
- `+=`, `-=`, `*=`, `/=`, `%=` (compound assignment operators)

**Example:**

```java
public class AssignmentOperations {
    public static void main(String[] args) {
        int a = 10;
        a += 5;  // a = a + 5 => 15
        a -= 3;  // a = a - 3 => 12
        a *= 2;  // a = a * 2 => 24
        a /= 4;  // a = a / 4 => 6
        a %= 2;  // a = a % 2 => 0

        System.out.println("Final value of a: " + a); // 0
    }
}
```

### 5. **Bitwise Operations**

Bitwise operations are used to perform operations on bits of data. These are useful for tasks that involve low-level data manipulation.

**Common bitwise operators:**

- `&` (AND)
- `|` (OR)
- `^` (XOR)
- `~` (NOT)
- `<<` (left shift)
- `>>` (right shift)
- `>>>` (unsigned right shift)

**Example:**

```java
public class BitwiseOperations {
    public static void main(String[] args) {
        int a = 5;  // 0101 in binary
        int b = 3;  // 0011 in binary

        System.out.println("a & b: " + (a & b)); // 1 (0001)
        System.out.println("a | b: " + (a | b)); // 7 (0111)
        System.out.println("a ^ b: " + (a ^ b)); // 6 (0110)
        System.out.println("~a: " + (~a));       // -6 (inverts bits)

        System.out.println("a << 1: " + (a << 1)); // 10 (1010)
        System.out.println("a >> 1: " + (a >> 1)); // 2 (0010)
        System.out.println("a >>> 1: " + (a >>> 1)); // 2 (0010, unsigned shift)
    }
}
```

### 6. **Unary Operations**

Unary operations involve a single operand and perform operations like increment, decrement, and negation.

**Common unary operators:**

- `++` (increment)
- `--` (decrement)
- `+` (positive)
- `-` (negation)
- `!` (logical negation)

**Example:**

```java
public class UnaryOperationsExample {
    public static void main(String[] args) {
        // Example 1: Pre-Increment and Post-Increment
        int a = 5;
        System.out.println("Initial value of a: " + a);

        // Pre-increment: Increment first, then use the value
        int preIncrement = ++a;
        System.out.println("After pre-increment (++a): " + a + ", Value assigned to preIncrement: " + preIncrement);

        // Post-increment: Use the value first, then increment
        int postIncrement = a++;
        System.out.println("After post-increment (a++): " + a + ", Value assigned to postIncrement: " + postIncrement);

        // Example 2: Pre-Decrement and Post-Decrement
        int b = 10;
        System.out.println("\nInitial value of b: " + b);

        // Pre-decrement: Decrement first, then use the value
        int preDecrement = --b;
        System.out.println("After pre-decrement (--b): " + b + ", Value assigned to preDecrement: " + preDecrement);

        // Post-decrement: Use the value first, then decrement
        int postDecrement = b--;
        System.out.println("After post-decrement (b--): " + b + ", Value assigned to postDecrement: " + postDecrement);

        // Example 3: Unary Plus and Negation
        int c = -15;
        System.out.println("\nInitial value of c: " + c);

        // Unary plus (no effect on value)
        int positiveC = +c;
        System.out.println("Unary plus (+c): " + positiveC);

        // Negation: Changes the sign
        int negativeC = -c;
        System.out.println("Negation (-c): " + negativeC);

        // Example 4: Logical Negation
        boolean isActive = false;
        System.out.println("\nInitial value of isActive: " + isActive);

        // Logical negation
        boolean notActive = !isActive;
        System.out.println("Logical negation (!isActive): " + notActive);
    }
}

#output

Initial value of a: 5
After pre-increment (++a): 6, Value assigned to preIncrement: 6
After post-increment (a++): 7, Value assigned to postIncrement: 6

Initial value of b: 10
After pre-decrement (--b): 9, Value assigned to preDecrement: 9
After post-decrement (b--): 8, Value assigned to postDecrement: 9

Initial value of c: -15
Unary plus (+c): -15
Negation (-c): 15

Initial value of isActive: false
Logical negation (!isActive): true

```

Key Takeaways:

- Pre-Increment/Decrement (++var / --var): The variable is updated before it is used in the expression.
- Post-Increment/Decrement (var++ / var--): The variable is used in the expression first, then updated.
- Unary Plus (+): No effect on the value but ensures positive context.
- Negation (-): Inverts the sign of the value.
- Logical Negation (!): Flips a boolean value (true to false and vice versa).

### 7. **Ternary Operation**

The ternary operator is a shorthand for an `if-else` statement and is used to return a value based on a condition.

**Syntax:**

```java
condition ? value_if_true : value_if_false;
```

**Example:**

```java
public class TernaryOperation {
    public static void main(String[] args) {
        int a = 10, b = 5;
        int max = (a > b) ? a : b;
        System.out.println("Max value: " + max); // 10
    }
}
```

### Conclusion

Java provides various operations to manipulate variables based on their data types and required operations. Whether you are performing basic arithmetic, comparing values, or manipulating bits, Java’s rich set of operators can handle diverse tasks efficiently.
