import java.util.Scanner;

/*
For detailed instructions, please refer to the README file.
It contains all the necessary guidelines and information for submitting and working with this project.
 */

public class Start {
    //Below Scanner object can be made non static, since In my design, scanner object used only in below main method
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //your code from here......
        String continueTicketBooking="Yes";
        while (continueTicketBooking.equals("Yes")){
            System.out.println("Input:");
            int showNumber=scanner.nextInt();
            scanner.nextLine(); //adding this nextLine() to consume the "end of line" in the buffer from the above scanner.nextInt()
            System.out.println("Enter Show no: "+showNumber);
            ShowInstance sd=new ShowInstance(showNumber);
            ShowDetails show=sd.getShowInstance();
            System.out.println("Available Seats:");
            show.getAvailableSeats();
            System.out.print("Enter Seats: ");
            String bookedSeats= scanner.nextLine();
            show.bookSeats(bookedSeats,showNumber);
            System.out.println("Would you like to continue (Yes/No): ");
            continueTicketBooking=scanner.next();
            scanner.nextLine();
        }
        System.out.println("Total Sales:");
        BillProcess.printTotalSales();
    }
}
