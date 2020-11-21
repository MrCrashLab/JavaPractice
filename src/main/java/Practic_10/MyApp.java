package Practic_10;

import javax.swing.*;

public class MyApp extends JFrame {
    public MyApp() {
        setTitle("Калькулятор");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(300, 200);
        setResizable(false);
        setSize(400, 500);
        add(new MyPanel());
    }
}
