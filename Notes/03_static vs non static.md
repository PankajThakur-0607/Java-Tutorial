Yes, the outer class can access the methods and data members of both static and non-static inner classes. Here's how it works, with detailed examples and explanations.

### Static Nested Class

**Example:**

```java
public class Book {
    // Static nested class
    public static class Page {
        private int pageNumber;

        public Page(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public void printPageNumber() {
            System.out.println("Page Number: " + pageNumber);
        }
    }

    private String title;

    public Book(String title) {
        this.title = title;
    }

    public void printTitle() {
        System.out.println("Book Title: " + title);
    }

    public void createAndUseStaticPage() {
        // Creating an instance of the static nested class
        Page page = new Page(1);
        page.printPageNumber(); // Output: Page Number: 1
    }

    public static void main(String[] args) {
        Book book = new Book("Java Programming");
        book.printTitle(); // Output: Book Title: Java Programming
        book.createAndUseStaticPage();
    }
}
```

### Explanation:

1. **Static Nested Class Definition:**
   - `Page` is a static nested class within `Book`.
   - It has a private member `pageNumber` and a method `printPageNumber()` to print the page number.

2. **Outer Class:**
   - The `Book` class has a private member `title` and a method `printTitle()` to print the book title.
   - The `createAndUseStaticPage()` method in `Book` creates an instance of the static nested class `Page` and calls its `printPageNumber()` method.

3. **Accessing Static Nested Class:**
   - The outer class `Book` creates an instance of the static nested class `Page` directly using `new Page(1)` within the `createAndUseStaticPage()` method.
   - The outer class then calls the `printPageNumber()` method on this instance.

### Non-Static Inner Class

**Example:**

```java
public class Book {
    // Non-static inner class
    public class Page {
        private int pageNumber;

        public Page(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public void printPageNumber() {
            System.out.println("Page Number: " + pageNumber);
        }

        // Method to access the outer class's title
        public void printBookTitle() {
            System.out.println("Book Title: " + title);
        }
    }

    private String title;

    public Book(String title) {
        this.title = title;
    }

    public void printTitle() {
        System.out.println("Book Title: " + title);
    }

    public void createAndUseInnerPage() {
        // Creating an instance of the non-static inner class
        Page page = new Page(1);
        page.printPageNumber(); // Output: Page Number: 1
        page.printBookTitle();  // Output: Book Title: Java Programming
    }

    public static void main(String[] args) {
        Book book = new Book("Java Programming");
        book.printTitle(); // Output: Book Title: Java Programming
        book.createAndUseInnerPage();
    }
}
```

### Explanation:

1. **Non-Static Inner Class Definition:**
   - `Page` is a non-static inner class within `Book`.
   - It has a private member `pageNumber` and methods `printPageNumber()` and `printBookTitle()` to print the page number and book title, respectively.

2. **Outer Class:**
   - The `Book` class has a private member `title` and a method `printTitle()` to print the book title.
   - The `createAndUseInnerPage()` method in `Book` creates an instance of the non-static inner class `Page` and calls its `printPageNumber()` and `printBookTitle()` methods.

3. **Accessing Non-Static Inner Class:**
   - The outer class `Book` creates an instance of the inner class `Page` using `new Page(1)` within the `createAndUseInnerPage()` method.
   - The outer class then calls the `printPageNumber()` and `printBookTitle()` methods on this instance.

### Summary

- **Static Nested Class:**
  - The outer class can access the static nested class by directly creating an instance of it and calling its methods.
  - Example: `Page page = new Page(1);`

- **Non-Static Inner Class:**
  - The outer class can access the non-static inner class by creating an instance of it within an instance of the outer class and then calling its methods.
  - Example: `Page page = new Page(1);`

In both cases, the outer class can access the methods and data members of the inner class, but the approach to creating instances and accessing methods differs slightly due to the nature of static and non-static classes.














Sure! Here is a simple example demonstrating a non-static inner class accessing methods and members of the outer class:

### Example: Outer and Inner Classes

```java
public class OuterClass {
    private String outerField;

    public OuterClass(String outerField) {
        this.outerField = outerField;
    }

    public void outerMethod() {
        System.out.println("OuterClass method called!");
    }

    // Non-static inner class
    public class InnerClass {
        private int innerField;

        public InnerClass(int innerField) {
            this.innerField = innerField;
        }

        public void innerMethod() {
            // Accessing the outer class's method
            outerMethod();
            // Accessing the outer class's field
            System.out.println("Outer field: " + outerField);
            // Accessing the inner class's field
            System.out.println("Inner field: " + innerField);
        }
    }

    public void createAndUseInnerClass() {
        // Creating an instance of the non-static inner class
        InnerClass inner = new InnerClass(42);
        inner.innerMethod();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass("Hello, World!");
        outer.createAndUseInnerClass();
    }
}
```

### Explanation:

1. **Outer Class Definition:**
   - `OuterClass` has a private field `outerField` and a method `outerMethod()` that prints a message.

2. **Non-Static Inner Class Definition:**
   - `InnerClass` is defined inside `OuterClass` and is non-static.
   - It has a private field `innerField` and a method `innerMethod()`.

3. **Inner Class Accessing Outer Class Members:**
   - Inside `innerMethod()`, the inner class calls the outer class's method `outerMethod()` and accesses the outer class's field `outerField`.
   - It also prints its own field `innerField`.

4. **Creating and Using the Inner Class:**
   - The method `createAndUseInnerClass()` in `OuterClass` creates an instance of `InnerClass` and calls its method `innerMethod()`.

5. **Main Method:**
   - The main method creates an instance of `OuterClass` and calls `createAndUseInnerClass()`, demonstrating the inner class accessing the outer class.

### Output:

When you run the code, the output will be:

```
OuterClass method called!
Outer field: Hello, World!
Inner field: 42
```

This example shows how the non-static inner class `InnerClass` can access the outer class's method `outerMethod()` and field `outerField`, demonstrating the close relationship between an outer class and its non-static inner class.




















If you want to create an instance of the non-static inner class directly in the `main` method, you must first create an instance of the outer class because a non-static inner class instance is tied to an instance of the outer class. Here’s how you can do it:

### Example: Creating an Instance of the Non-Static Inner Class in the `main` Method

```java
public class OuterClass {
    private String outerField;

    public OuterClass(String outerField) {
        this.outerField = outerField;
    }

    public void outerMethod() {
        System.out.println("OuterClass method called!");
    }

    // Non-static inner class
    public class InnerClass {
        private int innerField;

        public InnerClass(int innerField) {
            this.innerField = innerField;
        }

        public void innerMethod() {
            // Accessing the outer class's method
            outerMethod();
            // Accessing the outer class's field
            System.out.println("Outer field: " + outerField);
            // Accessing the inner class's field
            System.out.println("Inner field: " + innerField);
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the outer class
        OuterClass outer = new OuterClass("Hello, World!");

        // Creating an instance of the non-static inner class
        InnerClass inner = outer.new InnerClass(42);
        inner.innerMethod();
    }
}
```

### Explanation:

1. **Outer Class Definition:**
   - `OuterClass` has a private field `outerField` and a method `outerMethod()` that prints a message.

2. **Non-Static Inner Class Definition:**
   - `InnerClass` is defined inside `OuterClass` and is non-static.
   - It has a private field `innerField` and a method `innerMethod()`.

3. **Inner Class Accessing Outer Class Members:**
   - Inside `innerMethod()`, the inner class calls the outer class's method `outerMethod()` and accesses the outer class's field `outerField`.
   - It also prints its own field `innerField`.

4. **Creating and Using the Inner Class in `main`:**
   - In the `main` method, create an instance of the outer class `OuterClass`.
   - Using this instance, create an instance of the non-static inner class `InnerClass`.
   - Call the `innerMethod()` on the inner class instance.

### Output:

When you run the code, the output will be:

```
OuterClass method called!
Outer field: Hello, World!
Inner field: 42
```

### Detailed Steps in `main` Method:

1. **Create an Instance of the Outer Class:**
   - `OuterClass outer = new OuterClass("Hello, World!");`
   - This instance `outer` is necessary to create an instance of the non-static inner class.

2. **Create an Instance of the Inner Class:**
   - `InnerClass inner = outer.new InnerClass(42);`
   - The syntax `outer.new InnerClass(42)` ties the new instance of `InnerClass` to the instance of `OuterClass` (i.e., `outer`).

3. **Call the Inner Class Method:**
   - `inner.innerMethod();`
   - This calls the `innerMethod()` of the inner class, which accesses both the outer class’s and the inner class’s fields and methods.