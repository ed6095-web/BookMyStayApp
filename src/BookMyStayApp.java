/**
 * Book My Stay Application
 *
 * <p>This class represents the entry point of the Hotel Booking Management System.
 * The application demonstrates how a Java program starts execution and prints
 * a welcome message to the console.</p>
 *
 * <p>Use Case 1 establishes a clear starting point for the application
 * by implementing the main() method and displaying application information.</p>
 *
 * @author Eashan
 * @version 1.0
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// UC2 - Abstract Room Class
abstract class Room {

    protected String roomType;
    protected int beds;
    protected int size;
    protected double price;

    public Room(String roomType, int beds, int size, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + beds);
        System.out.println("Room Size: " + size + " sq ft");
        System.out.println("Price per night: $" + price);
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 200, 100.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 350, 180.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 500, 300.0);
    }
}
public class BookMyStayApp {

    /**
     * Main method - Entry point of the Java application.
     * JVM begins execution from this method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

            // UC1
            System.out.println("=====================================");
            System.out.println("        BOOK MY STAY APPLICATION");
            System.out.println("        Hotel Booking System v2.1");
            System.out.println("=====================================");
            System.out.println("Welcome! Application started successfully.");

            // UC2 - Initialize Room Objects
            Room single = new SingleRoom();
            Room doubleRoom = new DoubleRoom();
            Room suite = new SuiteRoom();

        // UC3 - Centralized Room Inventory
        Map<String, Integer> roomInventory = new HashMap<>();

        roomInventory.put("Single Room", 5);
        roomInventory.put("Double Room", 3);
        roomInventory.put("Suite Room", 2);
        System.out.println("\n--- Room Details ---\n");

        single.displayRoomDetails();
        System.out.println("Available Rooms: " + roomInventory.get("Single Room"));
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + roomInventory.get("Double Room"));
        System.out.println();

        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + roomInventory.get("Suite Room"));

// UC4 - Room Search & Availability Check

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== ROOM SEARCH =====");
        System.out.print("Enter room type to search (Single Room / Double Room / Suite Room): ");

        String searchRoom = scanner.nextLine();

        System.out.println("\n--- Search Result ---\n");

// Check if room exists in inventory
        if (roomInventory.containsKey(searchRoom)) {

            int available = roomInventory.get(searchRoom);

            // Show only rooms with availability > 0
            if (available > 0) {

                if (searchRoom.equalsIgnoreCase("Single Room")) {
                    single.displayRoomDetails();
                } else if (searchRoom.equalsIgnoreCase("Double Room")) {
                    doubleRoom.displayRoomDetails();
                } else if (searchRoom.equalsIgnoreCase("Suite Room")) {
                    suite.displayRoomDetails();
                }

                System.out.println("Available Rooms: " + available);

            } else {
                System.out.println("Sorry! No rooms available for " + searchRoom);
            }

        } else {
            System.out.println("Invalid room type entered.");
        }

        scanner.close();

    }
}
