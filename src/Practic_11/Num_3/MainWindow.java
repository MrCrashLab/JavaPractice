package Practic_11.Num_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenu editMenu = new JMenu("Edit");
    private JMenu colorMenu = new JMenu("Color");
    private JMenu fontMenu = new JMenu("Font");
    private JMenuItem redColorItem = new JMenuItem("Red");
    private JMenuItem blueColorItem = new JMenuItem("Blue");
    private JMenuItem blackColorItem = new JMenuItem("Black");
    private JMenuItem timesNewRomanFontItem = new JMenuItem("Times New Roman");
    private JMenuItem msSansSerifFontItem = new JMenuItem("MS Sans Serif");
    private JMenuItem courierNewFontItem = new JMenuItem("Courier New");
    private JMenuItem exitItem = new JMenuItem("Exit");
    private AppPanel panel = new AppPanel();

    public MainWindow() {
        createWindow();
        createMenu();
        addListen();
        add(panel);
        setVisible(true);
    }

    public void createWindow(){
        setTitle("Изменение текста");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(400, 300);
        setResizable(false);
        setSize(450, 500);
    }

    public void addListen(){
        redColorItem.addActionListener(new ColorEvent(1));
        blueColorItem.addActionListener(new ColorEvent(2));
        blackColorItem.addActionListener(new ColorEvent(3));

        timesNewRomanFontItem.addActionListener(new FontEvent(1));
        msSansSerifFontItem.addActionListener(new FontEvent(2));
        courierNewFontItem.addActionListener(new FontEvent(3));

        exitItem.addActionListener(new ExitEvent());
    }

    public void createMenu(){
        colorMenu.add(blueColorItem);
        colorMenu.add(redColorItem);
        colorMenu.add(blackColorItem);
        editMenu.add(colorMenu);

        fontMenu.add(timesNewRomanFontItem);
        fontMenu.add(msSansSerifFontItem);
        fontMenu.add(courierNewFontItem);
        editMenu.add(fontMenu);

        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        setJMenuBar(menuBar);
    }

    class ColorEvent implements ActionListener{
        int count;
        public ColorEvent(int count) {this.count = count;}
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (count){
                case 1:
                    panel.changeColor(Color.red);
                    break;
                case 2:
                    panel.changeColor(Color.blue);
                    break;
                case 3:
                    panel.changeColor(Color.black);
                    break;
                default:
                    break;
            }
        }
    }

    class FontEvent implements ActionListener{
        int count;
        public FontEvent(int count) {this.count = count;}

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (count){
                case 1:
                    panel.changeFont(new Font("Times New Roman", Font.BOLD, 20));
                    break;
                case 2:
                    panel.changeFont(new Font("MS Sans Serif", Font.BOLD, 20));
                    break;
                case 3:
                    panel.changeFont(new Font("Courier New", Font.BOLD, 20));
                    break;
                default:
                    break;
            }
        }
    }

    class ExitEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(1);
        }
    }

    public static void main(String[] args){
        new MainWindow();
    }
}
