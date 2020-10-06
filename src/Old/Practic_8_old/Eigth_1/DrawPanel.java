package Old.Practic_8_old.Eigth_1;

import javax.swing.*;
import java.awt.*;
import static java.lang.Math.abs;

public class DrawPanel extends JPanel {
    private int allFigure = 20;
    public Circle[] circles = new Circle[abs((int) (Math.random() * 10)) + 1];
    private Square[] squares = new Square[(allFigure - circles.length) / 2];
    private Oval[] ovals = new Oval[allFigure - circles.length - squares.length];

    public DrawPanel() {
        for (int i = 0; i < squares.length; i++)
            squares[i] = new Square();
        for (int i = 0; i < ovals.length; i++)
            ovals[i] = new Oval();
        for (int i = 0; i < circles.length; i++)
            circles[i] = new Circle();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < squares.length; i++)
            squares[i].paintComponent(g2);
        for (int i = 0; i < ovals.length; i++)
            ovals[i].paintComponent(g2);
        for (int i = 0; i < circles.length; i++)
            circles[i].paintComponent(g2);
    }
}