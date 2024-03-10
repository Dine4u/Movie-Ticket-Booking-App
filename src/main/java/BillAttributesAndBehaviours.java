public interface BillAttributesAndBehaviours {
    double serviceTax=0.14;
    double swachhBharatCess=0.005;
    double krishiKalyanCess=0.005;//Create ENUMs
    void addTicketSubTotal(char seatName);
    void print();

}
