package tw.ntou.source;

import javax.swing.*;
import java.awt.*;

public class TicketMachine extends JFrame{
    private JFrame frame;
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
        // add balance remain label
        JLabel label = new JLabel("Balance: " + balance);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        frame.getContentPane().add(label, c);
        frame.setVisible(true);
        // add buy button
        JButton buy = new JButton("Buy");
        buy.addActionListener(e -> {
            BuyButton buyButton = new BuyButton(frame, balance);
            balance = buyButton.process();
            label.setText("Balance: " + balance);
        });
        c.gridx = 0;
        c.gridy = 1;
        frame.getContentPane().add(buy, c);
        frame.setVisible(true);
        // add exit button
        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Refund balance\n" + balance + " cents");
            System.exit(0);
        });
        c.gridx = 2;
        frame.getContentPane().add(exit, c);
        frame.setVisible(true);
    }
}
