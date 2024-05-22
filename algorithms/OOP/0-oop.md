Classes are a way to create new kinds of objects and they are central to object-oriented
programming. A class defines a set of attributes that are shared across instances of that
class. Typically, classes are sets of functions, variables, and properties.
The object-oriented paradigm is compelling because it gives us a concrete way to think
about and represent the core functionality of our programs. By organizing our programs
around objects and data rather than actions and logic, we have a robust and flexible way to
build complex applications. The actions and logic are still present of course, but by
embodying them in objects, we have a way to encapsulate functionality, allowing objects to
change in very specific ways. This makes our code less error-prone, easier to extend and
maintain, and able to model real-world objects.

Classes are created in Python using the class statement. This defines a set of shared
attributes associated with a collection of class instances. A class usually consists of a
number of methods, class variables, and computed properties. It is important to understand
that defining a class does not, by itself, create any instances of that class. To create an
instance, a variable must be assigned to a class. The class body consists of a series of
statements that execute during the class definition. The functions defined inside a class are
called instance methods. They apply some operations to the class instance by passing an
instance of that class as the first argument. This argument is called self by convention, but
it can be any legal identifier. Here is a simple example:

```python
class Employee(object):
    numEmployee = 0
    def __init__(self, name, rate):
        self.owed = 0
        self.name = name
        self.rate=rate
        Employee.numEmployee += 1

 def __del__(self):
    Employee.numEmployee -= 1

 def hours(self, numHours):
    self.owed += numHours * self.rate
    return("%.2f hours worked" % numHours)

 def pay(self):
    self.owed = 0
    return("payed %s " % self.name)
```