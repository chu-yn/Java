package tw.ntou.source;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * class for csv file operation to output detail in process
 */
public class FileOperation {
    // ticket you selected
    private final String ticketCost;
    // amount of ticket
    private final long ticketValue;
    // The amount of money entered by a customer so far.
    private final long balance;
    // The price of a ticket from this machine.
    private final long price;
    // buy times
    private final int times;


    public FileOperation(String ticketCost, long ticketValue, long balance, long price, int times) {
        this.ticketCost = ticketCost;
        this.ticketValue = ticketValue;
        this.balance = balance;
        this.price = price;
        this.times = times;
        if (times == 0) {
            // initial receipt
            initReceipt();
        }
        // update receipt
        printReceipt();
    }

    /**
     * create csv file for detail
     */
    public void initReceipt() {
        try {
            String path = getProgramPath();
            FileWriter writer = new FileWriter(path + "/receipt.csv");
            writer.write("Times,Price,Amount,Total,Insert,Balance\n");
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
            String path = getProgramPath();
            FileWriter writer = new FileWriter(path + "/receipt.csv", true);
            writer.write((times + 1) + ",");
            writer.write(ticketCost + ",");
            writer.write(ticketValue + ",");
            writer.write(price + ",");
            writer.write(price + balance + ",");
            writer.write(balance + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get operation path
     *
     * @return path
     */
    public static String getProgramPath() throws UnsupportedEncodingException {
        URL url = FileOperation.class.getProtectionDomain().getCodeSource().getLocation();
        String jarPath = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8);
        return new File(jarPath).getParentFile().getPath();
    }
}
