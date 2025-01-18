In Java, **`Comparator`** and **`Comparable`** are two interfaces used for sorting collections or arrays. However, they serve slightly different purposes and have different methods. Here's a detailed comparison with examples:

---

### **`Comparable` Interface**
- **Purpose**: Used to define the **natural ordering** of objects.
- **Key Method**: 
  - `int compareTo(T o)`: Compares the current object with the specified object for order. 
    - Returns:
      - `0` if equal.
      - Negative value if current object is less than the specified object.
      - Positive value if current object is greater than the specified object.
- **Usage**: Implemented in the class itself. This allows the object to compare itself with another object of the same type.

#### **Example**
```java
import java.util.*;

class Student implements Comparable<Student> {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public int compareTo(Student other) {
        // Compare based on roll numbers (natural order)
        return this.rollNo - other.rollNo;
    }

    @Override
    public String toString() {
        return "Student{rollNo=" + rollNo + ", name='" + name + "'}";
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2, "Alice"));
        students.add(new Student(1, "Bob"));
        students.add(new Student(3, "Charlie"));

        // Sort using natural order (Comparable)
        Collections.sort(students);

        // Print sorted list
        System.out.println(students);
    }
}
```

#### **Output**
```
[Student{rollNo=1, name='Bob'}, Student{rollNo=2, name='Alice'}, Student{rollNo=3, name='Charlie'}]
```

---

### **`Comparator` Interface**
- **Purpose**: Used to define **custom ordering** of objects.
- **Key Method**:
  - `int compare(T o1, T o2)`: Compares two objects for order.
    - Returns:
      - `0` if equal.
      - Negative value if `o1` is less than `o2`.
      - Positive value if `o1` is greater than `o2`.
- **Usage**: Typically used as a separate class or a lambda function. This is helpful when you need to sort the same objects in different ways.

#### **Example**
```java
import java.util.*;

class Student {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{rollNo=" + rollNo + ", name='" + name + "'}";
    }
}

class SortByName implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        // Compare based on names
        return a.name.compareTo(b.name);
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2, "Alice"));
        students.add(new Student(1, "Bob"));
        students.add(new Student(3, "Charlie"));

        // Sort using custom comparator (Sort by name)
        Collections.sort(students, new SortByName());

        // Print sorted list
        System.out.println(students);
    }
}
```

#### **Output**
```
[Student{rollNo=2, name='Alice'}, Student{rollNo=1, name='Bob'}, Student{rollNo=3, name='Charlie'}]
```

---

### **Key Differences Between `Comparable` and `Comparator`**

| Feature                  | **Comparable**                           | **Comparator**                               |
|------------------------  |------------------------------------------|----------------------------------------------|
| **Location of Logic**    | Defined within the object class itself.  | Defined in a separate class or lambda.       |
| **Method**               | `compareTo(T o)`                         | `compare(T o1, T o2)`                        |
| **Usage**                | Used for natural ordering.               | Used for custom ordering.                    |
| **Multiple Sort Orders** | Cannot have multiple sort orders.        | Can define multiple custom comparators.      |
| **Example Sort Order**   | `Collections.sort(list)`                 | `Collections.sort(list, comparator)`         |

---

### **Example with Both `Comparable` and `Comparator`**

```java
import java.util.*;

class Student implements Comparable<Student> {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public int compareTo(Student other) {
        // Natural order: compare by roll number
        return this.rollNo - other.rollNo;
    }

    @Override
    public String toString() {
        return "Student{rollNo=" + rollNo + ", name='" + name + "'}";
    }
}

class SortByName implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}

public class ComparableVsComparator {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2, "Alice"));
        students.add(new Student(1, "Bob"));
        students.add(new Student(3, "Charlie"));

        // Sort by natural order (rollNo)
        Collections.sort(students);
        System.out.println("Sorted by roll number (natural order): " + students);

        // Sort by custom order (name)
        Collections.sort(students, new SortByName());
        System.out.println("Sorted by name (custom order): " + students);
    }
}
```

#### **Output**
```
Sorted by roll number (natural order): [Student{rollNo=1, name='Bob'}, Student{rollNo=2, name='Alice'}, Student{rollNo=3, name='Charlie'}]
Sorted by name (custom order): [Student{rollNo=2, name='Alice'}, Student{rollNo=1, name='Bob'}, Student{rollNo=3, name='Charlie'}]
```

---

### **When to Use `Comparable` or `Comparator`**
- **Use `Comparable`** when:
  - You want a single natural order for objects.
  - Sorting logic is intrinsic to the object.

- **Use `Comparator`** when:
  - You need multiple sorting criteria (e.g., sort by name, then by age).
  - Sorting logic needs to be external or flexible.















  In Java, the `Comparator` interface comes with a set of methods, especially after Java 8 when functional programming features like **default methods** and **lambda functions** were introduced. Here's a detailed breakdown of the **important methods** in `Comparator`:

---

### **Key Methods in `Comparator`**

#### 1. **`compare(T o1, T o2)`**
   - The primary method of the `Comparator` interface.
   - Used to compare two objects and decide their ordering.
   - **Returns**:
     - `0` if `o1` and `o2` are equal.
     - Negative value if `o1` is less than `o2`.
     - Positive value if `o1` is greater than `o2`.

   **Example**:
   ```java
   Comparator<Integer> comparator = (a, b) -> a - b; // Ascending order
   System.out.println(comparator.compare(3, 5)); // Output: -2
   System.out.println(comparator.compare(5, 3)); // Output: 2
   System.out.println(comparator.compare(3, 3)); // Output: 0
   ```

---

#### 2. **`reversed()`**
   - Returns a `Comparator` that reverses the natural ordering or the current comparator logic.

   **Example**:
   ```java
   Comparator<Integer> ascending = Comparator.naturalOrder(); // Ascending
   Comparator<Integer> descending = ascending.reversed();     // Descending

   List<Integer> numbers = Arrays.asList(1, 3, 2, 5);
   numbers.sort(descending);
   System.out.println(numbers); // Output: [5, 3, 2, 1]
   ```

---

#### 3. **`thenComparing(Comparator<? super T> other)`**
   - Used for **multi-level sorting**.
   - First, sorts by the primary comparator, and if equal, uses the secondary comparator.

   **Example**:
   ```java
   class Student {
       String name;
       int rollNo;

       Student(String name, int rollNo) {
           this.name = name;
           this.rollNo = rollNo;
       }

       @Override
       public String toString() {
           return "Student{name='" + name + "', rollNo=" + rollNo + "}";
       }
   }

   List<Student> students = Arrays.asList(
       new Student("Alice", 2),
       new Student("Alice", 1),
       new Student("Bob", 3)
   );

   Comparator<Student> byName = Comparator.comparing(student -> student.name);
   Comparator<Student> byRollNo = Comparator.comparingInt(student -> student.rollNo);

   students.sort(byName.thenComparing(byRollNo)); // Sort by name, then roll number
   System.out.println(students);
   ```

   **Output**:
   ```
   [Student{name='Alice', rollNo=1}, Student{name='Alice', rollNo=2}, Student{name='Bob', rollNo=3}]
   ```

---

#### 4. **`comparing(Function<? super T, ? extends U> keyExtractor)`**
   - Creates a comparator based on the value extracted from objects.

   **Example**:
   ```java
   List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
   names.sort(Comparator.comparing(String::length)); // Sort by string length
   System.out.println(names); // Output: [Bob, Alice, Charlie]
   ```

---

#### 5. **`comparingInt(ToIntFunction<? super T> keyExtractor)`**
   - Specialized for primitive `int` values to avoid boxing overhead.

   **Example**:
   ```java
   Comparator<Student> byRollNo = Comparator.comparingInt(student -> student.rollNo);
   ```

---

#### 6. **`comparingDouble(ToDoubleFunction<? super T> keyExtractor)`**
   - Specialized for `double` values.

   **Example**:
   ```java
   List<Double> marks = Arrays.asList(98.5, 92.0, 85.5);
   marks.sort(Comparator.comparingDouble(mark -> mark));
   System.out.println(marks); // Output: [85.5, 92.0, 98.5]
   ```

---

#### 7. **`comparingLong(ToLongFunction<? super T> keyExtractor)`**
   - Specialized for `long` values.

   **Example**:
   ```java
   Comparator<Student> byRollNo = Comparator.comparingLong(student -> student.rollNo);
   ```

---

#### 8. **`naturalOrder()`**
   - Returns a comparator that uses the **natural ordering** of the objects.

   **Example**:
   ```java
   List<Integer> numbers = Arrays.asList(3, 1, 2);
   numbers.sort(Comparator.naturalOrder());
   System.out.println(numbers); // Output: [1, 2, 3]
   ```

---

#### 9. **`reverseOrder()`**
   - Returns a comparator that sorts in the **reverse of natural ordering**.

   **Example**:
   ```java
   numbers.sort(Comparator.reverseOrder());
   System.out.println(numbers); // Output: [3, 2, 1]
   ```

---

#### 10. **`nullsFirst(Comparator<? super T> comparator)`**
   - Handles `null` values by putting them **before non-null values**.

   **Example**:
   ```java
   List<String> names = Arrays.asList("Bob", null, "Alice");
   names.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
   System.out.println(names); // Output: [null, Alice, Bob]
   ```

---

#### 11. **`nullsLast(Comparator<? super T> comparator)`**
   - Handles `null` values by putting them **after non-null values**.

   **Example**:
   ```java
   names.sort(Comparator.nullsLast(Comparator.naturalOrder()));
   System.out.println(names); // Output: [Alice, Bob, null]
   ```

---

#### 12. **`equals(Object obj)`**
   - Checks if the current comparator is equal to another object.
   - **Rarely used explicitly**, as it is inherited from `Object`.

---

### **Summary Table of Methods**

| Method                        | Purpose                                                     |
|-------------------------------|-------------------------------------------------------------|
| `compare(T o1, T o2)`         | Primary method for comparison.                              |
| `reversed()`                  | Reverses the current comparator.                           |
| `thenComparing(...)`          | Adds secondary sorting logic.                              |
| `comparing(...)`              | Creates a comparator based on a key extractor.             |
| `comparingInt(...)`           | Specialized for `int` keys.                                |
| `comparingDouble(...)`        | Specialized for `double` keys.                             |
| `comparingLong(...)`          | Specialized for `long` keys.                               |
| `naturalOrder()`              | Sorts using natural order.                                 |
| `reverseOrder()`              | Sorts using reverse of natural order.                      |
| `nullsFirst(...)`             | Places `null` values before non-null values.               |
| `nullsLast(...)`              | Places `null` values after non-null values.                |
| `equals(Object obj)`          | Checks equality of comparators.                            |

---

These methods make `Comparator` a very powerful tool in Java, especially with the enhancements introduced in Java 8!