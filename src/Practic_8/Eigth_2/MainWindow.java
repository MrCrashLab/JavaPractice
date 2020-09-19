package Practic_8.Eigth_2;

import javax.swing.*;
import java.io.IOException;

public class MainWindow extends JFrame {

    public MainWindow(String[] args) throws IOException {
        setTitle("Загрузка изображения.");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000,500);
        setLocation(400, 400);
        setResizable(false);
        add(new AppField(args));
        setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        new MainWindow(args);
    }
}