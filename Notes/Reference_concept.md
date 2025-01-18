In Java, understanding **pass by value** and **pass by reference** can sometimes be confusing. Let's break this down in simple terms and in detail.

### 1. **Pass by Value in Java**
In Java, **everything** is passed by **value**. This means that when you pass an argument to a method, **a copy** of the variable’s value is passed, not the original reference itself.

- **For primitive types** (like `int`, `char`, `boolean`), Java creates a copy of the actual value.
- **For objects** (like arrays, classes, or any custom objects), Java creates a copy of the **reference** to the object in memory, not the actual object itself.

Let’s dive deeper into each case.

### 2. **Pass by Value with Primitives**
When you pass primitive types (like `int`, `char`, etc.) to a method, Java creates a **copy** of the value. This means that changes made inside the method do not affect the original variable.

#### Example:
```java
public class PassByValueExample {
    public static void main(String[] args) {
        int x = 10;
        modifyValue(x);  // Passing x by value (a copy of x)
        System.out.println("After method call, x = " + x);  // x is still 10
    }

    public static void modifyValue(int a) {
        a = 20;  // This only changes the copy, not the original x
        System.out.println("Inside method, a = " + a);  // a is 20
    }
}
```

#### Output:
```
Inside method, a = 20
After method call, x = 10
```

- **Explanation**: In this case, the variable `x` is passed by value, so the method `modifyValue()` works on a **copy** of `x`. Changes inside the method don’t affect the original value of `x`.

### 3. **Pass by Value with Objects**
When you pass an object (like an array, `LinkedList`, or any class instance) to a method, Java **passes the reference** to the object by value. This means that a **copy of the reference** to the object is passed to the method. Both the original reference (in the calling method) and the reference inside the method point to the **same object** in memory. 

This is why changes made to the object inside the method **reflect on the original object**.

#### Example:
```java
import java.util.LinkedList;

public class PassByReferenceExample {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();
        myList.add("Apple");
        
        modifyList(myList);  // Passing the reference to the LinkedList
        System.out.println("After method call: " + myList);  // The list is modified
    }

    public static void modifyList(LinkedList<String> list) {
        list.add("Banana");  // This changes the original list
        System.out.println("Inside method: " + list);  // List now has Apple and Banana
    }
}
```

#### Output:
```
Inside method: [Apple, Banana]
After method call: [Apple, Banana]
```

- **Explanation**: Here, `myList` is a reference to a `LinkedList` object. When passed to the method, Java passes a **copy of the reference** to the same object. Any changes made to the object through this reference will be reflected in the original list because both the original variable and the method parameter point to the **same object** in memory.

### 4. **Why People Get Confused**
Some people mistakenly say that Java passes objects by reference because changes to objects inside methods affect the original objects. However, it's still **pass by value** because Java passes a **copy of the reference**, not the reference itself.

Here’s an analogy:
- Think of the **object** as a house.
- The **reference** to the object is the house’s address (where it is located).
- When you pass the address (reference) to a method, a **copy of the address** is passed, but both copies still point to the **same house**.
- If the person with the copied address modifies the house (the object), those changes will be seen by everyone with the same address.

### 5. **Pass by Value – Simplified**
- **Primitives (like `int`, `double`, `char`)**: A **copy** of the value is passed, so changes inside the method do not affect the original variable.
- **Objects**: A **copy of the reference** (not the object itself) is passed. The reference points to the same object, so changes to the object inside the method **do affect** the original object.

### 6. **Common Misunderstanding**
One common misconception is that objects are passed by reference because when you modify an object inside a method, the changes affect the original object. But this happens because the reference is passed by value.

#### Example of a Misconception:
```java
public class Test {
    public static void main(String[] args) {
        Car myCar = new Car("Blue");
        changeCar(myCar);  // People think the car object is passed by reference, but it's not
        System.out.println(myCar.color);  // Output: Blue, not Red
    }

    public static void changeCar(Car car) {
        car = new Car("Red");  // This creates a new car object, does not affect the original car
    }
}
```

- **Explanation**: In this case, we passed the **reference** to `myCar` by value. Inside `changeCar()`, we assigned a new object to `car`. But this only changes the local copy of the reference, not the original reference `myCar`. Therefore, the color of `myCar` remains "Blue".

### 7. **Visualizing with Diagrams**
#### Primitive (Pass by Value)
```
main()                        modifyValue()
  x = 10      ---->     [ a (copy of x) = 10 ]
  x remains unchanged.
```

#### Object (Pass by Value of Reference)
```
main()                        modifyList()
  myList --> [LinkedList Object]      list --> [Same LinkedList Object]
Changes made to the object through the reference are visible in both.
```

### 8. **Summary**
- **Java is always pass by value**, even for objects.
- For **primitive types**, a **copy** of the value is passed, and changes in the method do not affect the original variable.
- For **objects**, a **copy of the reference** is passed, meaning that changes made to the object inside the method **affect the original object**, but changes to the reference (e.g., reassigning it) do not affect the original reference.

Let me know if you need further clarification!