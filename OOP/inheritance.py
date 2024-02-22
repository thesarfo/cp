class Animal:  # base class
    def __init__(self, n):
        self.name = n

    def speak(self):
        print("I am Animal")

    def getName(self):
        return str(self.name)

    def __str__(self):
        return self.__str__()


class Mammal(Animal):  # subclass
    def __init__(self, c, n):
        super().__init__(n)  # this is how we call a constructor of a super class
        self.color = c  # color becomes an instance of Mammals

    def getColor(self):
        return self.color

    def __str__(self):  # return string of all new class state including super class
        s = 'name: ' + self.getName()


c1 = Animal('Mr. Sloth')
c2 = Mammal('Red', 'Mr. Fox')
print("c1: ", str(c1))
print("c2: ", c2)


class Reptile(Animal):
    def __init__(self):
        super().__init__(n)  # this is how you call constructor of super class
        self.scales = s  # number of scales

    def getScales(self):
        return self.scales

    def __str__(self):
        return super().__str__() + " scales: " + str(self.scales)

    def slither(self):
        print("sssisisisisisisisssiisss")


class Dog(Mammal):
    def __init__(self, c, f, n):
        Mammal.__init__(self, c, n)  # this is how you call constructor of super class
        self.food = f  # kind of food

    def speak(self):
        print("Bark Bark")  # redefine (override) speak

    def getFood(self):
        return self.food

    def __str__(self):
        return Mammal.__str__(self) + " food: " + self.food
