package source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JFrame frame;
    private JTextField text;

    public Calculator() {
        makeFrame();
    }

    private void makeFrame() {
        frame = new JFrame("Calculator");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        text = new JTextField();
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.gridwidth = 4;
        c1.gridheight = 1;
        c1.weightx = 0;
        c1.weighty = 0;
        c1.fill = GridBagConstraints.BOTH;
        c1.anchor = GridBagConstraints.WEST;
        frame.add(text, c1);

        makeButton("1", 0, 1);
        makeButton("2", 1, 1);
        makeButton("3", 2, 1);
        makeButton("*", 3, 1);
        makeButton("4", 0, 2);
        makeButton("5", 1, 2);
        makeButton("6", 2, 2);
        makeButton("/", 3, 2);
        makeButton("7", 0, 3);
        makeButton("8", 1, 3);
        makeButton("9", 2, 3);
        makeButton("+", 3, 3);
        makeButton("-", 3, 4);
        makeButton("0", 1, 4);
        makeButton("=", 2, 4);

        JButton exit = new JButton("Exit");
        GridBagConstraints c5 = new GridBagConstraints();
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        c5.fill = GridBagConstraints.HORIZONTAL;
        c5.gridx = 0;
        c5.gridy = 4;
        frame.getContentPane().add(exit, c5);
        frame.setVisible(true);
    }

    private void makeButton(String title, int x, int y) {
        JButton tmp = new JButton(title);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridx = x;
        c.gridy = y;
        tmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText() + title);
            }
        });
        frame.getContentPane().add(tmp, c);
    }
}
