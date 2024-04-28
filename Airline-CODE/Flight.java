
import java.io.IOException;

//Interface for Flight
public interface Flight {
 void displayDetails();
 String bookSeats(int numSeats, String[] firstNames, String[] lastNames, double pricePerSeat, double sum) throws IOException;
}
