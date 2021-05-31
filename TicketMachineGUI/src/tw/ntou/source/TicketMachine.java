package tw.ntou.source;

import javax.swing.*;
import java.awt.*;

public class TicketMachine extends JFrame {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private int balance;

    public TicketMachine() {
        balance = 0;
        makeFrame();
    }

    public void makeFrame() {
        frame = new JFrame("TicketMachine");
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        // add menu bar
        menu = new JMenu("Menu");
        quit = new JMenuItem("Quit");
        quit.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Refund balance\n" + balance + " cents");
            System.exit(0);
        });
        menu.add(quit);
        menu.setPopupMenuVisible(true);
        menuBar = new JMenuBar();
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // add balance remain label
        JLabel label = new JLabel("Balance: " + balance);

        // add buy button
        JButton buy = new JButton("Buy");
        buy.setBorder(BorderFactory.createEtchedBorder());
        buy.addActionListener(e -> {
            BuyButton buyButton = new BuyButton(frame, balance);
            balance = buyButton.process();
            label.setText("Balance: " + balance);
        });
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.anchor = GridBagConstraints.CENTER;
        buildConstraints(c1, 0, 0, 1, 1, 10, 0);

        // add exit button
        JButton exit = new JButton("Exit");
        exit.setBorder(BorderFactory.createEtchedBorder());
        exit.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Refund balance\n" + balance + " cents");
            System.exit(0);
        });
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.anchor = GridBagConstraints.CENTER;
        buildConstraints(c2, 1, 0, 1, 1, 10, 0);

        // text panel
        JPanel textList = new JPanel();
        textList.setLayout(new FlowLayout());
        GridBagConstraints c3 = new GridBagConstraints();
        c3.fill = GridBagConstraints.HORIZONTAL;
        c3.anchor = GridBagConstraints.CENTER;
        buildConstraints(c3, 2, 0, 1, 1, 30, 30);
        textList.add(label);
        frame.getContentPane().add(textList, c3);

        // button panel
        JPanel buttonList = new JPanel();
        buttonList.setLayout(new GridBagLayout());
        GridBagConstraints c4 = new GridBagConstraints();
        c4.fill = GridBagConstraints.HORIZONTAL;
        c4.anchor = GridBagConstraints.CENTER;
        buildConstraints(c4, 2, 1, 1, 1, 10, 10);
        buttonList.add(buy, c1);
        buttonList.add(exit, c2);
        frame.getContentPane().add(buttonList, c4);

        frame.setVisible(true);
    }

    public static void buildConstraints(GridBagConstraints con, int gx, int gy, int gw, int gh, int wx, int wy) {
        con.gridx = gx;
        con.gridy = gy;
        con.gridwidth = gw;
        con.gridheight = gh;
        con.weightx = wx;
        con.weighty = wy;
    }
}
