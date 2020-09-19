package Practic_9;

import javax.swing.*;
import java.awt.*;

public abstract class Shape extends JComponent{
    protected Color color;
    protected int x = 0;
    protected int y = 0;

    public Shape(){
        x = (int)(Math.random() * 1000000) % 400 + 1;
        y = (int)(Math.random() * 1000000) % 275 + 1;
        color = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
    }

    public Color getColor() {return color;}
    public int getX() {return x;}
    public int getY() {return y;}
}