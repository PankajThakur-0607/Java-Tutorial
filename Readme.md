# **Java DSA Tutorial**

### Welcome to the Java Data Structures and Algorithms

### **Topics Covered**

#### **_(DSA) Tutorial!_** This repository is designed to help you learn and implement fundamental DSA concepts in Java, with clear examples and explanations.

### Topics Covered

- Arrays , Strings and LinkedList
- Stacks and Queues
- Trees and Graphs
- Sorting and Searching Algorithms
- Backtracking and Recursion

---

### **Prerequisites** <!-- __Prerequisites__ -->

#### Before you begin, ensure you have the following tools and environments set up:

<!-- :smile:  :cry:   --for emojis   ==> or directly add the emojis  -->

1. **Java Development Kit (JDK)** : Version 8 or later.

   - [Download JDK](https://www.oracle.com/java/technologies/downloads/?er=221886)

2. **VS Code** (Recommended IDE for Beginners):

   - Install the [VS Code Editor](https://code.visualstudio.com/download).

3. **Other IDE Options**(Optional):

   - [Intellij IDE](https://www.jetbrains.com/idea/).
   - [Eclipse IDE](https://www.eclipse.org/downloads/)
   <!-- we can do like this <https://google.com> -->

4. **Git:** For cloning and managing the repository.
   - [Download Git](https://git-scm.com/)

## 1. **Introduction to Java and DSA**

### Why Java for DSA ?

> - Java is one of the most popular programming languages for DSA due to:
>
> - Platform Independence: Write once, run anywhere.
> - Built-in Libraries: Extensive support for data structures like ArrayList, HashMap, and Stack.
> - Object-Oriented Approach: Helps model real-world problems effectively.

### Why Learn DSA?

Mastering DSA will help you:

> - Solve real-world problems efficiently.
> - Build scalable and optimized applications.
> - Crack coding interviews at top tech companies.

## 2. Learning Path

Follow this sequence for the best learning experience:

1. Arrays and Strings
   - Basics, Traversal, Searching, Sorting.
2. Linked Lists
   - Single, Double, and Circular Linked Lists.
3. Stacks and Queues
   - LIFO and FIFO implementations.
4. Trees and Graphs
   - Binary Trees, BSTs, DFS, BFS.
5. Sorting and Searching Algorithms
   - Merge Sort, Quick Sort, Binary Search.
6. Recuriosn & Backtracking
   - N-Queens, Sudoku Solver.

## 3. Practice Problems

Enhance your skills by solving problems on these platforms:

- [Leetcode](https://leetcode.com/)
- [HackerRank](https://www.hackerrank.com/)
- [GeeksForgeeks](https://www.geeksforgeeks.org/)
- [Codeforces](https://codeforces.com/)

## 4. Sample Code

Here’s an example of Binary Search implementation:

```Java
    public class BinarySearch {
    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {1, 3, 5, 7, 9};
        int index = bs.binarySearch(nums, 5);
        System.out.println("Index of 5: " + index);
    }
}

```

## 5. Resources for Further Learning

Expand your knowledge with these resources:

- Books:

  - [Introduction to Algorithms](https://dl.ebooksworld.ir/books/Introduction.to.Algorithms.4th.Leiserson.Stein.Rivest.Cormen.MIT.Press.9780262046305.EBooksWorld.ir.pdf) by Cormen.
  - [Cracking the Coding Interview](https://www.crackingthecodinginterview.com/) by Gayle Laakmann McDowell

- Youtube Channels:

  - [Kunal Kushwaha](https://www.youtube.com/watch?v=rZ41y93P2Qo&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ)
  - [Apna College](https://www.youtube.com/@ApnaCollegeOfficial)

<!-- ![How Java Executes the Code](https://media.geeksforgeeks.org/wp-content/uploads/20240812155117/How-Java-Code-Executes.png) -->

<!-- In Github markdown it doesnt work so use the HTML instead  -->
<!-- ## ~~Crossed Off~~ -->
<!-- this is a ~subscript~
this is a ^superScript^ -->
<!--

N<sup>2</sup>
H<sub>2</sub>O -->

<!-- |Col 1   |Col2     |
|:-----: |---      |
|this    | example |
|is      |with     |
|a       |col      | -->
