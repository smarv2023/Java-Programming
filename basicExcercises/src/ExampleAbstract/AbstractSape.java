package ExampleAbstract;

public class AbstractSape {

	public static void main(String[] args) {
		 Shape rectangle = new Rectangle(5, 4);
	        Shape circle = new Circle(3);

	        // Calling methods
	        rectangle.display();
	        System.out.println("Area of rectangle: " + rectangle.area());
	        System.out.println("Perimeter of rectangle: " + rectangle.perimeter());

	        circle.display();
	        System.out.println("Area of circle: " + circle.area());
	        System.out.println("Perimeter of circle: " + circle.perimeter());
	}
}

//Concrete subclass
class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementing abstract methods
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

//Concrete subclass
class Rectangle extends Shape {
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Implementing abstract methods
    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }
}

//Abstract class
abstract class Shape {
 // Abstract methods
 public abstract double area();
 public abstract double perimeter();

 // Concrete method
 public void display() {
     System.out.println("This is a shape.");
 }
}
