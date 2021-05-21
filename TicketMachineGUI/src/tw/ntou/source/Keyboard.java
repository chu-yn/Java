package tw.ntou.source;

import javax.swing.*;
import java.awt.*;

public class Keyboard {
    private JFrame frame;
    private JTextField text;
    private String value;

    public Keyboard(String value) {
        this.value = value;
        makeFrame();
    }

    private String makeFrame() {
        frame = new JFrame("KeyBoard");
        frame.setSize(300, 250);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);

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
        makeButton("4", 0, 2);
        makeButton("5", 1, 2);
        makeButton("6", 2, 2);
        makeButton("7", 0, 3);
        makeButton("8", 1, 3);
        makeButton("9", 2, 3);
        makeButton("0", 1, 4);

        JButton exit = new JButton("Cancel");
        GridBagConstraints c5 = new GridBagConstraints();
        exit.addActionListener(e -> {
            value = "";
            System.exit(0);
        });
        c5.fill = GridBagConstraints.HORIZONTAL;
        c5.gridx = 0;
        c5.gridy = 4;
        frame.getContentPane().add(exit, c5);
        frame.setVisible(true);

        JButton ok = new JButton("OK");
        ok.addActionListener(e -> {
            value = text.getText();
            System.exit(0);
        });
        c5.gridx = 2;
        frame.getContentPane().add(ok, c5);
        frame.setVisible(true);
        return value;
    }

    private void makeButton(String title, int x, int y) {
        JButton tmp = new JButton(title);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridx = x;
        c.gridy = y;
        tmp.addActionListener(e -> text.setText(text.getText() + title));
        frame.getContentPane().add(tmp, c);
    }
}
