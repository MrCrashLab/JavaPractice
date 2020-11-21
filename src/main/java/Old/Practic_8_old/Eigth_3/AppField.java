package Old.Practic_8_old.Eigth_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppField extends JPanel implements ActionListener {
    Image[] images = new Image[5];
    ImageIcon[] imageIcons = new ImageIcon[5];
    private Timer timer;
    private int counter = 0;

    public AppField(){
        loadImages();
        timer = new Timer(250, this);
        timer.start();
        setFocusable(true);
    }

    private void loadImages(){
        for(int i = 0;i<imageIcons.length;i++){
            System.out.println("src//"+Integer.toString(i)+".JPG");
            imageIcons[i] = new ImageIcon("src//Practic_8//Eigth_3//"+Integer.toString(i)+".JPG");
            images[i] = imageIcons[i].getImage();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(images[counter %5], 0, 0,500,500, this);
        counter++;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}