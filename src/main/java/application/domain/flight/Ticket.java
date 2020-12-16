package application.domain.flight;

import java.time.LocalDateTime;

public class Ticket {
    private final String flightID;
    private final String source;
    private final String dest;
    private final LocalDateTime departure;
    private final LocalDateTime arrival;

    private Ticket(String flightID, String source, String dest, LocalDateTime departure, LocalDateTime arrival) {
        this.flightID = flightID;
        this.source = source;
        this.dest = dest;
        this.departure = departure;
        this.arrival = arrival;
    }

    public static Ticket of(Flight flight) {
        String flightID = String.valueOf(flight.getFlightID());
        String source = flight.getRoute().getSourceCity();
        String dest = flight.getRoute().getDestCity();
        LocalDateTime departure = flight.getTime().getDeparture();
        LocalDateTime arrival = flight.getTime().getArrival();
        return new Ticket(flightID, source, dest, departure, arrival);
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
