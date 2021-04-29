import java.io.*;
import java.util.ArrayList;

/**
 * @author 0086C047 潘俊言
 * @version 1.0
 */

public class GpsAnalyze {
    public static void main(String[] args) {
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader("src/NMEA_GPS.txt"));
            FileWriter writer = new FileWriter("./location.csv");
            String line = reader.readLine();
            while (line != null) {
                if (line.matches("(.*)GPGGA(.*)")) {
                    String[] tokens = line.split(",");
                    ArrayList<String> location = new ArrayList<>();
                    location.add(tokens[2]);
                    location.add(tokens[4]);
                    location.set(0, Transform.latitudeTrans(location.get(0)));
                    location.set(1, Transform.longitudeTrans(location.get(1)));
                    for (int i = 0; i <= 1; i++) {
                        writer.write(location.get(i));
                        if (i == 0) {
                            writer.write(",");
                        } else {
                            writer.write("\n");
                        }
                    }
                }
                line = reader.readLine();
            }
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Date not found");
        }
    }


}
