package reporting;

import ticketing.Ticket;
import java.io.*;

public class SalesLogger {
    public static void logSale(Ticket ticket) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("sales.txt", true))) {
            bw.write("Ticket ID: " + ticket.getTicketId() + ", Customer: " + ticket.getCustomerName());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
