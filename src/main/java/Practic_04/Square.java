package Practic_04;

public class Square extends Shape{
    private double widlen = -1;
    public Square(double widlen, String color, boolean filled){
        super(color, filled);
        this.widlen = widlen;
    }
    public Square(){}

    public double getWidlen() {return widlen;}

    public void setWidlen(double widlen) {this.widlen = widlen;}

    @Override
    public double getArea() {return widlen * widlen;}
    @Override
    public double getPerimeter() {return widlen * 4;}

    @Override
    public String toString() {
        return "Square{" +
                "widlen=" + widlen +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}