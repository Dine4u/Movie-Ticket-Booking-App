public class ShowOne extends ShowDetails{
    private static ShowOne showOne=null;
    private ShowOne(){
        super.seats=createSeats();
    }

    public static ShowDetails getInstance(){
        if(showOne==null){
            synchronized (ShowOne.class){
                if(showOne==null){
                    showOne=new ShowOne();
                }
            }
        }
        return showOne;
    }

    public Seat createSeats(){
        Seat seats=new Seats();
        seats.createNewSeats(1,1,10);//if needed,these parameters can be passed while creating showOne object itself
        return  seats;
    }
}
