package Old.Practic_9_old;

import javax.swing.*;

public class WindowApp extends JFrame {
    public WindowApp() {
        setTitle("Фигуры");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(300, 200);
        setResizable(false);
        setSize(500, 500);
        setVisible(true);
        add(new DrawPanel());
    }

    public static void main(String[] args){new WindowApp();}
}
