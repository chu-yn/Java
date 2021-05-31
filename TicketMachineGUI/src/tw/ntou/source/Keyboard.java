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
        setTitle("Keyboard");
        setSize(250, 200);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setModalityType(DEFAULT_MODALITY_TYPE);
        text = new JTextField();
        GridBagConstraints c1 = new GridBagConstraints();
        buildConstraints(c1, 0, 0, 4, 1, 0, 0);
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
        exit.setBorder(BorderFactory.createEtchedBorder());
        GridBagConstraints c5 = new GridBagConstraints();
        exit.addActionListener(e -> dispose());
        c5.fill = GridBagConstraints.HORIZONTAL;
        buildConstraints(c5, 0, 4, 1, 1, 0, 0);
        getContentPane().add(exit, c5);

        JButton ok = new JButton("OK");
        ok.setBorder(BorderFactory.createEtchedBorder());
        ok.addActionListener(e -> {
            value = text.getText();
            dispose();
        });
        c5.gridx = 2;
        getContentPane().add(ok, c5);
        setVisible(true);
    }

    public void makeButton(String number, int x, int y) {
        JButton tmp = new JButton(number);
        tmp.setBorder(BorderFactory.createEtchedBorder());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        buildConstraints(c, x, y, 1, 1, 10, 0);
        tmp.addActionListener(e -> text.setText(text.getText() + number));
        getContentPane().add(tmp, c);
    }

    public static void buildConstraints(GridBagConstraints con, int gx, int gy, int gw, int gh, int wx, int wy) {
        con.gridx = gx;
        con.gridy = gy;
        con.gridwidth = gw;
        con.gridheight = gh;
        con.weightx = wx;
        con.weighty = wy;
    }

    public String getValue() {
        return value;
    }
}
