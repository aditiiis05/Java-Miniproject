package operations;

import ticketing.*;
import java.util.*;
import java.io.*;
import reporting.*;

public class BookingManager implements Bookable, Cancelable {
    private Map<String, Schedule> schedules;
    private List<Ticket> tickets = new ArrayList<>();

    public BookingManager(Map<String, Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public Ticket bookTicket(String customerName, String boatId, String scheduleId) throws OverbookingException {
        Schedule schedule = schedules.get(scheduleId);
        if (schedule == null) throw new IllegalArgumentException("Schedule not found.");

        if (schedule.getBookedSeats() >= 10)
            throw new OverbookingException("Boat is fully booked!");

        schedule.bookSeat();
        String ticketId = "TICK" + (tickets.size() + 1);
        Ticket ticket = new Ticket(ticketId, customerName, boatId, scheduleId);
        tickets.add(ticket);
        SalesLogger.logSale(ticket);
        return ticket;
    }

    @Override
    public boolean cancelTicket(String ticketId) {
        return tickets.removeIf(t -> t.getTicketId().equals(ticketId));
    }
}
