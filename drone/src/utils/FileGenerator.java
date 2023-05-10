import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {

    public static void main(String[] args) {
        String fileName = "data.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            Random random = new Random();

            // Writing drones
            for (int i = 1; i <= 100; i++) {
                String droneName = "Drone" + i;
                int maxWeight = random.nextInt(201) + 50;
                writer.write("[" + droneName + "], [" + maxWeight + "]");
                if (i != 100) {
                    writer.write(", ");
                }
            }
            writer.newLine();

            // Writing locations
            String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                    "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
            for (int i = 1; i <= 500; i++) {
                String locationName = "Location" + alphabet[(i - 1) % 26] + (int) Math.ceil(i / 26);
                int weight = random.nextInt(151) + 50;
                writer.write("[" + locationName + "], [" + weight + "]");
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
