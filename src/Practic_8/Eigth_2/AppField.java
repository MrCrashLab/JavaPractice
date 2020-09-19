package Practic_8.Eigth_2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AppField extends JComponent {
    private Image image;
    public AppField(String[] args) throws IOException {
        image = (Image) ImageIO.read(new File(args[0]));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,1000,500,this);
    }
}