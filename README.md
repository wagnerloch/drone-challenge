# Drone Delivery Service

A squad of drones is tasked with delivering packages for a major online reseller in a world where time and distance do not matter. Each drone can carry a specific weight and can make multiple deliveries before returning to home base to pick up additional loads; however, the goal is to make the fewest number of trips as each time the drone returns to home base, it is extremely costly to refuel and reload the drone.

The purpose of the written software is to accept input which will include the name of each drone and the maximum weight it can carry, along with a series of locations and the total weight needed to be delivered to that specific location. The software should highlight the most efficient deliveries for each drone to make on each trip.

Assume that time and distance to each drop off location do not matter, and that the size of each package is also irrelevant. It is also assumed that the cost to refuel and restock each drone is a constant and does not vary between drones. The maximum number of drones in a squad is 100, and there is no maximum number of deliveries which are required.

## Algorithm

The algorithm presented is a simple and effective solution to the problem described in the given scenario. It aims to minimize the number of trips made by the drones to deliver packages, taking into account the maximum weight each drone can carry.

One of the strengths of this algorithm is that it uses a FIFO (First-In, First-Out) strategy. The FIFO strategy for the drones can be a good solution, as it ensures that each drone gets an opportunity to make a delivery, and the first drone will have priority to take the packages.

Another strength of this algorithm is that it considers the maximum weight each drone can carry and assigns deliveries accordingly. This ensures that drones are used efficiently and that each drone carries as much weight as possible before returning to home base. By minimizing the number of trips made by the drones, the algorithm also minimizes the cost of refueling and reloading the drones.

## How to Run

1. Clone this repository to your local machine;
2. Open `drone` folder in VSCode;
3. Run App.java in `src/main/java/App.java`
4. The result output will be available in `Output.txt`
5. You can create new test files using the FileGenerator in `src/utils/FileGenerator.java`. Just run it and it will generate a new `data.txt` with 100 drones and 500 deliveries for testing.

## Dependencies

The only dependency is JUnit for test.