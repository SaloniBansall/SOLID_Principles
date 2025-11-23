//2. Open/Closed Principle (OCP)
//Definition: Software entities (classes, modules, functions) should be open for extension, but closed for modification.
//Real-World Analogy: A plug adapter allows new plugs without modifying the power socket.

public class openClosePrinciple {
    static void main() {
        Shape circle=new circle(4);
        Shape rectangle=new rectangle(4,5);
        AreaCalculator calc = new AreaCalculator();
        calc.printArea(circle);
        calc.printArea(rectangle);
    }
}
interface Shape{
    double area();
}
class circle implements Shape{
    private double radius;
    public circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI*radius*radius;
    }
}
class rectangle implements Shape{
    private double length,height;
    public rectangle(double length, double height) {
        this.length = length;
        this.height=height;

    }
    @Override
    public double area() {
        return length*height;
    }
}
class AreaCalculator{
    public void printArea(Shape shape){
        double area = shape.area();
        System.out.println("Area of " + shape.getClass().getSimpleName() + " is: " + shape.area());
    }
}
