package problems.w3resources.abstract_classes;


abstract class Shape{
    abstract double calculateArea();
    abstract double calculatePerimeter();
}

class Circle extends Shape{
    double radius;

    Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double calculateArea(){
        return Math.PI * (radius * radius);
    }

    @Override
    public double calculatePerimeter(){
        return 2 * (Math.PI * radius);
    }
}

class Triangle extends Shape{
    double lengthA;
    double lengthB;
    double lengthC;

    Triangle(double lengthA, double lengthB, double lengthC){
        this.lengthA = lengthA;
        this.lengthB = lengthB;
        this.lengthC = lengthC;
    }

    @Override
    public double calculateArea(){
        double s = (lengthA + lengthB + lengthC) / 2;
        return Math.sqrt(s * (s - lengthA) * (s - lengthB) * s - lengthC);
    }

    @Override
    public double calculatePerimeter(){

        return lengthA + lengthB + lengthC;
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        double radius = 5.6;
        Shape circle = new Circle(radius);
        circle.calculateArea();
        circle.calculatePerimeter();

        Shape triangle = new Triangle(5, 6, 8);
        triangle.calculateArea();
        triangle.calculatePerimeter();
    }
}