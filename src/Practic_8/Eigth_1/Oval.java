package Practic_8.Eigth_1;

import java.awt.*;
import static java.lang.Math.abs;

public class Oval extends Shape {
    private int weight = 0;
    private int heigth = 0;

    public Oval(){
        super();
        weight = abs((int)(Math.random() * 100000)) % 125 + 10;
        heigth = abs((int)(Math.random() * 100000)) % 125 + 10;
    }
    public int getHeigth() {return heigth;}
    public int getWeight() {return weight;}

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getColor());
        g.drawOval(getX(), getY(), getHeigth(), getWeight());
    }
}
