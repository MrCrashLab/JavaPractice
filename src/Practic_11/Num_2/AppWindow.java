package Practic_11.Num_2;

import javax.swing.*;

public class AppWindow extends JFrame {

    public AppWindow(){
        createWindow();
        add(new AppPanel());
    }

    public void createWindow(){
        setTitle("Округ");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(400, 300);
        setResizable(false);
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args){new AppWindow();}
}