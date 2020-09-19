package Practic_9;

import java.awt.*;

import static java.lang.Math.abs;

public class Square extends Shape {
    private int len = 0;

    public Square(){
        super();
        len = abs((int)(Math.random() * 100000)) % 125 + 10;
    }
    public int getLen() {return len;}

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getColor());
        g.drawRect(getX(), getY(), getLen(), getLen());
    }
}