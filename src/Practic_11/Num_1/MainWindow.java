package Practic_11.Num_1;
import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow(){
        createWindow();
        add(new AppPanel());
    }

    public void createWindow(){
        setTitle("Угадайка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(500, 500);
        setResizable(false);
        setSize(250, 200);
        setVisible(true);
    }

    public static void main(String[] args){new MainWindow();}

}
