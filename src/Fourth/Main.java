package Fourth;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(5, "white", true);
        Square square = new Square(2,"blue",false);
        Rectangle rectangle = new Rectangle(2, 5, "red", true);
        System.out.println(circle.toString());
        System.out.println(rectangle.toString());
        System.out.println(square.toString());
    }
}