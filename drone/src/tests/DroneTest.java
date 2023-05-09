import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DroneTest {
    @Test
    public void testGetName() {
        Drone drone = new Drone("DroneA", 200);
        assertEquals("DroneA", drone.getName());
    }

    @Test
    public void testGetMaxWeight() {
        Drone drone = new Drone("DroneA", 200);
        assertEquals(200, drone.getMaxWeight());
    }

    @Test
    public void testSetName() {
        Drone drone = new Drone("", 200);
        drone.setName("DroneA");
        assertEquals("DroneA", drone.getName());
    }

    @Test
    public void testSetMaxWeight() {
        Drone drone = new Drone("DroneA", 0);
        drone.setMaxWeight(200);
        assertEquals(200, drone.getMaxWeight());
    }

    @Test
    public void testMakeTrip() {
        Drone drone = new Drone("DroneA", 200);
        String[] locations = { "LocationA", "LocationB" };
        drone.makeTrip(locations);
        List<String[]> trips = drone.getTrips();
        assertEquals(1, trips.size());
        assertArrayEquals(locations, trips.get(0));
    }

    @Test
    public void testGetTrips() {
        Drone drone = new Drone("DroneA", 200);
        String[] locations1 = { "LocationA", "LocationB" };
        String[] locations2 = { "LocationC", "LocationD" };
        drone.makeTrip(locations1);
        drone.makeTrip(locations2);
        List<String[]> trips = drone.getTrips();
        assertEquals(2, trips.size());
        assertArrayEquals(locations1, trips.get(0));
        assertArrayEquals(locations2, trips.get(1));
    }
}
