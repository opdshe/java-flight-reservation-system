package application.flight.domain;

import java.time.LocalDateTime;

public class Ticket {
    private final String flightID;
    private final String source;
    private final String dest;
    private final LocalDateTime departure;
    private final LocalDateTime arrival;

    public Ticket(String flightID, String source, String dest, LocalDateTime departure, LocalDateTime arrival) {
        this.flightID = flightID;
        this.source = source;
        this.dest = dest;
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getFlightID() {
        return flightID;
    }

    public String getSource() {
        return source;
    }

    public String getDest() {
        return dest;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }
}
