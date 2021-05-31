package tw.ntou.source;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * class for the process of buy button being pressed
 */
public class BuyButton extends JFrame {
    private final JFrame button;
    // ticket you selected
    private Object ticketCost;
    // amount of ticket
    private long ticketValue;
    // The amount of money entered by a customer so far.
    private long balance;
    // The price of a ticket from this machine.
    private long price;
    // buy times
    private int times;
    // file path initial
    File path = new File("./out/");

    public BuyButton(Component frame, long balance, int times) {
        this.button = (JFrame) frame;
        this.balance = balance;
        this.times = times;
        if (times == 0) {
            initReceipt();
        }
    }

    /**
     * all process for BuyButton
     *
     * @return balance
     */
    public long process() {
        button.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Object[] possibleValues = {"150", "90"};
        ticketCost = JOptionPane.showInputDialog(button, "Which Price", "Price",
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
        ticketValue = Long.parseLong(value);
        price = ticketCost * ticketValue;
        JOptionPane.showMessageDialog(button, "Price need to Pay: " + getPrice());
        if (balance < price) {
            buyProcess();
        }
        printTicket();
        times += 1;
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
    public long getPrice() {
        return price;
    }

    /**
     * Return The amount of money already inserted for the next ticket.
     */
    public long getBalance() {
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
        printReceipt();
    }

    /**
     * create csv file for detail
     */
    public void initReceipt() {
        try {
            FileWriter writer = new FileWriter(path + "/receipt.csv");
            writer.write("Times,Price,Amount,Total,Balance\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * write csv file for detail
     */
    public void printReceipt() {
        try {
            FileWriter writer = new FileWriter(path + "/receipt.csv", true);
            writer.write((times + 1) + ",");
            writer.write(ticketCost.toString() + ",");
            writer.write(ticketValue + ",");
            writer.write(price + ",");
            writer.write(balance + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    /**
     * get times
     *
     * @return times
     */
    public int getTimes() {
        return times;
    }
}
