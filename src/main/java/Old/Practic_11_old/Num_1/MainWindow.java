package Old.Practic_11_old.Num_1;
import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow(){
        createWindow();
        add(new AppPanel());
        setVisible(true);
    }

    public void createWindow(){
        setTitle("Угадайка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(500, 500);
        setResizable(false);
        setSize(250, 200);
    }

    public static void main(String[] args){new MainWindow();}

}
