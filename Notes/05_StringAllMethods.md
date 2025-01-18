Java provides a rich set of methods for manipulating `String` objects. Below is a comprehensive list of commonly used `String` methods, along with brief descriptions of what they do:

### 1. **`char charAt(int index)`**
   - Returns the character at the specified index.
   - Example:
     ```java
     String s = "Hello";
     char c = s.charAt(1); // 'e'
     ```

### 2. **`int length()`**
   - Returns the length of the string.
   - Example:
     ```java
     String s = "Hello";
     int len = s.length(); // 5
     ```

### 3. **`String substring(int beginIndex)`**
   - Returns a substring starting from `beginIndex` to the end of the string.
   - Example:
     ```java
     String s = "Hello";
     String sub = s.substring(2); // "llo"
     ```

### 4. **`String substring(int beginIndex, int endIndex)`**
   - Returns a substring starting from `beginIndex` and ending at `endIndex - 1`.
   - Example:
     ```java
     String s = "Hello";
     String sub = s.substring(1, 4); // "ell"
     ```

### 5. **`boolean equals(Object another)`**
   - Compares this string to another object for equality.
   - Example:
     ```java
     String s1 = "Hello";
     String s2 = "Hello";
     boolean isEqual = s1.equals(s2); // true
     ```

### 6. **`boolean equalsIgnoreCase(String another)`**
   - Compares this string to another string, ignoring case differences.
   - Example:
     ```java
     String s1 = "Hello";
     String s2 = "hello";
     boolean isEqual = s1.equalsIgnoreCase(s2); // true
     ```

### 7. **`int compareTo(String another)`**
   - Compares two strings lexicographically.
   - Example:
     ```java
     String s1 = "apple";
     String s2 = "banana";
     int result = s1.compareTo(s2); // negative (because "apple" is lexicographically less than "banana")
     ```

### 8. **`boolean startsWith(String prefix)`**
   - Checks if the string starts with the specified prefix.
   - Example:
     ```java
     String s = "Hello";
     boolean starts = s.startsWith("He"); // true
     ```

### 9. **`boolean endsWith(String suffix)`**
   - Checks if the string ends with the specified suffix.
   - Example:
     ```java
     String s = "Hello";
     boolean ends = s.endsWith("lo"); // true
     ```

### 10. **`boolean contains(CharSequence sequence)`**
   - Checks if the string contains the specified sequence of characters.
   - Example:
     ```java
     String s = "Hello";
     boolean contains = s.contains("ell"); // true
     ```

### 11. **`String replace(char oldChar, char newChar)`**
   - Returns a new string with all occurrences of `oldChar` replaced with `newChar`.
   - Example:
     ```java
     String s = "Hello";
     String replaced = s.replace('l', 'p'); // "Heppo"
     ```

### 12. **`String replace(CharSequence target, CharSequence replacement)`**
   - Replaces each substring of the string that matches the target sequence with the replacement sequence.
   - Example:
     ```java
     String s = "Hello World";
     String replaced = s.replace("World", "Java"); // "Hello Java"
     ```

### 13. **`String[] split(String regex)`**
   - Splits the string based on the given regular expression and returns an array of substrings.
   - Example:
     ```java
     String s = "Hello World";
     String[] words = s.split(" "); // ["Hello", "World"]
     ```

### 14. **`String[] split(String regex, int limit)`**
   - Splits the string based on the regular expression, but limits the number of substrings returned.
   - Example:
     ```java
     String s = "a,b,c";
     String[] parts = s.split(",", 2); // ["a", "b,c"]
     ```

### 15. **`String toLowerCase()`**
   - Converts all characters in the string to lowercase.
   - Example:
     ```java
     String s = "HELLO";
     String lower = s.toLowerCase(); // "hello"
     ```

### 16. **`String toUpperCase()`**
   - Converts all characters in the string to uppercase.
   - Example:
     ```java
     String s = "hello";
     String upper = s.toUpperCase(); // "HELLO"
     ```

### 17. **`String trim()`**
   - Removes whitespace from both ends of the string.
   - Example:
     ```java
     String s = "   Hello   ";
     String trimmed = s.trim(); // "Hello"
     ```

### 18. **`int indexOf(char ch)`**
   - Returns the index of the first occurrence of the character `ch` in the string.
   - Example:
     ```java
     String s = "Hello";
     int index = s.indexOf('e'); // 1
     ```

### 19. **`int indexOf(String str)`**
   - Returns the index of the first occurrence of the specified substring.
   - Example:
     ```java
     String s = "Hello World";
     int index = s.indexOf("World"); // 6
     ```

### 20. **`int lastIndexOf(char ch)`**
   - Returns the index of the last occurrence of the character `ch` in the string.
   - Example:
     ```java
     String s = "Hello";
     int index = s.lastIndexOf('l'); // 3
     ```

### 21. **`int lastIndexOf(String str)`**
   - Returns the index of the last occurrence of the specified substring.
   - Example:
     ```java
     String s = "Hello World World";
     int index = s.lastIndexOf("World"); // 12
     ```

### 22. **`boolean isEmpty()`**
   - Checks if the string is empty (i.e., length is 0).
   - Example:
     ```java
     String s = "";
     boolean empty = s.isEmpty(); // true
     ```

### 23. **`String join(CharSequence delimiter, CharSequence... elements)`**
   - Joins the specified elements with the given delimiter.
   - Example:
     ```java
     String joined = String.join("-", "a", "b", "c"); // "a-b-c"
     ```

### 24. **`byte[] getBytes()`**
   - Encodes the string into a sequence of bytes using the platform's default charset.
   - Example:
     ```java
     String s = "Hello";
     byte[] bytes = s.getBytes();
     ```

### 25. **`char[] toCharArray()`**
   - Converts the string into a new character array.
   - Example:
     ```java
     String s = "Hello";
     char[] chars = s.toCharArray(); // ['H', 'e', 'l', 'l', 'o']
     ```

### 26. **`boolean matches(String regex)`**
   - Tells whether the string matches the given regular expression.
   - Example:
     ```java
     String s = "12345";
     boolean isNumeric = s.matches("\\d+"); // true (checks if it's numeric)
     ```

### 27. **`String intern()`**
   - Returns a canonical representation of the string from the string pool.
   - Example:
     ```java
     String s1 = new String("Hello").intern();
     String s2 = "Hello";
     boolean same = (s1 == s2); // true
     ```

### 28. **`String concat(String str)`**
   - Concatenates the specified string to the end of the current string.
   - Example:
     ```java
     String s = "Hello";
     String result = s.concat(" World"); // "Hello World"
     ```

### 29. **`String valueOf(Object obj)`**
   - Returns the string representation of the passed argument.
   - Example:
     ```java
     int num = 100;
     String s = String.valueOf(num); // "100"
     ```

### 30. **`static String format(String format, Object... args)`**
   - Returns a formatted string using the specified format string and arguments.
   - Example:
     ```java
     String s = String.format("My name is %s and I am %d years old.", "John", 25);
     // "My name is John and I am 25 years old."
     ```

---

These are some of the most frequently used `String` methods in Java. They offer a wide variety of functionalities, ranging from basic string manipulation to more advanced operations like regular expressions and formatting.