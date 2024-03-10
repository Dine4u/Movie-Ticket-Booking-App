public class ShowTwo extends ShowDetails{
    private static ShowTwo showTwo=null;
    private ShowTwo(){
        super.seats=createSeats();
    }
    public static ShowDetails getInstance(){
        if(showTwo==null){
            synchronized (ShowTwo.class){
                if(showTwo==null){
                    showTwo=new ShowTwo();
                }
            }
        }
        return showTwo;
    }

    public Seat createSeats(){
        Seat seats=new Seats();
        seats.createNewSeats(2,1,8);
        return  seats;
    }
}
