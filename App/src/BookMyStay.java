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
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

class SearchService {
    private RoomInventory inventory;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void displayAvailableRooms(Room[] rooms) {
        for (Room room : rooms) {
            int available = inventory.getAvailability(room.getType());
            if (available > 0) {
                System.out.println(room.getType() + " | Beds: " + room.getBeds() + " | Price: " + room.getPrice() + " | Available: " + available);
            }
        }
    }
}

public class BookMyStay {
    public static void main(String[] args) {
        Room[] rooms = {
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        };

        RoomInventory inventory = new RoomInventory();
        SearchService searchService = new SearchService(inventory);

        System.out.println("Available Rooms:");
        searchService.displayAvailableRooms(rooms);
    }
}