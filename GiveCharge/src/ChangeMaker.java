import javax.swing.JOptionPane;

/**
 * @author 0086C047 潘俊言
 * @version 1.0
 */


public class ChangeMaker {
    private int amount, originAmount, quarters, dimes, nickels, pennies;

    public class Coins {
        /**
         * constructor of Coins
         * Process calculate & display result while user doesn't click cancel.
         */
        public Coins() {
            while (true) {
                String amountString = JOptionPane.showInputDialog("Enter number 1 ~ 99\n");
                amount = Integer.parseInt(amountString);
                calculate();
                display();
            }
        }
    }

    /**
     * get quarters method
     */
    public void getQuarters() {
        quarters = amount / 50;
    }

    /**
     * get dimes method
     */
    public void getDimes() {
        dimes = amount / 10;
    }

    /**
     * get nickels method
     */
    public void getNickels() {
        nickels = amount / 5;
    }

    /**
     * get pennies method
     */
    public void getPennies() {
        pennies = amount;
    }

    /**
     * calculate method
     * process all get method, and get mode
     */
    public void calculate() {
        originAmount = amount;
        getQuarters();
        amount %= 50;
        getDimes();
        amount %= 10;
        getNickels();
        amount %= 5;
        getPennies();
    }

    /**
     * display final result
     */
    public void display() {
        JOptionPane.showMessageDialog(null, "Origin:" + originAmount
                + "\nQuarters(50):" + quarters + "\nDimes(10):" + dimes + "\nNickels(5):"
                + nickels + "\nPennies(1):" + pennies);
    }

    public static void main(String[] args) {
        ChangeMaker changeMaker = new ChangeMaker();
        ChangeMaker.Coins coins = changeMaker.new Coins();
        System.exit(0);
    }
}
