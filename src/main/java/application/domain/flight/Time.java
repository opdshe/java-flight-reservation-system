package application.domain.flight;

import java.time.LocalDateTime;

public class Time {
    private final LocalDateTime departure;
    private final LocalDateTime arrival;

    public Time(LocalDateTime departure, LocalDateTime arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }
}
