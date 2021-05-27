package tw.ntou.source;

import javax.swing.*;
import java.awt.*;

public class BuyButton extends JFrame {
    private final JFrame button;
    private int ticketValue;
    // The amount of money entered by a customer so far.
    private int balance;
    // The price of a ticket from this machine.
    private int price;
    // The total amount of money collected by this machine.

    public BuyButton(Component frame, int balance) {
        this.button = (JFrame) frame;
        this.balance = balance;
    }

    /**
     * all process for BuyButton
     *
     * @return balance
     */
    public int process() {
        button.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Object[] possibleValues = {"150", "90"};
        Object ticketCost = JOptionPane.showInputDialog(button, "Which Price", "Price",
                JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
        machineProcess(Integer.parseInt(ticketCost.toString()));
        Object[] options = {"Yes", "No"};
        int result = JOptionPane.showOptionDialog(button, "Continue to buy?", "Warning",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(button, "Refund balance\n" + getBalance() + " cents");
            System.exit(0);
        } else if (result == JOptionPane.YES_OPTION) {
            button.setVisible(true);
            return getBalance();
        }
        return 0;
    }

    /**
     * method of TicketMachine process
     */
    public void machineProcess(int ticketCost) {
        JOptionPane.showMessageDialog(button, "Please input amount you want.");
        Keyboard keyboard = new Keyboard();
        String value = keyboard.getValue();
        if (notNum(value) || value.isEmpty()) {
            JOptionPane.showMessageDialog(button, "Please insert positive integer!");
            machineProcess(ticketCost);
        }
        ticketValue = Integer.parseInt(value);
        price = ticketCost * ticketValue;
        JOptionPane.showMessageDialog(button, "Price need to Pay: " + getPrice());
        buyProcess();
        printTicket();
    }

    /**
     * method of buying ticket process
     */
    public void buyProcess() {
        insertMoney();
        if (balance < price) {
            JOptionPane.showMessageDialog(button,
                    "You must insert at least " + (price - balance) + " more balance.");
            buyProcess();
        }
    }

    /**
     * Return The price of a ticket.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Return The amount of money already inserted for the next ticket.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Receive an amount of money in cents from a customer. Check that the amount is
     * sensible.
     */
    public void insertMoney() {
        JOptionPane.showMessageDialog(button, "Please insert Money");
        Keyboard keyboard = new Keyboard();
        String amount = keyboard.getValue();
        while (notNum(amount) || amount.isEmpty()) {
            JOptionPane.showMessageDialog(button, "Please insert positive integer!");
            JOptionPane.showMessageDialog(button, "Please insert Money");
            Keyboard inner = new Keyboard();
            amount = inner.getValue();
        }
        balance = balance + Integer.parseInt(amount);
        JOptionPane.showMessageDialog(button, "Balance has been inserted: " + getBalance());
    }

    /**
     * Print a ticket, and reduce the current balance by the ticket price.
     */
    public void printTicket() {
        // Simulate the printing of a ticket.
        JOptionPane.showMessageDialog(button,
                "##################\n" + "# The BlueJ Line\n" + "# Ticket\n"
                        + "# " + price + " cents.\n" + "# Amount\n" + "# " + ticketValue + "\n##################");
        // Update the total collected with the price.
        // Reduce the balance by the price.
        balance = balance - price;
    }

    /**
     * function of determining whether string is integer
     *
     * @param str input
     * @return boolean
     */
    public static boolean notNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
