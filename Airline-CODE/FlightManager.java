
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Class to manage flight operations
public class FlightManager {
    private Map<String, FlightDetails> flights;

    public FlightManager() {
        flights = new HashMap<>();
    }

    // Method to add a new flight
    public void addFlight(FlightDetails flight) {
        flights.put(flight.getFlightNumber(), flight);
    }

    // Method to display all flights
    public void displayFlights() {
        System.out.println("\nAvailable Flights:");
        for (FlightDetails flight : flights.values()) {
            flight.displayDetails();
            System.out.println("-----------------------");
        }
    }

    // Method to find flight by flight number
    public FlightDetails findFlight(String flightNumber) {
        return flights.get(flightNumber.toUpperCase());
    }

    // Method to read flight details from a file
    public void readFlightDetailsFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String flightNumber = parts[0].trim();
                    String departure = parts[1].trim();
                    String destination = parts[2].trim();
                    int capacity = Integer.parseInt(parts[3].trim());
                    double pricePerSeat = Double.parseDouble(parts[4].trim());
                    FlightDetails flight = new DomesticFlight(flightNumber, departure, destination, capacity, pricePerSeat);
                    addFlight(flight);
                }
            }
        }
    }
}
