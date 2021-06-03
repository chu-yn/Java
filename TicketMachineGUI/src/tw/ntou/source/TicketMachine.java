package tw.ntou.source;

import javax.swing.*;
import java.awt.*;

/**
 * class for building main frame of TicketMachine
 */
public class TicketMachine extends JFrame {
    private JFrame frame;
    private long balance;
    private int times;

    public TicketMachine() {
        balance = 0;
        times = 0;
        makeFrame();
    }

    /**
     * make main frame
     */
    public void makeFrame() {
        // main frame initial
        frame = new JFrame("TicketMachine");
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // add menu bar
        JMenu menu = new JMenu("Menu");
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Refund balance\n" + balance + " cents");
            System.exit(0);
        });
        menu.add(quit);
        menu.setPopupMenuVisible(true);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // add balance remain label
        JLabel label = new JLabel("Balance: " + balance);
        Font font = new Font("Serif", Font.BOLD, 18);
        label.setFont(font);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentY(Component.CENTER_ALIGNMENT);

        // text panel
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));
        textPanel.add(label);
        textPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        // add buy button
        JButton buy = new JButton("Buy");
        buy.setAlignmentX(Component.CENTER_ALIGNMENT);
        buy.setAlignmentY(Component.CENTER_ALIGNMENT);
        buy.addActionListener(e -> {
            BuyButton buyButton = new BuyButton(frame, balance, times);
            balance = buyButton.process();
            times = buyButton.getTimes();
            label.setText("Balance: " + balance);
        });

        // add exit button
        JButton exit = new JButton("Exit");
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Refund balance\n" + balance + " cents");
            System.exit(0);
        });

        // button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        buttonPanel.add(buy);
        buttonPanel.add(Box.createHorizontalStrut(15));
        buttonPanel.add(exit);

        // main frame
        frame.add(Box.createVerticalGlue());
        frame.getContentPane().add(textPanel);
        frame.getContentPane().add(buttonPanel);
        frame.add(Box.createVerticalGlue());
        frame.setVisible(true);
    }
}
