package Old.Practic_11_old.Num_2;

import javax.swing.*;

public class AppWindow extends JFrame {

    public AppWindow(){
        createWindow();
        add(new AppPanel());
        setVisible(true);
    }

    public void createWindow(){
        setTitle("Округ");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(400, 300);
        setResizable(false);
        setSize(500, 500);
    }

    public static void main(String[] args){new AppWindow();}
}
