// Interface for Flight

import java.util.ArrayList;
import java.util.List;

interface Flight {
    FlightDetails[] flight = null;

    void displayDetails();
}

// Class to represent a flight
class FlightDetails implements Flight {
    public String flightNumber;
    private String departure;
    private String destination;
    private int capacity;
    private int bookedSeats;

    public FlightDetails(String flightNumber, String departure, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.capacity = capacity;
        this.bookedSeats = 0;
    }

    // Method to display flight details
    public void displayDetails() {
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Departure: " + departure);
        System.out.println("Destination: " + destination);
        System.out.println("Capacity: " + capacity);
        System.out.println("Booked Seats: " + bookedSeats);
    }

    // Method to book a seat
    public void bookSeat() {
        if (bookedSeats < capacity) {
            bookedSeats++;
            System.out.println("Seat booked successfully!");
        } else {
            System.out.println("Sorry, no seats available on this flight.");
        }
    }
}

// Class to manage flight operations
public class FlightManager {
    public static final FlightDetails[] flight = null;
    List<FlightDetails> flights;

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
}
