package Old.Practic_8_old.Eigth_3;

import javax.swing.*;

public class MainWindow extends JFrame{
    public MainWindow(){
        setTitle("Анимация");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocation(200, 200);
        setResizable(false);
        add(new AppField());
        setVisible(true);
    }

    public static void main(String[] args){
        new MainWindow();
    }
}


