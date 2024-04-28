
import java.io.*;

//Abstract class for flight details
public abstract class FlightDetails implements Flight {
 protected String flightNumber;
 protected String departure;
 protected String destination;
 protected int capacity;
 protected int bookedSeats;
 protected double pricePerSeat; // New field for price per seat

 public FlightDetails(String flightNumber, String departure, String destination, int capacity, double pricePerSeat) {
     this.flightNumber = flightNumber;
     this.departure = departure;
     this.destination = destination;
     this.capacity = capacity;
     this.bookedSeats = 0;
     this.pricePerSeat = pricePerSeat;
 }

 // Method to display flight details
 public void displayDetails() {
     System.out.println("Flight Number: " + flightNumber);
     System.out.println("Departure: " + departure);
     System.out.println("Destination: " + destination);
     System.out.println("Capacity: " + capacity);
     System.out.println("Booked Seats: " + bookedSeats);
     System.out.println("Price per Seat: $" + pricePerSeat);
 }

    /// Method to book seats
 public String bookSeats(int numSeats, String[] firstNames, String[] lastNames) throws IOException {
	    if (bookedSeats + numSeats <= capacity) {
	        StringBuilder ticket = new StringBuilder();
	        for (int i = 0; i < numSeats; i++) {
	            int seatNumber = bookedSeats + 1; // Calculate the seat number
	            bookedSeats++; // Increment booked seats
	            capacity--;
	            ticket.append(generateTicket(seatNumber, firstNames[i], lastNames[i]));
	            ticket.append("\n");
	        }
	        saveFlightDetails();
	        return ticket.toString();
	    } else {
	        return "Sorry, not enough seats available on this flight.";
	    }
	}

    // Method to save flight details to a file
    protected void saveFlightDetails() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("flight_details.txt", true))) {
            writer.println("Flight Number: " + flightNumber + ", Departure: " + departure +
                    ", Destination: " + destination + ", Booked Seats: " + bookedSeats + ", Price per Seat: $" + pricePerSeat);
        }
    }

    // Method to generate ticket
    protected abstract String generateTicket(int seatNumber, String firstName, String lastName);

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getAvailableSeats() {
        return capacity - bookedSeats;
    }
}
