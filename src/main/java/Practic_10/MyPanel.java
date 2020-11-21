package Practic_10;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;


public class MyPanel extends JPanel {
    private final JTextField textFieldA = new JTextField("");
    private final JTextField textFieldB = new JTextField("");
    private final JLabel titleLabel = new JLabel("Калькулятор", SwingConstants.CENTER);
    private final JLabel label = new JLabel("", SwingConstants.CENTER);
    private final JButton buttonP = new JButton("+");
    private final JButton buttonM = new JButton("-");
    private final JButton buttonS = new JButton("*");
    private final JButton buttonD = new JButton("/");
    private Container container = new Container();
    private DecimalFormat decimalFormat = new DecimalFormat("#.####");

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
        if (!textField.getText().equals("") && textField.getText().matches("[0-9.]+"))
            return true;
        else return false;
    }
}


