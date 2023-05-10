import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // Read all data from file and initialize all structures
        InputReader inputReader = new InputReader("src/main/resources/Input.txt");

        // Get all deliveries to do
        List<Delivery> deliveriesToDo = inputReader.getDeliveries();

        // Get all available drones
        List<Drone> availableDrones = inputReader.getDrones();

        while (deliveriesToDo.size() > 0) {
            for (int i = 0; i < availableDrones.size(); i++) {
                // Set the current weight that drone is carrying with it to zero
                int currentWeight = 0;

                // Create a list of locations that this drone is going to do
                List<String> locationsInCurrentTrip = new ArrayList<>();

                // Get the maximum weight that this drone can take
                int droneMaxWeight = availableDrones.get(i).getMaxWeight();

                // iterates over all available deliveries for the current drone
                for (int j = 0; j < deliveriesToDo.size(); j++) {

                    // get the weight of the delivery
                    int currentDeliveryWeight = deliveriesToDo.get(j).getWeight();

                    if (currentDeliveryWeight + currentWeight <= droneMaxWeight) {
                        // This drone is available to do the trip

                        // get location name
                        String currentLocationName = deliveriesToDo.get(j).getLocation();

                        locationsInCurrentTrip.add(currentLocationName);

                        // update the current weight
                        currentWeight += currentDeliveryWeight;

                        // remove the delivery from the available list
                        deliveriesToDo.remove(j);
                    }
                    if (currentWeight == droneMaxWeight) {
                        // Already full weight
                        break;
                    }
                }

                // Make the trip with the maximum locations
                availableDrones.get(i).makeTrip(locationsInCurrentTrip.toArray(new String[0]));
            }
        }

        OutputWriter ow = new OutputWriter(availableDrones);
        ow.writeResponseInFile("src/main/resources/Output.txt");
    }
}
