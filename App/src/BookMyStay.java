import java.util.HashMap;

abstract class Room {
    private String type;
    private int beds;
    private double price;

    public Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getBeds() {
        return beds;
    }

    public double getPrice() {
        return price;
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 1000);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 1800);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 3000);
    }
}

class RoomInventory {
    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public void displayInventory() {
        for (String type : inventory.keySet()) {
            System.out.println(type + " Available: " + inventory.get(type));
        }
    }
}

public class BookMyStay {
    public static void main(String[] args) {
        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();

        System.out.println(r1.getType() + " | Beds: " + r1.getBeds() + " | Price: " + r1.getPrice() + " | Available: " + inventory.getAvailability(r1.getType()));
        System.out.println(r2.getType() + " | Beds: " + r2.getBeds() + " | Price: " + r2.getPrice() + " | Available: " + inventory.getAvailability(r2.getType()));
        System.out.println(r3.getType() + " | Beds: " + r3.getBeds() + " | Price: " + r3.getPrice() + " | Available: " + inventory.getAvailability(r3.getType()));

        System.out.println("\nInventory Snapshot:");
        inventory.displayInventory();
    }
}