package problems.w3resources.abstract_classes;

abstract class Animal{
    abstract public void sound();
}

class Lion extends Animal{
    @Override
    public void sound(){
        System.out.println("Roar: I am a lion");
    }
}

class Tiger extends Animal{
    @Override
    public void sound(){
        System.out.println("Roar: I am a tiger");
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        Animal lion = new Lion();
        lion.sound();

        Animal tiger = new Tiger();
        tiger.sound();
    }
}
