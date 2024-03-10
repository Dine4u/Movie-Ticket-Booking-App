public class ShowThree extends ShowDetails{
    private static ShowThree showThree=null;
    private ShowThree(){
        super.seats=createSeats();
    }
    public static ShowDetails getInstance(){
        if(showThree==null){
            synchronized (ShowThree.class){
                if(showThree==null){
                    showThree=new ShowThree();
                }
            }
        }
        return showThree;
    }

    public Seat createSeats(){
        Seat seats=new Seats();
        seats.createNewSeats(3,1,10);
        return  seats;
    }
}
