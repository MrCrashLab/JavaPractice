package Practic_10;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

import static javax.swing.GroupLayout.Alignment.LEADING;

public class MyPanel extends JPanel {
    private JTextField textFieldA = new JTextField("");
    private JTextField textFieldB = new JTextField("");
    private JLabel titleLabel = new JLabel("Калькулятор", SwingConstants.CENTER);
    private JLabel label = new JLabel("", SwingConstants.CENTER);
    private JButton buttonP = new JButton("+");
    private JButton buttonM = new JButton("-");
    private JButton buttonS = new JButton("*");
    private JButton buttonD = new JButton("/");
    private ButtonGroup buttonGroup = new ButtonGroup();
    Container container = new Container();
    DecimalFormat decimalFormat = new DecimalFormat("#.###");

    public MyPanel() {
        addComponent();
        addListener();
    }

    private void addComponent() {
        setLayout(new GridLayout(5, 1, 30, 30));
        container.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        container.add(buttonP);
        container.add(buttonM);
        container.add(buttonS);
        container.add(buttonD);
        titleLabel.setForeground(Color.green);
        add(titleLabel);
        add(textFieldA);
        add(container);
        add(textFieldB);
        add(label);
    }

    private void addListener() {
        buttonP.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB)) {

                label.setText(decimalFormat.format(
                                Float.parseFloat(
                                        textFieldA.getText()) +
                                        Float.parseFloat(textFieldB.getText())));
            }else
                label.setText("Введите числа");
        });

        buttonM.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB)) {
                label.setText(decimalFormat.format(
                                Float.parseFloat(
                                        textFieldA.getText()) -
                                        Float.parseFloat(textFieldB.getText())));
            }else
                label.setText("Введите числа");
        });

        buttonS.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB)) {
                label.setText(decimalFormat.format(
                                Float.parseFloat(
                                        textFieldA.getText()) *
                                        Float.parseFloat(textFieldB.getText())));
            }else
                label.setText("Введите числа");
        });

        buttonD.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB) && Float.parseFloat(textFieldB.getText()) != 0) {
                label.setText(decimalFormat.format(
                                Float.parseFloat(
                                        textFieldA.getText()) /
                                        Float.parseFloat(
                                                textFieldB.getText())));
            }else
                label.setText("Введите числа");
        });
    }

    private boolean checkField(JTextField textField) {
        if (!textField.getText().equals("") && textField.getText().matches("[0-9]+"))
            return true;
        else return false;
    }
}


