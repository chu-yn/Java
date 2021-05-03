import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.ArrayList;

/**
 * @author 0086C047 潘俊言
 * @version 1.0
 */

public class GpsAnalyze {
    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser("./", FileSystemView.getFileSystemView());
        int r = fc.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedReader reader =
                        new BufferedReader(new FileReader(fc.getSelectedFile().getAbsolutePath()));
                FileWriter writer = new FileWriter("./location.csv");
                ArrayList<String> location = new ArrayList<>();
                String line = reader.readLine();
                while (line != null) {
                    if (line.matches("(.*)GPGGA(.*)")) {
                        String[] tokens = line.split(",");
                        location.add(tokens[2]);
                        location.add(tokens[4]);
                        location.set(0, Transform.latitudeTrans(location.get(0)));
                        location.set(1, Transform.longitudeTrans(location.get(1)));
                    }
                    if (!location.isEmpty()) {
                        for (int i = 0; i <= 1; i++) {
                            writer.write(location.get(i));
                            if (i == 0) {
                                writer.write(",");
                            } else {
                                writer.write("\n");
                            }
                        }
                    }
                    location.clear();
                    line = reader.readLine();
                }
                reader.close();
                writer.close();
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found");
            } catch (IOException e) {
                System.out.println("Date Not Found");
            }
        } else {
            System.exit(0);
        }
    }


}
