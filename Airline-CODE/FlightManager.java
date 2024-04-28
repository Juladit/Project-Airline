// Interface for Flight

import java.util.ArrayList;
import java.util.List;

// Class to manage flight operations
public class FlightManager {
    private List<FlightDetails> flights;

    public FlightManager() {
        flights = new ArrayList<>();
    }

    // Method to add a new flight
    public void addFlight(FlightDetails flight) {
        flights.add(flight);
    }

    // Method to display all flights
    public void displayFlights() {
        System.out.println("Available Flights:");
        for (FlightDetails flight : flights) {
            flight.displayDetails();
            System.out.println("-----------------------");
        }
    }

    // Method to find flight by flight number
    public FlightDetails findFlight(String flightNumber) {
        for (FlightDetails flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        return null;
    }
}