public class ShowInstance {
    private int showNumber;
    public ShowInstance(int showNumber){
        this.showNumber=showNumber;
    }

    //below code violates SRP and OCP - check whether we can use factory methods to solve
    public ShowDetails getShowInstance(){
        ShowDetails s;
        if(this.showNumber==1){
            s=ShowOne.getInstance();
        } else if(this.showNumber==2){
            s=ShowTwo.getInstance();
        } else {
            s=ShowThree.getInstance();
        }

        return s;
    }
}
