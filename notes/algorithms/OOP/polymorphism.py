class Animal:
    def __init__(self, name):
        self.name = name

    def speak(self):
        return " ?"

    def __str__(self):
        return "%s: %s" % (self.name, self.speak())

    def getName(self):
        return self.name


class Cow(Animal):
    def __init__(self, name):
        super().__init__(name)

    def chew(self):
        print("Munch Munch")

    def speak(self):
        return "MOOO"


class Pig(Animal):
    def __init__(self, name):
        super().__init__(name)

    def speak(self):
        return "ooink oink"


class Cat(Animal):
    def __init__(self, name):
        super().__init__(name)

    def speak(self):
        return "MEOW"

    def purr(self):
        print("Purrrr")

animals = [Cat("Pus"), Animal("---"), Cat("Spot"), Pig("Babe"), Cow("Bessy"), Cow("Bow")]

for a in animals:
    if isinstance(a, Cat):
        print(a.getName(), end=" ")
        a.purr()
    else:
        print(a.getName() + " cant purr")