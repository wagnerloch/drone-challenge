import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class OutputWriter {
    private List<Drone> drones;

    /**
     * Construct the writer with a list of drones.
     * 
     * @param drones List<Drone>
     */
    public OutputWriter(List<Drone> drones) {
        this.drones = drones;
    }

    /**
     * Write the response of the algorithm into a file.
     * If the file already exists, it will be overwritten.
     * 
     * @param fileName String containing the name of the file to save the response.
     *                 Example: "Output.txt".
     */
    public void writeResponseInFile(String fileName) {
        BufferedWriter bufferedWriter = createFileAndWriterConfig(fileName);
        try {
            // Iterates over all drones
            for (int i = 0; i < drones.size(); i++) {
                bufferedWriter.write("[" + drones.get(i).getName() + "]");
                bufferedWriter.newLine();
                // Iterates over all trips
                for (int j = 0; j < drones.get(i).getTrips().size(); j++) {
                    int currentTrip = j + 1;
                    bufferedWriter.write("Trip #" + currentTrip);
                    bufferedWriter.newLine();
                    // Get all locations of the current trip
                    String[] locationsInCurrentTrip = drones.get(i).getTrips().get(j);
                    bufferedWriter.write(getLocationsInSingleLine(locationsInCurrentTrip));
                    bufferedWriter.newLine();
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("Error writing file " + fileName);
            System.err.println("Exception: " + e.getMessage());
        }

    }

    /**
     * This functions receives an array of locations and returns in a single string
     * with commas and brackets.
     * 
     * @param locations Array of String with all locations
     * @return String containing all locations in a single line
     */
    private String getLocationsInSingleLine(String[] locations) {
        String locationsString = "";
        for (String location : locations) {
            locationsString += "[" + location + "], ";
        }

        // remove the final comma and white space
        locationsString = locationsString.replaceAll(",\\s*$", "");

        return locationsString;
    }

    /**
     * Create the output file and all configurations to write
     * 
     * @param fileName String containing the name of the file
     * @return BufferedWriter to write in the file
     */
    private BufferedWriter createFileAndWriterConfig(String fileName) {
        try {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            return new BufferedWriter(fileWriter);
        } catch (Exception e) {
            System.err.println("Error creating file " + fileName);
            System.err.println("Exception: " + e.getMessage());
            return null;
        }
    }
}
