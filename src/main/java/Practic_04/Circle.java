package Practic_04;

public class Circle extends Shape {
    protected double radius = 1;

    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    public Circle(double radius){this.radius = radius;}

    public Circle(){}

    public double getRadius() {return radius;}
    public void setRadius(double radius) {this.radius = radius;}

    @Override
    public double getArea() {
        return 3.1415 * 3.1415 * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.1415 * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}