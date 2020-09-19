package Practic_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.abs;

public class DrawPanel extends JPanel{
    private int allFigure = 20;
    public Circle[] circles;
    private Square[] squares;
    private Oval[] ovals;
    private JButton button = new JButton("Нажми на меня");

    public DrawPanel() {
        setLayout(null);
        createFigure();
        button.addActionListener(new ButtonEvent());
        button.setBounds(150,410,200,35);
        add(button);
    }

    public void createFigure(){
        circles = new Circle[abs((int) (Math.random() * 10)) + 1];
        squares = new Square[(allFigure - circles.length) / 2];
        ovals = new Oval[allFigure - circles.length - squares.length];
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

    class ButtonEvent implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            createFigure();
            repaint();
        }
    }
}