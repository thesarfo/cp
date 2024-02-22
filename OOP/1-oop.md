### Basic Concepts:

#### Classes and Objects:

**Class:** A blueprint that defines the attributes and behaviors of an object.

**Object:** An instance of a class.

**Example:**

```python
class Car:
    def __init__(self, brand, model):
        self.brand = brand
        self.model = model

    def drive(self):
        return f"Driving {self.brand} {self.model}"
```

#### Creating Objects:

```python
car1 = Car("Toyota", "Corolla")
print(car1.drive())  # Output: Driving Toyota Corolla
```

### Inheritance:

**Inheritance:** A mechanism where a new class (child/subclass) is created by inheriting properties and methods from an existing class (parent/superclass).

**Example:**

```python
class ElectricCar(Car):  # Inherits from Car
    def __init__(self, brand, model, battery_capacity):
        super().__init__(brand, model)
        self.battery_capacity = battery_capacity

    def charge(self):
        return f"Charging {self.brand} {self.model} with {self.battery_capacity} kWh"
```

#### Creating an Electric Car Object:

```python
electric_car = ElectricCar("Tesla", "Model S", 100)
print(electric_car.drive())  # Output: Driving Tesla Model S
print(electric_car.charge())  # Output: Charging Tesla Model S with 100 kWh
```

### Polymorphism:

**Polymorphism:** The ability of different classes to be treated as objects of a common superclass.

**Example:**

```python
# Polymorphic function
def display_info(vehicle):
    return vehicle.drive()

# Using the polymorphic function
print(display_info(car1))  # Output: Driving Toyota Corolla
print(display_info(electric_car))  # Output: Driving Tesla Model S
```

### Encapsulation:

**Encapsulation:** Restricting direct access to certain components of an object, usually by using private variables and methods.

**Example:**

```python
class Person:
    def __init__(self, name, age):
        self._name = name  # Protected attribute
        self.__age = age   # Private attribute

    def display_details(self):
        return f"Name: {self._name}, Age: {self.__age}"

# Accessing protected attribute
person = Person("Alice", 30)
print(person._name)  # Output: Alice

# Accessing private attribute (not recommended, it's intended to be private)
# This will cause an AttributeError
# print(person.__age)
```

### Abstraction:

**Abstraction:** Hiding complex implementation details and showing only the essential features of an object.

In Python, abstraction is achieved through encapsulation and providing interfaces.

**Example:**

```python
from abc import ABC, abstractmethod

class Animal(ABC):  # Abstract class
    @abstractmethod
    def make_sound(self):
        pass

class Dog(Animal):
    def make_sound(self):
        return "Bark!"

class Cat(Animal):
    def make_sound(self):
        return "Meow!"

dog = Dog()
cat = Cat()

print(dog.make_sound())  # Output: Bark!
print(cat.make_sound())  # Output: Meow!
```