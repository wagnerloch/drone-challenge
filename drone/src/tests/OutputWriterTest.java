import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OutputWriterTest {
    private List<Drone> drones;
    private OutputWriter outputWriter;
    private final String testFilePath = "C:\\Desenvolvimento\\drone-challenge\\drone\\src\\tests\\resources";
    private final String outputFile = testFilePath + "Output_Test.txt";

    @BeforeEach
    void setUp() {
        drones = new ArrayList<>();
        Drone drone1 = new Drone("DroneA", 100);
        String[] trip1 = { "LocationA", "LocationB", "LocationC" };
        String[] trip2 = { "LocationD", "LocationE" };
        drone1.makeTrip(trip1);
        drone1.makeTrip(trip2);

        Drone drone2 = new Drone("DroneB", 150);
        String[] trip3 = { "LocationF", "LocationG" };
        drone2.makeTrip(trip3);

        drones.add(drone1);
        drones.add(drone2);
        outputWriter = new OutputWriter(drones);
    }

    @Test
    void writeResponseInFile() {
        // Call the method to be tested
        outputWriter.writeResponseInFile(outputFile);

        List<String> fileContent = new ArrayList<>();
        try {
            File file = new File(outputFile);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContent.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("Error reading file " + outputFile);
            System.err.println("Exception: " + e.getMessage());
        }

        // Check if the file content is correct
        assertEquals("[DroneA]", fileContent.get(0));
        assertEquals("Trip #1", fileContent.get(1));
        assertEquals("[LocationA], [LocationB], [LocationC]", fileContent.get(2));
        assertEquals("Trip #2", fileContent.get(3));
        assertEquals("[LocationD], [LocationE]", fileContent.get(4));
        assertEquals("", fileContent.get(5));
        assertEquals("[DroneB]", fileContent.get(6));
        assertEquals("Trip #1", fileContent.get(7));
        assertEquals("[LocationF], [LocationG]", fileContent.get(8));
        assertEquals("", fileContent.get(9));

        // Delete the file after the test
        File fileToDelete = new File(outputFile);
        fileToDelete.delete();
    }
}
