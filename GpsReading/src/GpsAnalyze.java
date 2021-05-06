import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.ArrayList;

/**
 * pick value of location and calculate the value in degree
 *
 * @author 0086C047 潘俊言
 * @version 1.0
 */

public class GpsAnalyze {
    public static void main(String[] args) {
        // initial JFileChooser
        JFileChooser fc = new JFileChooser("./", FileSystemView.getFileSystemView());
        // show open option
        int r = fc.showOpenDialog(null);
        if (r != JFileChooser.APPROVE_OPTION) {
            return;
        }
        // set file path
        File path = new File(fc.getSelectedFile().getAbsolutePath());
        try {
            // file read initial
            BufferedReader reader = new BufferedReader(new FileReader(path));
            // file write initial in import file path
            FileWriter writer = new FileWriter(path.getParent() + "/location.csv");
            // initial ArrayList location
            ArrayList<String> location = new ArrayList<>();
            // reading one line
            String line = reader.readLine();
            while (line != null) {
                // select value starting with GPGGA
                if (line.matches("(.*)GPGGA(.*)")) {
                    // separate string by ","
                    String[] tokens = line.split(",");
                    // pick latitude
                    location.add(tokens[2]);
                    // pick longitude
                    location.add(tokens[4]);
                    // initial Transform
                    Transform transform = new Transform(location.get(0), location.get(1));
                    // set latitude value transform into degree
                    location.set(0, transform.getLatitude());
                    // set longitude value transform into degree
                    location.set(1, transform.getLongitude());
                } else if (line.matches("(.*)GPGLL(.*)")) {
                    // separate string by ","
                    String[] tokens = line.split(",");
                    // pick latitude
                    location.add(tokens[1]);
                    // pick longitude
                    location.add(tokens[3]);
                    // initial Transform
                    Transform transform = new Transform(location.get(0), location.get(1));
                    // set latitude value transform into degree
                    location.set(0, transform.getLatitude());
                    // set longitude value transform into degree
                    location.set(1, transform.getLongitude());
                } else if (line.matches("(.*)GPRMC(.*)")) {
                    // separate string by ","
                    String[] tokens = line.split(",");
                    // pick latitude
                    location.add(tokens[3]);
                    // pick longitude
                    location.add(tokens[5]);
                    // initial Transform
                    Transform transform = new Transform(location.get(0), location.get(1));
                    // set latitude value transform into degree
                    location.set(0, transform.getLatitude());
                    // set longitude value transform into degree
                    location.set(1, transform.getLongitude());
                }
                if (!location.isEmpty()) {
                    for (int i = 0; i <= 1; i++) {
                        // write location value into location.csv
                        writer.write(location.get(i));
                        if (i == 0) {
                            writer.write(",");
                        } else {
                            writer.write("\n");
                        }
                    }
                }
                // clear location array
                location.clear();
                // reading next line
                line = reader.readLine();
            }
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("Date Not Found");
        }
    }
}
