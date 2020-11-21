package Old.Practic_11_old.Num_1;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel extends JPanel {
    private JButton button = new JButton("Проверить");
    private JLabel label = new JLabel("Угадайте число от 0 до 20",SwingConstants.CENTER);
    private JTextField input = new JTextField("");
    private final int constant = (int)(Math.random() * 100) % 21;
    private int counter = 0;

    public AppPanel() {
        setLayout(null);
        label.setBounds(0,0,250,50);
        input.setBounds(75,50,100,30);
        button.setBounds(75,100,100,25);
        button.addActionListener(new ButtonEvent());
        add(label);
        add(input);
        add(button);
    }

    class ButtonEvent implements ActionListener {
        public void actionPerformed(ActionEvent ev){
            counter++;
            if (counter <= 3 && constant == Integer.valueOf(input.getText())){
                JOptionPane.showMessageDialog(null, "Поздравляю!!!\nВы угадали число!\nЧисло: " + constant + "\nВы выиграли!", "Окно", JOptionPane.PLAIN_MESSAGE);
                System.exit(1);
            }
            else if (counter >= 3 && constant != Integer.valueOf(input.getText())) {
                JOptionPane.showMessageDialog(null, "Вы не угадaли число.\nЧисло: " + constant + "\nИгра окончена", "Окно", JOptionPane.PLAIN_MESSAGE);
                System.exit(1);
            }
            else{
                if(Integer.valueOf(input.getText())>constant)
                    JOptionPane.showMessageDialog(null, "Введенное число больше загаданного.", "Окно", JOptionPane.PLAIN_MESSAGE);
                else if(Integer.valueOf(input.getText())<constant)
                    JOptionPane.showMessageDialog(null, "Введенное число меньше загаданного.", "Окно", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
