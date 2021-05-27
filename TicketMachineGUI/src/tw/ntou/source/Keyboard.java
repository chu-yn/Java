package tw.ntou.source;

import javax.swing.*;
import java.awt.*;

public class Keyboard extends JDialog {
    private JTextField text;
    private String value;


    public Keyboard() {
        makeFrame();
    }

    public void makeFrame() {
        setSize(300, 250);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setModalityType(DEFAULT_MODALITY_TYPE);
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
        add(text, c1);

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
        exit.addActionListener(e -> dispose());
        c5.fill = GridBagConstraints.HORIZONTAL;
        c5.gridx = 0;
        c5.gridy = 4;
        getContentPane().add(exit, c5);

        JButton ok = new JButton("OK");
        ok.addActionListener(e -> {
            value = text.getText();
            setVisible(false);
        });
        c5.gridx = 2;
        getContentPane().add(ok, c5);
        setVisible(true);
    }

    public void makeButton(String number, int x, int y) {
        JButton tmp = new JButton(number);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridx = x;
        c.gridy = y;
        tmp.addActionListener(e -> text.setText(text.getText() + number));
        getContentPane().add(tmp, c);
    }

    public String getValue() {
        return value;
    }
}
