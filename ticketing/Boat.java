package ticketing;

public class Boat {
    private String boatId;
    private String name;
    private int capacity;

    public Boat(String boatId, String name, int capacity) {
        this.boatId = boatId;
        this.name = name;
        this.capacity = capacity;
    }

    public String getBoatId() { return boatId; }
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
}
