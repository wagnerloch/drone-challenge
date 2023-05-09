import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DroneTest {
    @Test
    public void testGetName() {
        Drone drone = new Drone("Drone 1", 1000);
        assertEquals("Drone 1", drone.getName());
    }

    @Test
    public void testGetMaxWeight() {
        Drone drone = new Drone("Drone 1", 1000);
        assertEquals(1000, drone.getMaxWeight());
    }

    @Test
    public void testSetName() {
        Drone drone = new Drone("Drone 1", 1000);
        drone.setName("Drone 2");
        assertEquals("Drone 2", drone.getName());
    }

    @Test
    public void testSetMaxWeight() {
        Drone drone = new Drone("Drone 1", 1000);
        drone.setMaxWeight(1500);
        assertEquals(1500, drone.getMaxWeight());
    }

    @Test
    public void testMakeTrip() {
        Drone drone = new Drone("Drone 1", 1000);
        String[] locations = { "São Paulo", "Rio de Janeiro" };
        drone.makeTrip(locations);
        List<String[]> trips = drone.getTrips();
        assertEquals(1, trips.size());
        assertArrayEquals(locations, trips.get(0));
    }

    @Test
    public void testGetTrips() {
        Drone drone = new Drone("Drone 1", 1000);
        String[] locations1 = { "São Paulo", "Rio de Janeiro" };
        String[] locations2 = { "Rio de Janeiro", "Belo Horizonte" };
        drone.makeTrip(locations1);
        drone.makeTrip(locations2);
        List<String[]> trips = drone.getTrips();
        assertEquals(2, trips.size());
        assertArrayEquals(locations1, trips.get(0));
        assertArrayEquals(locations2, trips.get(1));
    }
}
