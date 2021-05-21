package tw.ntou.source;
/**
 * process for buy button
 */

import javax.swing.*;
import java.awt.*;

public class BuyButton {
    private JFrame frame;
    private int ticketValue;
    // The amount of money entered by a customer so far.
    private int balance;
    // The price of a ticket from this machine.
    private int price;
    // The total amount of money collected by this machine.
    private int total;
    // The amount of 50 coin in machine
    private int fiftyCoin = 10;
    // The amount of 10 coin in machine
    private int tenCoin = 10;
    // The amount of 5 coin in machine
    private int fiveCoin = 10;
    // The amount of 1 coin in machine
    private int oneCoin = 10;

    public BuyButton(Component Iframe) {
        frame = (JFrame) Iframe;
        balance = 0;
        // get initial total in machine
        total = fiftyCoin * 50 + tenCoin * 10 + fiveCoin * 5 + oneCoin;
        boolean isContinue = true;
        while (isContinue) {
            Object[] possibleValues = {"150", "90"};
            Object ticketCost = JOptionPane.showInputDialog(frame, "Which Price", "Price",
                    JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
            machineProcess(Integer.parseInt(ticketCost.toString()));
            Object[] options = {"Yes", "No"};
            int result = JOptionPane.showOptionDialog(frame, "Continue to buy?", "Warning",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (result == 1) {
                isContinue = false;
            }
        }
        JOptionPane.showMessageDialog(frame, "Refund balance\n" + refundBalance() + " cents");
        System.exit(0);
    }

    /**
     * method of TicketMachine process
     */
    public void machineProcess(int ticketCost) {
        String value = JOptionPane.showInputDialog("Please input amount you want");
        ticketValue = Integer.parseInt(value);
        price = ticketCost * ticketValue;
        buyProcess();
    }

    /**
     * method of buying ticket process
     */
    public void buyProcess() {
        JOptionPane.showMessageDialog(frame, "Price need to Pay: " + getPrice());
        while (balance < price) {
            JOptionPane.showMessageDialog(frame,
                    "You must insert at least " + (price - balance) + " more balance.");
            insertMoney();
        }
        printTicket();
        JOptionPane.showMessageDialog(frame, "Balance you have: " + getBalance());
    }

    /**
     * get amount of refund coin
     */
    public void refundCoin(int amount) {
        int quarters = amount / 50;
        fiftyCoin -= quarters;
        amount %= 50;
        int dimes = amount / 10;
        tenCoin -= dimes;
        amount %= 10;
        int nickels = amount / 5;
        fiveCoin -= nickels;
        amount %= 5;
        int pennies = amount;
        oneCoin -= pennies;
    }

    /**
     * The balance is cleared.
     *
     * @return the money in the balance
     */
    public int refundBalance() {
        int amountToRefund;
        amountToRefund = balance;
        refundCoin(balance);
        total -= balance;
        balance = 0;
        return amountToRefund;
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
     * get amount of coins which inserted by user
     */
    public void getCoin(int amount) {
        int quarters = amount / 50;
        fiftyCoin += quarters;
        amount %= 50;
        int dimes = amount / 10;
        tenCoin += dimes;
        amount %= 10;
        int nickels = amount / 5;
        fiveCoin += nickels;
        amount %= 5;
        int pennies = amount;
        oneCoin += pennies;
    }

    /**
     * Receive an amount of money in cents from a customer. Check that the amount is
     * sensible.
     */
    public void insertMoney() {
        String amount = JOptionPane.showInputDialog("Insert Money");
        if (Integer.parseInt(amount) > 0) {
            balance = balance + Integer.parseInt(amount);
            getCoin(Integer.parseInt(amount));
            JOptionPane.showMessageDialog(frame,
                    "Balance has been inserted: " + getBalance());
        } else {
            JOptionPane.showMessageDialog(frame, "Use a positive amount: " + amount);
        }
    }

    /**
     * Print a ticket, and reduce the current balance by the ticket price.
     */
    public void printTicket() {
        // Simulate the printing of a ticket.
        JOptionPane.showMessageDialog(frame,
                "##################\n" + "# The BlueJ Line\n" + "# Ticket\n"
                        + "# " + price + " cents.\n" + "# Amount\n" + "# " + ticketValue + "\n##################");
        // Update the total collected with the price.
        total = total + balance;
        // Reduce the balance by the price.
        balance = balance - price;
    }

}
