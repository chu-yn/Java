package tw.ntou.source;

import javax.swing.*;
import java.awt.*;

/**
 * class for generate a virtual number keyboard
 */
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

        // make text field
        text = new JTextField();
        GridBagConstraints c1 = new GridBagConstraints();
        c1.insets = new Insets(5, 5, 5, 5);
        buildConstraints(c1, 0, 0, 4, 1);
        c1.fill = GridBagConstraints.BOTH;
        c1.anchor = GridBagConstraints.WEST;
        add(text, c1);

        // make number button
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

        // make cancel button
        JButton exit = new JButton("Cancel");
        exit.setBorder(BorderFactory.createEtchedBorder());
        GridBagConstraints c2 = new GridBagConstraints();
        exit.addActionListener(e -> dispose());
        c2.fill = GridBagConstraints.BOTH;
        c2.insets = new Insets(5, 5, 5, 5);
        buildConstraints(c2, 0, 4, 1, 1);
        getContentPane().add(exit, c2);

        // make ok button
        JButton ok = new JButton("OK");
        ok.setBorder(BorderFactory.createEtchedBorder());
        ok.addActionListener(e -> {
            value = text.getText();
            dispose();
        });
        GridBagConstraints c3 = new GridBagConstraints();
        c3.fill = GridBagConstraints.BOTH;
        c3.insets = new Insets(5, 5, 5, 5);
        buildConstraints(c3, 2, 4, 1, 1);
        getContentPane().add(ok, c3);

        setVisible(true);
    }

    /**
     * method to make number button
     *
     * @param number title
     * @param x      column
     * @param y      row
     */
    public void makeButton(String number, int x, int y) {
        JButton tmp = new JButton(number);
        tmp.setBorder(BorderFactory.createEtchedBorder());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        buildConstraints(c, x, y, 1, 1);
        tmp.addActionListener(e -> text.setText(text.getText() + number));
        getContentPane().add(tmp, c);
    }

    /**
     * to build GridBagConstraints
     *
     * @param con Constraints
     * @param gx  gridx
     * @param gy  gridy
     * @param gw  gridwidth
     * @param wx  weightx
     */
    public static void buildConstraints(GridBagConstraints con, int gx, int gy, int gw, int wx) {
        con.gridx = gx;
        con.gridy = gy;
        con.gridwidth = gw;
        con.weightx = wx;
    }

    /**
     * get input value
     *
     * @return value
     */
    public String getValue() {
        return value;
    }
}
