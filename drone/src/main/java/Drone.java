import java.util.ArrayList;
import java.util.List;

public class Drone {
    private String name;
    private int maxWeight;
    private List<String[]> trips;

    public Drone(String name, int maxWeight) {
        this.name = name;
        this.maxWeight = maxWeight;
        this.trips = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeTrip(String[] locations) {
        trips.add(locations);
    }

    public List<String[]> getTrips() {
        return trips;
    }
}
