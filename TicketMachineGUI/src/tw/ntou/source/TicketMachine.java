package tw.ntou.source;

import tw.ntou.source.BuyButton;

import javax.swing.*;
import java.awt.*;

public class TicketMachine {
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

        JButton buy = new JButton("Buy");
        GridBagConstraints c = new GridBagConstraints();
        buy.addActionListener(e -> new BuyButton(frame, balance));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        frame.getContentPane().add(buy, c);
        frame.setVisible(true);

        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> System.exit(0));
        c.gridx = 1;
        frame.getContentPane().add(exit, c);
        frame.setVisible(true);
    }
}
