import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class InputReaderTest {
    private InputReader inputReader;
    private final String fileName = "src/tests/resources/Input.txt";

    @Before
    public void setUp() {
        inputReader = new InputReader(fileName);
    }

    @Test
    public void testGetDrones() {

        List<Drone> drones = inputReader.getDrones();

        assertEquals(3, drones.size());
        assertEquals("DroneA", drones.get(0).getName());
        assertEquals(200, drones.get(0).getMaxWeight());
        assertEquals("DroneB", drones.get(1).getName());
        assertEquals(250, drones.get(1).getMaxWeight());
        assertEquals("DroneC", drones.get(2).getName());
        assertEquals(100, drones.get(2).getMaxWeight());

    }

    @Test
    public void testGetDeliveries() {
        List<Delivery> deliveries = inputReader.getDeliveries();

        assertEquals(16, deliveries.size());
        assertEquals("LocationA", deliveries.get(0).getLocation());
        assertEquals(200, deliveries.get(0).getWeight());
        assertEquals("LocationB", deliveries.get(1).getLocation());
        assertEquals(150, deliveries.get(1).getWeight());
        assertEquals("LocationC", deliveries.get(2).getLocation());
        assertEquals(50, deliveries.get(2).getWeight());
    }

    @Test
    public void testEmptyFile() throws Exception {
        File emptyFile = File.createTempFile("empty", ".txt");
        inputReader = new InputReader(emptyFile.getAbsolutePath());

        assertEquals(0, inputReader.getDrones().size());
        assertEquals(0, inputReader.getDeliveries().size());
    }
}