import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class ShowDetails {
    protected Seat seats;
    public abstract Seat createSeats();
    public void getAvailableSeats() {
        HashMap<Character, HashSet<Integer>> seats= this.seats.getSeats();
        seats.forEach((seatCharacter,seatNumbers) -> {
            for(int i=1;i<10;i++){
                if(seatNumbers.contains(i)){
                    System.out.print(""+seatCharacter+i+" ");
                }
            }
            System.out.println();
        });
    }

    public void bookSeats(String bookedSeats,int showNumber) {
        HashMap<Character, HashSet<Integer>> seats= this.seats.getSeats();
        List<String> bookedSeatsClean= Stream.of(bookedSeats.split(","))
                .map(ticketVariable -> ticketVariable.trim())
                .collect(Collectors.toList());
        BillProcess bill=new BillProcess();
        for(String seat:bookedSeatsClean){
            char seatName=seat.charAt(0);
            int seatNumber=Integer.parseInt(seat.substring(1));
            if(seats.containsKey(seatName)){
                HashSet<Integer> seatNumbers=seats.get(seatName);
                if(seatNumbers.contains(seatNumber)){
                    seatNumbers.remove(seatNumber);
                    bill.addTicketSubTotal(seatName);
                } else {
                    System.out.println(seat+" Not available, Please select different seats");//throw Exception
                    return;
                }
            }
        }
        System.out.println("Print: Successfully Booked - Show "+showNumber);
        bill.print();
    }
}
