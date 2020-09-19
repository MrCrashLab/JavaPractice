package Practic_11.Num_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class AppPanel extends JPanel {
    private JLabel cLabel = new JLabel("Center",SwingConstants.CENTER);
    private JLabel wLabel = new JLabel("West",SwingConstants.CENTER);
    private JLabel sLabel = new JLabel("South",SwingConstants.CENTER);
    private JLabel nLabel = new JLabel("North",SwingConstants.CENTER);
    private JLabel eLabel = new JLabel("East",SwingConstants.CENTER);
    private BorderLayout bl = new BorderLayout();
    public AppPanel() {
        setLayout(bl);
        drawCadre();
        add(nLabel, BorderLayout.NORTH);
        add(sLabel, BorderLayout.SOUTH);
        add(wLabel, BorderLayout.WEST);
        add(eLabel, BorderLayout.EAST);
        add(cLabel, BorderLayout.CENTER);

        nLabel.addMouseListener(new MouseEvent(1));
        sLabel.addMouseListener(new MouseEvent(2));
        wLabel.addMouseListener(new MouseEvent(3));
        eLabel.addMouseListener(new MouseEvent(4));
        cLabel.addMouseListener(new MouseEvent(5));
    }

    public void drawCadre(){
        nLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
        sLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        wLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
        eLabel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));
        cLabel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 5));
    }

    class MouseEvent implements MouseListener{
        int county;
        public MouseEvent(int county) {
            this.county = county;
        }

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {}
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseReleased(java.awt.event.MouseEvent e){}

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            switch (county) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Добро пожаловать в САО", "Окно", JOptionPane.PLAIN_MESSAGE);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Добро пожаловать в ЮАО", "Окно", JOptionPane.PLAIN_MESSAGE);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Добро пожаловать в ЗАО", "Окно", JOptionPane.PLAIN_MESSAGE);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Добро пожаловать в ВАО", "Окно", JOptionPane.PLAIN_MESSAGE);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Добро пожаловать в ЦАО", "Окно", JOptionPane.PLAIN_MESSAGE);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {}
    }



}
