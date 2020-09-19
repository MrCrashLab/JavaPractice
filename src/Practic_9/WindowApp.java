package Practic_9;

import javax.swing.*;

public class WindowApp extends JFrame {
    public WindowApp() {
        setTitle("Фигуры");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(300, 200);
        JLayeredPane lp = getLayeredPane();
        setResizable(false);
        setSize(500, 500);
        setVisible(true);
        add(new DrawPanel());
    }

    public static void main(String[] args){new WindowApp();}
}
