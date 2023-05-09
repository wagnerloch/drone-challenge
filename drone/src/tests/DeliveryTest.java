import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeliveryTest {
    private Delivery delivery;

    @BeforeEach
    public void setUp() {
        delivery = new Delivery("LocationA", 200);
    }

    @Test
    public void testGetLocation() {
        assertEquals("LocationA", delivery.getLocation());
    }

    @Test
    public void testSetLocation() {
        delivery.setLocation("LocationB");
        assertEquals("LocationB", delivery.getLocation());
    }

    @Test
    public void testGetWeight() {
        assertEquals(200, delivery.getWeight());
    }

    @Test
    public void testSetWeight() {
        delivery.setWeight(20);
        assertEquals(20, delivery.getWeight());
    }
}