import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Seats implements Seat{
    private HashMap<Character, HashSet<Integer>> seats;
    public Seats(){
        this.seats=new HashMap<>();
        this.seats.put('A',new HashSet<>());
        this.seats.put('B',new HashSet<>());
        this.seats.put('C',new HashSet<>());
    }

    //Below code violates SRP and OCP
    @Override
    public void createNewSeats(int showNumber,int minSeatNumber,int maxSeatNumber) {
        {
            for(int i=minSeatNumber;i<maxSeatNumber;i++){
                if(showNumber==1){
                    addPlatinumSeat(i);
                    if(i<7){
                        addGoldSeat(i);
                    }
                    if(i>1 && i<8){
                        addSilverSeat(i);
                    }
                } else if(showNumber==2){
                    addPlatinumSeat(i);
                    if(i>1 && i<7){
                        addGoldSeat(i);
                    }
                    if(i<8){
                        addSilverSeat(i);
                    }
                } else {
                    if(i<8){
                        addPlatinumSeat(i);
                    }
                    addSilverSeat(i);
                    if(i<9){
                        addGoldSeat(i);
                    }
                }
            }
        }
    }

    private void addPlatinumSeat(int i) {
        if(this.seats.containsKey('A')){
            HashSet<Integer> seatNumbers=this.seats.get('A');
            seatNumbers.add(i);
        }
    }

    private void addGoldSeat(int i) {
        if(this.seats.containsKey('B')){
            HashSet<Integer> seatNumbers=this.seats.get('B');
            seatNumbers.add(i);
        }
    }

    private void addSilverSeat(int i) {
        if(this.seats.containsKey('C')){
            HashSet<Integer> seatNumbers=this.seats.get('C');
            seatNumbers.add(i);
        }
    }

    public HashMap<Character, HashSet<Integer>> getSeats(){
        return this.seats;
    }
}
