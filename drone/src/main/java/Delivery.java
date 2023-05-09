public class Delivery {
    private String location;
    private int weight;

    public Delivery(String location, int weight) {
        this.location = location;
        this.weight = weight;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
