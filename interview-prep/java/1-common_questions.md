1. What is Method Overloading vs Method Overriding?
- **Method overloading** means in the same class, you can have multiple methods with the same name, but they have to have either different types of parameters, or different number of parameters.
- **Method overriding** has to do with inheritance, where a child class can implement a method that it got from a parent class

2. What are the differences between the Heap and Stack memory.
- The **Stack memory** is the amount of memory allocated for each individual program. It is a `fixed` memory space, a dedicated part of memory. This is where things like `local variables`, `parameters` and things like that are going to live. So let's say if you have a method call or a recursive call, when the call starts, the program needs to save the local variables of the current method...so it will store it inside the stack. To many method calls/recursive calls, or too many things stored in the stack, will cause a `Stack Overflow`

- The `Heap memory` grows and shrinks dynamically as your program runs. When your program is running and you need to allocate space, you're going to use something like the `new` keyword. What it does is that it checks if there is space on the heap, if there is, the new object created is stored in the heap. If the object goes out of scope, it frees up that memory. If you allocate too much space, the heap can also run out of memory and your program can crash.

3. What are shallow copy and deep copy.
- Usually, when we have an object, we allocate a portion of memory to that object. And that object can store values. Now, when we create another object which points to the first object, whenever we change the value of the second object, it is going to affect the value of the first object. This is a `shallow copy`. Assume we have a class `Example`, with a variable `x`
```java
Example example1 = new Example();
example1.x = 100;

Example example2 = example1;
example2.x = 500;

System.out.print(example1.value); // prints 500 because example2 points to the same reference as example1.
```

- With a deep copy, it is the exact opposite. We would have to create a new object of example2, so that it will point to its own reference. So changing the value of example2 will not affect that of example1
```java
Example example1 = new Example();
example1.x = 100;

Example example2 = new Example();
example2.x = 500;

System.out.print(example1.value); // remains 100
System.out.print(example2.value); // prints 500
```

4. What is the garbage collector and how does it work?
- The main objective of a Garbage Collector is to free up memory space that is not being used anymore. This ensures that the memory resources are being used efficiently. We know that the heap grows and shrinks. When we use the new keyword, a portion of memory is used. But in a situation where the value in that memory is not being used anymore, the garbage collector comes in and de-allocates the memory from that value, and the heap shrinks. 

5. What are the difference between the `constructor` and a `method` of a class in Java?
- A constructor has the same name of the class, and it does'nt have a return type. When you create a new object, the constructor get's invoked implicitly. It's impossible for a subclass to inherit the constructor of its parent class. A constructor is a method, but a method is not a constructor
- A method has different names, they have return types. Methods are not called unless we explicitly call them. A child class can inherit the methods of its parent class(if its public).

6. What is the `this` keyword in Java?
- In java, whenever you're within a class and you want to call a method or reference one of the variables on the class level, you can use the `this` keyword. A more practical use of this keyword is when you have a parameter in your constructor, and you want to set that parameter to something. Without the `this` keyword, the constructor will use the most local variable(the parameter) and try to set the parameter to itself...which is not possible. So you use the `this` keyword to make that distinction.

7. What is an abstract class?
- An abstract class is a class that cannot be instantiated(you cannot create methods of it). Let's say you are building a game, and that game has enemies, and those enemies can attack. You can have different types of enemies.(ghosts, goblins, wizards etc). These types of enemies will extend the enemy class itself, and use their own attack. But we don't really want a generic enemy, because it wouldnt make sense. The enemy is just a (abstract) concept that we're using to define something in our game. In this case, we can define the enemy class as abstract, so that we cannot really create a `new` object of the enemy class. But we can inherit from it.

8. What is the `super` keyword in Java?
- `super` refers to the Super Class. Whenever we are in a child class and we want to refer to something in it's parent/super class, we use the `super` keyword.

9. How is the `final` keyword applied differently between variables, methods, and classes?
- Final methods cannot be overridden in children classes
- Final variables cannot be reassigned
- Final classes cannot be extended. ie they do not support inheritance.

10. What is `protected` in Java?
- The protected keyword allows us to access a method, class, variable etc..within a package, but not outside that package. Just like `private` stuff can only be used in the class, `protected` stuff can only be used in the package.

11. What is the difference between `equals()` and `==` in Java?
- The `==` is a comparison operator. It checks if two entities are at the same reference/memory location.
- The `.equals()` is a method. It evaluates the content of that reference/memory space.

12. Is Java "Pass by Reference" or "Pass by Value"?
- Java is pass by value.

13. What is a Singleton class and how do you ensure that a class is a Singleton 
- A singleton is a class that ensures that only one instance of the class can ever exist. And this is typically done by making sure all the constructors are private, and also creating a method that returns a reference to the instance.

14. What are composition and aggregation. State the difference.
- Composition is simply having an object inside of a class. It is a has-a relationship.

15. What is a static block.
- It is something that gets executed at the time of class loading. so it get's executed before the main method runs. So if you want any type of logic that needs to be executed before the main method runs, you would put it in a static block.

16. Why is the `remove()` method faster in a linked list than in an arraylist.
- When you remove something in an arraylist, it has to restructure the positions of the remaining elements to accomodate the deletion. While with a linkedlist you just set the pointer to another node. simple

17. What is a `Comparator` and `Comparable` in Java?
- The similar in the sense that they specify how to sort particular collections of data.
- A `Comparator` is an interface you would implement in your class, and you override the `compareTo` method

18. What is the difference between an abstract class and an interface?
An abstract class can have both abstract and non-abstract methods and can be extended by other classes, while an interface only contains abstract method declarations and can be implemented by classes.

19. What is a thread in Java?
A thread in Java is a lightweight unit of execution within a program. It allows concurrent execution of multiple tasks or activities, enabling better utilization of system resources.

20. How do you create and start a thread in Java?
To create and start a thread in Java, you can either extend the "Thread" class and override the "run()" method, or implement the "Runnable" interface and pass it to a new "Thread" object. Then call the "start()" method on the thread object to begin execution.

21. What is synchronization in Java?
Synchronization in Java is a technique used to control the access and execution of multiple threads to ensure that only one thread can access a shared resource or code block at a time.

22. What is an exception in Java?
An exception in Java is an event that occurs during the execution of a program, which disrupts the normal flow of instructions. It represents an error condition or an exceptional circumstance.

23. What is the difference between checked and unchecked exceptions?
Checked exceptions are checked at compile-time, and the programmer is required to handle or declare them using the "throws" keyword. Unchecked exceptions, on the other hand, are not checked at compile-time, and the programmer is not obligated to handle or declare them.

24. How do you handle exceptions in Java?
Exceptions in Java can be handled using try-catch blocks. The code that may throw an exception is placed inside the try block, and if an exception occurs, it is caught and handled in the catch block.

25. What is the purpose of the "finally" block in exception handling?
The "finally" block in Java is used to define a block of code that will be executed regardless of whether an exception occurs or not. It is often used to release resources or perform cleanup operations.

26. What is the difference between the "throw" and "throws" keywords in Java?
The "throw" keyword in Java is used to manually throw an exception, while the "throws" keyword is used in method declarations to specify that the method may throw certain types of exceptions.

27. What is the difference between an ArrayList and a LinkedList?
An ArrayList is implemented as a resizable array, allowing fast random access but slower insertion and removal of elements. A LinkedList is implemented as a doubly-linked list, allowing fast insertion and removal but slower random access.

28. What is the difference between the "equals()" method and the "hashCode()" method?
The "equals()" method is used to compare the equality of objects based on their values, while the "hashCode()" method is used to calculate a unique hash code value for an object, typically used for efficient retrieval in hash-based data structures like HashMaps.

29. What is a lambda expression in Java?
A lambda expression in Java is an anonymous function that can be used to simplify the syntax of functional interfaces. It allows for more concise and readable code, especially when working with functional programming constructs.

30. What are the Java 8 features for functional programming?
Java 8 introduced several features to support functional programming, including lambda expressions, functional interfaces, the Stream API for working with collections, and default methods in interfaces.

31. What is the difference between an interface and an abstract class?
An interface in Java can only declare method signatures and constants but cannot provide implementations, while an abstract class can have both method declarations and concrete implementations. A class can implement multiple interfaces but can inherit from only one abstract class.

32. What is the difference between a BufferedReader and a Scanner?
A BufferedReader in Java reads text from a character stream with efficient buffering, while a Scanner can parse different types of data from various sources such as files, strings, or standard input.

33. What is the purpose of the "StringBuilder" class in Java?
The "StringBuilder" class in Java is used to create and manipulate mutable sequences of characters. It is more efficient than concatenating strings using the "+" operator, as it avoids unnecessary object creations.

34. What is the difference between the "Comparable" and "Comparator" interfaces?
The "Comparable" interface is used to define a natural ordering for a class by implementing the "compareTo()" method. The "Comparator" interface, on the other hand, provides a way to define custom ordering by implementing the "compare()" method and is independent of the class being compared.

35. What is the purpose of the "transient" keyword in Java?
The "transient" keyword in Java is used to indicate that a variable should not be serialized during object serialization. When an object is deserialized, transient variables are set to their default values.

36. What is the purpose of the "enum" keyword in Java?
The "enum" keyword in Java is used to define an enumeration, which is a special type that represents a fixed set of constants. It allows for more structured and type-safe representation of predefined values.

37. What is the purpose of the "try-with-resources" statement in Java?
The "try-with-resources" statement in Java is used to automatically close resources that implement the "AutoCloseable" interface. It ensures that resources, such as file streams or database connections, are properly closed, even if an exception occurs.

38. What is the difference between the pre-increment and post-increment operators?
The pre-increment operator (++i) in Java increments the value of a variable and returns the incremented value, while the post-increment operator (i++) increments the value of a variable but returns the original value before the increment.

39. What is the purpose of the "StringBuffer" class in Java?
The "StringBuffer" class in Java is used to create and manipulate mutable sequences of characters, similar to the "StringBuilder" class. However, "StringBuffer" is synchronized and thread-safe, making it suitable for multi-threaded environments.

40. What is the purpose of the "NullPointerException" in Java?
The "NullPointerException" in Java is an exception that is thrown when a null reference is accessed and used where an object reference is expected. It indicates a programming error and should be handled or prevented to avoid unexpected crashes.

41. What is the purpose of the "ArrayIndexOutOfBoundsException" in Java?
The "ArrayIndexOutOfBoundsException" in Java is an exception that is thrown when an invalid index is used to access an array. It indicates that the index is either negative or exceeds the array's bounds.

42. What is the purpose of the "StringBuilder" class in Java?
The "StringBuilder" class in Java is used to create and manipulate mutable sequences of characters. It provides methods for appending, inserting, deleting, and modifying character sequences efficiently.

43. What is the purpose of the "HashSet" class in Java?
The "HashSet" class in Java is an implementation of the Set interface that stores unique elements in no particular order. It provides constant-time performance for basic operations like adding, removing, and checking for the presence of elements

44. What is the purpose of the "HashMap" class in Java?
The "HashMap" class in Java is an implementation of the Map interface that stores key-value pairs. It provides fast retrieval and insertion of elements based on their keys and allows for efficient mapping and lookup operations.

45. What is the purpose of the "LinkedList" class in Java?
The "LinkedList" class in Java is an implementation of the List interface that uses a doubly-linked list to store elements. It provides efficient insertion and removal of elements at both ends of the list but slower random access.

46. What is the purpose of the "Comparator" interface in Java?
The "Comparator" interface in Java is used to define custom ordering of objects. It provides a way to compare objects based on specific criteria other than their natural ordering defined by the "Comparable" interface.

47. What is the purpose of the "Comparable" interface in Java?
The "Comparable" interface in Java is used to define the natural ordering of objects of a class. It provides a method, "compareTo()", that allows objects to be compared and sorted based on their natural order.

48. What is the purpose of the "throw" keyword in Java?
The "throw" keyword in Java is used to manually throw an exception. It is typically used when a program encounters an error or exceptional situation that cannot be handled, and the control should be transferred to an exception handler.