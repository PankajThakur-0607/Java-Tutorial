Sure, let's look at examples of both static and non-static inner classes in Java.

### Non-Static Inner Class

A non-static inner class is associated with an instance of its outer class. It can access all members (including private members) of the outer class.

#### Example:

```java
public class OuterClass {
    private String outerField = "Outer field value";

    // Non-static inner class
    public class InnerClass {
        private String innerField = "Inner field value";

        public void display() {
            // Accessing outer class field
            System.out.println("Outer field: " + outerField);
            // Accessing inner class field
            System.out.println("Inner field: " + innerField);
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the outer class
        OuterClass outer = new OuterClass();

        // Creating an instance of the inner class
        OuterClass.InnerClass inner = outer.new InnerClass();

        // Calling the method of the inner class
        inner.display();
    }
}
```

#### Output:
```
Outer field: Outer field value
Inner field: Inner field value
```

### Static Inner Class

A static inner class is not associated with an instance of its outer class. It can only access static members of the outer class.

#### Example:

```java
public class OuterClass {
    private static String staticOuterField = "Static outer field value";

    // Static inner class
    public static class StaticInnerClass {
        private String innerField = "Inner field value";

        public void display() {
            // Accessing static outer class field
            System.out.println("Static outer field: " + staticOuterField);
            // Accessing inner class field
            System.out.println("Inner field: " + innerField);
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the static inner class
        OuterClass.StaticInnerClass inner = new OuterClass.StaticInnerClass();

        // Calling the method of the static inner class
        inner.display();
    }
}
```

#### Output:
```
Static outer field: Static outer field value
Inner field: Inner field value
```

### Summary

- **Non-Static Inner Class**: Requires an instance of the outer class to be created. Can access all members of the outer class.
- **Static Inner Class**: Does not require an instance of the outer class. Can only access static members of the outer class.

These examples should help you understand the differences and usage of static and non-static inner classes in Java.