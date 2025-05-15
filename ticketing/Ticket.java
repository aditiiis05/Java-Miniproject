package ticketing;

public class Ticket {
    private String ticketId;
    private String customerName;
    private String boatId;
    private String scheduleId;

    public Ticket(String ticketId, String customerName, String boatId, String scheduleId) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.boatId = boatId;
        this.scheduleId = scheduleId;
    }

    public String getTicketId() { return ticketId; }
    public String getCustomerName() { return customerName; }
}
