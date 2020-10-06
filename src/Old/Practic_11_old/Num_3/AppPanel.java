package Old.Practic_11_old.Num_3;

import javax.swing.*;
import java.awt.*;

public class AppPanel extends JPanel {
    private JTextArea textArea = new JTextArea("");

    public AppPanel() {
        setLayout(new BorderLayout());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
    }

    public void changeColor(Color color){textArea.setForeground(color);}
    public void changeFont(Font font){textArea.setFont(font);}
}
