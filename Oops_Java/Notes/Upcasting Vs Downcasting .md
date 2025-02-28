Great question! Let's dive deeper into why **`Box box = new BoxWeight();` is allowed**, but **`BoxWeight box1 = new Box();` is not**.

---

## **1️⃣ Understanding Inheritance and Type Assignment**

When working with inheritance in Java:

- A **subclass** (`BoxWeight`) **inherits from** a **superclass** (`Box`).
- This means `BoxWeight` **"is a"** `Box`, but **not vice versa**.
- Java allows **upcasting** (assigning a subclass object to a superclass reference).
- But Java **disallows downcasting** (assigning a superclass object to a subclass reference) **without explicit casting**.

---

## **2️⃣ Example Code**

Let's say we have the following classes:

```java
class Box {
    int height, width, length;

    Box(int h, int w, int l) {
        this.height = h;
        this.width = w;
        this.length = l;
        System.out.println("Box constructor");
    }
}

class BoxWeight extends Box {
    int weight;

    BoxWeight(int h, int w, int l, int weight) {
        super(h, w, l); // Calling the parent class constructor
        this.weight = weight;
        System.out.println("BoxWeight constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        // ✅ Allowed: Upcasting (Subclass -> Superclass)
        Box box = new BoxWeight(1, 2, 3, 4);
        System.out.println(box);

        // ❌ Not Allowed: Downcasting (Superclass -> Subclass)
        BoxWeight box1 = new Box(1, 2, 3); // ERROR
        System.out.println(box1);
    }
}
```

---

## **3️⃣ Why `Box box = new BoxWeight();` is Allowed (Upcasting)**

✅ **This is called "Upcasting"**, and it's allowed in Java.

```java
Box box = new BoxWeight(1, 2, 3, 4);
```

- Here, `box` is a reference of **type `Box`**, but it actually holds an object of **type `BoxWeight`**.
- Since `BoxWeight` **inherits from `Box`**, a `BoxWeight` object **is a** `Box`, so Java allows this.
- However, because `box` is of type `Box`, it can **only access** the members of `Box`, **not** `BoxWeight`.

🔹 **Example: This will work**

```java
box.height = 5; // ✅ Allowed (Box has 'height' variable)
```

🔹 **This will NOT work**

```java
box.weight = 10; // ❌ Error (Box does NOT have 'weight' variable)
```

- Even though `box` actually refers to a `BoxWeight` object, the compiler only allows access to the members of `Box` because `box` is declared as type `Box`.

---

## **4️⃣ Why `BoxWeight box1 = new Box();` is NOT Allowed (Downcasting)**

❌ **This is called "Downcasting"**, and Java does not allow it implicitly.

```java
BoxWeight box1 = new Box(1, 2, 3); // ❌ Compilation Error
```

### **Why?**

- `Box` **is NOT necessarily a** `BoxWeight`.
- A **parent class does NOT have all the properties of its child class**.
- The `Box` class **does not have** the `weight` field from `BoxWeight`, so allowing this assignment would be unsafe.
- If Java allowed this, it would lead to **a situation where a reference to `BoxWeight` exists but does not actually contain `weight` data**—which would break type safety.

🔹 **Example of the Issue**

```java
BoxWeight box1 = new Box(1, 2, 3);
box1.weight = 10; // ❌ What weight? Box objects do NOT have a weight variable!
```

### **Explicit Downcasting (Unsafe)**

If you really need to assign a `Box` object to a `BoxWeight` variable, you must **explicitly cast it**:

```java
Box box2 = new BoxWeight(1, 2, 3, 4);
BoxWeight box3 = (BoxWeight) box2; // ✅ Allowed, but risky
```

However, if `box2` were actually an instance of `Box` (not `BoxWeight`), this would cause a **ClassCastException at runtime**.

---

## **5️⃣ Key Takeaways**

| **Operation**                                   | **Allowed?**                        | **Why?**                                                       |
| ----------------------------------------------- | ----------------------------------- | -------------------------------------------------------------- |
| `Box box = new BoxWeight();`                    | ✅ Yes                              | **Upcasting** - A `BoxWeight` **is a** `Box`                   |
| `BoxWeight box1 = new Box();`                   | ❌ No                               | **Downcasting** - A `Box` is **not necessarily** a `BoxWeight` |
| `BoxWeight box3 = (BoxWeight) new BoxWeight();` | ✅ Yes (with explicit cast)         | Works if `BoxWeight` object is assigned to `Box` first         |
| `BoxWeight box4 = (BoxWeight) new Box();`       | ❌ No (throws `ClassCastException`) | A `Box` object **does not have** `BoxWeight` properties        |

---

### **Final Thoughts**

- ✅ **Upcasting (Subclass → Superclass) is always safe and allowed.**
- ❌ **Downcasting (Superclass → Subclass) is unsafe** and only works **if the object was originally of the subclass type**.
- 🛑 **If you downcast incorrectly, you will get a `ClassCastException` at runtime!**

Let me know if you need more clarification! 🚀
