package reporting;

import ticketing.Schedule;
import java.util.*;
import java.time.LocalDateTime;

public class ScheduleLoader {
    public static Map<String, Schedule> loadSchedules() {
        Map<String, Schedule> map = new HashMap<>();
        map.put("SCH1", new Schedule("SCH1", "BOAT1", LocalDateTime.now().plusHours(2)));
        map.put("SCH2", new Schedule("SCH2", "BOAT1", LocalDateTime.now().plusHours(5)));
        return map;
    }
}
