import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    private Scanner scanner;
    private File file;
    private List<Drone> drones;
    private List<Delivery> deliveries;

    public InputReader(String source) {
        file = new File(source);
        drones = new ArrayList<>();
        deliveries = new ArrayList<>();
        this.readFromFile(file);
    }

    private void readFromFile(File file) {
        try {
            scanner = new Scanner(file);
            String firstLine = scanner.nextLine();
            droneParser(firstLine);
            while (scanner.hasNextLine()) {
                locationParser(scanner.nextLine());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private void droneParser(String dronesLine) {
        // First of all, remove all [] from the line
        String dronesLineClean = dronesLine.replaceAll("\\[|\\]", "");
        String[] tokens = dronesLineClean.split(", ");
        for (int i = 0; i < tokens.length; i = i + 2) {
            String name = tokens[i];
            int maxWeight = Integer.parseInt(tokens[i + 1]);
            drones.add(new Drone(name, maxWeight));
        }
    }

    /**
     * Receives a line with the location, remove brackets and parse adding it to the
     * List.
     * 
     * @param locationLine [LocationA], [200]
     */
    private void locationParser(String locationLine) {
        String locationsLineClean = locationLine.replaceAll("\\[|\\]", "");
        String[] tokens = locationsLineClean.split(", ");
        String name = tokens[0];
        int weight = Integer.parseInt(tokens[1]);
        deliveries.add(new Delivery(name, weight));
    }

    public List<Drone> getDrones() {
        return drones;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }
}
