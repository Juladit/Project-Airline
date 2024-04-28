
import java.io.IOException;

// Concrete class representing International Flight
public class InternationalFlight extends FlightDetails {
    public InternationalFlight(String flightNumber, String departure, String destination, int capacity, double pricePerSeat) {
        super(flightNumber, departure, destination, capacity, pricePerSeat);
    }

    @Override
    protected String generateTicket(int seatNumber, String firstName, String lastName) {
        StringBuilder ticket = new StringBuilder();
        ticket.append("\n-----------------------\n");
        ticket.append("International Flight Ticket Details:\n");
        ticket.append("Flight Number: ").append(flightNumber).append("\n");
        ticket.append("Departure: ").append(departure).append("\n");
        ticket.append("Destination: ").append(destination).append("\n");
        ticket.append("Seat Number: ").append(seatNumber).append("\n");
        ticket.append("Passenger Name: ").append(firstName).append(" ").append(lastName).append("\n");
        ticket.append("Price: $").append(pricePerSeat);
        return ticket.toString();
    }

    @Override
    public String bookSeats(int numSeats, String[] firstNames, String[] lastNames, double pricePerSeat, double sum)
            throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bookSeats'");
    }
}
