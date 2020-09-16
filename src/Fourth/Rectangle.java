package Fourth;

public class Rectangle extends Shape {
    protected double width = 1;
    protected double length = 1;

    public Rectangle(double width, double length, String color, boolean filled){
        super(color,filled);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    public Rectangle(){}

    public double getWidth() {return width;}
    public void setWidth(double width) {this.width = width;}

    public double getLength() {return length;}
    public void setLength(double length) {this.length = length;}

    @Override
    public double getPerimeter() {
        return (2 * width) + (2 * length);
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}