import java.util.Scanner;

/**
 * @author 0086C047 潘俊言
 * @version 1.0
 */
public class NewTicketMachine {
    Scanner keyboard = new Scanner(System.in);

    public class TicketMachine {
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

        /**
         * Create a machine that issues tickets of the given price.
         */
        public TicketMachine() {
            balance = 0;
            // get initial total in machine
            total = fiftyCoin * 50 + tenCoin * 10 + fiveCoin * 5 + oneCoin;
        }

        /**
         * method of TicketMachine process
         */
        public void machineProcess(int ticket1, int ticket2) {
            int ticketCost = 0;
            boolean toContinue = true;
            while (toContinue) {
                while (ticketCost <= 0) {
                    ticketCost = ticketChoose(ticket1, ticket2);
                }
                buyProcess();
                System.out.println("Continue or not (y/n):");
                char goOn = keyboard.next().charAt(0);
                if (goOn == 'Y' || goOn == 'y') {
                    toContinue = true;
                    ticketCost = 0;
                } else {
                    toContinue = false;
                    System.out.println("Refund: " + refundBalance());
                }
            }
        }

        /**
         * method of buying ticket process
         */
        public void buyProcess() {
            System.out.println("Ticket Price is " + getPrice() + " for one ticket.");
            if (balance < price) {
                do {
                    System.out.println("You must insert at least: " + (price - balance) + " more cents.");
                    insertMoney();
                } while (balance < price);
            }
            printTicket();
            System.out.println("Balance you have: " + getBalance());
        }

        /**
         * method of choosing price of ticket
         *
         * @return price of ticket
         */
        public int ticketChoose(int ticket1, int ticket2) {
            int ticketCost = 0;
            System.out.println("Which price: 1. " + ticket1 + " 2. " + ticket2);
            int choice = keyboard.nextInt();
            if (choice == 1) {
                ticketCost = ticket1;
            } else if (choice == 2) {
                ticketCost = ticket2;
            } else {
                System.out.println("Please try again");
            }
            price = ticketCost;
            return ticketCost;
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
         * get the amount of all type of coins and print it out
         */
        public void getMachineInfo() {
            System.out.println("System info");
            System.out.println("#######################");
            System.out.println("total in machine: " + total);
            System.out.println("Amount of fifty coin: " + fiftyCoin);
            System.out.println("Amount of ten coin: " + tenCoin);
            System.out.println("Amount of five coin: " + fiveCoin);
            System.out.println("Amount of one coin: " + oneCoin);
            System.out.println("#######################");
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
            System.out.println("Please insert money!");
            int amount = keyboard.nextInt();
            if (amount > 0) {
                balance = balance + amount;
                getCoin(amount);
                System.out.println("Balance has been inserted: " + getBalance());
            } else {
                System.out.println("Use a positive amount: " + amount);
            }
        }

        /**
         * Print a ticket, and reduce the current balance by the ticket price.
         */
        public void printTicket() {
            // Simulate the printing of a ticket.
            System.out.println("\n##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################\n");
            // Update the total collected with the price.
            total = total + balance;
            // Reduce the balance by the price.
            balance = balance - price;
        }
    }

    public static void main(String[] args) {
        NewTicketMachine newTicketMachine = new NewTicketMachine();
        NewTicketMachine.TicketMachine ticketMachine = newTicketMachine.new TicketMachine();
        ticketMachine.getMachineInfo();
        ticketMachine.machineProcess(199, 119);
        ticketMachine.getMachineInfo();
        System.exit(0);
    }
}