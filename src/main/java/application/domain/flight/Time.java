package application.domain.flight;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Time {
    private static final int MIN_DURATION = 48;

    private final LocalDateTime departure;
    private final LocalDateTime arrival;

    public Time(LocalDateTime departure, LocalDateTime arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public boolean isValidDuration(LocalDateTime departure, LocalDateTime arrival) {
        return getDuration(departure, arrival) > MIN_DURATION;
    }

    private int getDuration(LocalDateTime departure, LocalDateTime arrival) {
        if (this.departure.isAfter(departure)) {
            return (int) (this.departure.until(arrival, ChronoUnit.HOURS));
        }
        return (int) this.arrival.until(departure, ChronoUnit.HOURS);
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }
}
