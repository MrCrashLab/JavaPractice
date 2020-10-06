package Old.Practic_9_old;

import java.awt.*;

import static java.lang.Math.abs;

public class Circle extends Shape {
    private int radius = 0;

    public Circle(){
        super();
        radius =  abs((int)(Math.random() * 100000)) % 125 + 10;
    }

    public int getRadius() {return radius;}

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getRadius(), getRadius());
    }
}