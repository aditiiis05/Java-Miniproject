package ticketing;

import java.time.LocalDateTime;

public class Schedule {
    private String scheduleId;
    private String boatId;
    private LocalDateTime time;
    private int bookedSeats = 0;

    public Schedule(String scheduleId, String boatId, LocalDateTime time) {
        this.scheduleId = scheduleId;
        this.boatId = boatId;
        this.time = time;
    }

    public String getScheduleId() { return scheduleId; }
    public String getBoatId() { return boatId; }
    public LocalDateTime getTime() { return time; }
    public int getBookedSeats() { return bookedSeats; }

    public void bookSeat() { bookedSeats++; }
    public void cancelSeat() { bookedSeats--; }
}
