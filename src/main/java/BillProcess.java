public class BillProcess implements BillAttributesAndBehaviours {
    private int subTotal;
    private double Total;
    private static int Revenue;

    public static void printTotalSales() {
        System.out.println("Revenue: Rs."+BillProcess.Revenue);
        System.out.printf("Service Tax: Rs. %.2f",BillProcess.Revenue*serviceTax).println();
        System.out.printf("Swachh Bharat Cess: Rs. %.2f",BillProcess.Revenue*swachhBharatCess).println();
        System.out.printf("Krishi Kalyan Cess: Rs. %.2f",BillProcess.Revenue*krishiKalyanCess).println();
    }

    public void addTicketSubTotal(char seatName) {
        if(seatName=='A'){
            this.subTotal+=320;
        } else if(seatName=='B'){ // Seat
            this.subTotal+=280;
        } else {
            this.subTotal+=240;
        }
    }

    private int getSubTotal(){
        return this.subTotal;
    }

    private double getServiceTax() {
        double serviceTax=this.subTotal*BillAttributesAndBehaviours.serviceTax;
        return serviceTax;
    }

    private double getSwachhBharatCess(){
        double swachhBharatCess=this.subTotal*BillAttributesAndBehaviours.swachhBharatCess;
        return swachhBharatCess;
    }

    private double getKrishiKalyanCess(){
        double krishiKalyanCess=this.subTotal*BillAttributesAndBehaviours.krishiKalyanCess;
        return krishiKalyanCess;
    }

    private int getTotal(){
        BillProcess.Revenue+=getSubTotal();
        Total=Math.ceil(getSubTotal()+getServiceTax()+getSwachhBharatCess()+getKrishiKalyanCess());
        return (int)Total;
    }

    public void print() {
        System.out.println("Subtotal: Rs. "+getSubTotal());
        System.out.print("Service Tax @14%: Rs. ");
        System.out.printf("%.2f",getServiceTax()).println();
        System.out.print("Swachh Bharat Cess @0.5%: Rs. ");
        System.out.printf("%.2f",getSwachhBharatCess()).println();
        System.out.print("Krishi Kalyan Cess @0.5%: Rs. ");
        System.out.printf("%.2f",getKrishiKalyanCess()).println();
        System.out.println("Total: Rs. "+getTotal());
    }
}