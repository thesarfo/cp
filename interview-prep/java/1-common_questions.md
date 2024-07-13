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