import java.io.*;
import java.util.*;

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightManager manager = new FlightManager();

        // Example: Adding some flights
        manager.addFlight(new FlightDetails("F101", "New York", "London", 200));
        manager.addFlight(new FlightDetails("F102", "London", "Paris", 150));

        while (true) {
            System.out.println("1. Display Available Flights");
            System.out.println("2. Book a Seat");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manager.displayFlights();
                    break;
                case 2:
                    System.out.print("Enter the flight number: ");
                    String flightNumber = scanner.next();
                    // Find the flight
                    for (FlightDetails flight : manager.flights) {
                        if (flight.flightNumber.equals(flightNumber)) {
                            flight.bookSeat();
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }
}
