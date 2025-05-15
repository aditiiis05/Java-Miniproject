package operations;

import ticketing.Ticket;

public interface Bookable {
    Ticket bookTicket(String customerName, String boatId, String scheduleId) throws OverbookingException;
}
