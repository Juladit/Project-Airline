import java.io.IOException;
import java.util.Scanner;

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightManager manager = new FlightManager();
        double totalPrice = 0;

        // Example: Adding some flights
        manager.addFlight(new DomesticFlight("F101", "Bangkok", "London", 200, 20000));
        manager.addFlight(new InternationalFlight("F102", "London", "Paris", 150, 10000));

        while (true) {
            System.out.println("1. Book a Seat");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    manager.displayFlights();
                    System.out.print("Enter the flight number: ");
                    String flightNumber = scanner.nextLine().toUpperCase().trim();
                    FlightDetails flight = manager.findFlight(flightNumber);
                    if (flight != null) {
                        System.out.print("Enter number of seats to book: ");
                        int numSeats = Integer.parseInt(scanner.nextLine().trim());
                        if (numSeats > 0) {
                            String[] firstNames = new String[numSeats];
                            String[] lastNames = new String[numSeats];
                            for (int i = 0; i < numSeats; i++) {
                                System.out.print("Enter first name for seat " + (i + 1) + ": ");
                                firstNames[i] = scanner.nextLine().trim();
                                System.out.print("Enter last name for seat " + (i + 1) + ": ");
                                lastNames[i] = scanner.nextLine().trim();
                            }
                            try {
                                String ticket = flight.bookSeats(numSeats, firstNames, lastNames);
                                totalPrice += flight.getAvailableSeats() * flight.pricePerSeat; // Calculate total price
                                System.out.println(ticket); // Display the ticket
                                System.out.println("Total Price for booked seats: $" + totalPrice); // Display total price
                                System.out.println("Seats booked successfully!");
                                System.out.println();
                                
                            } catch (IOException e) {
                                System.out.println("Error occurred while booking seats: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Invalid number of seats.");
                        }
                    } else {
                        System.out.println("Flight not found.");
                    }
                    break;
                case "2":
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }
}
