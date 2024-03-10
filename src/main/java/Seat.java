import java.util.HashMap;
import java.util.HashSet;

public interface Seat {
    void createNewSeats(int showNumber,int minSeatNumber,int maxSeatNumber);
    HashMap<Character, HashSet<Integer>> getSeats();
}
