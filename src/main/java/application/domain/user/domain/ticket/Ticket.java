package application.domain.user.domain.ticket;

import application.domain.flight.Flight;

import java.time.LocalDateTime;

public class Ticket {
    private final int flightID;
    private final String source;
    private final String dest;
    private final LocalDateTime departure;
    private final LocalDateTime arrival;
    private final int price;

    private Ticket(int flightID, String source, String dest, LocalDateTime departure,
                   LocalDateTime arrival, int price) {
        this.flightID = flightID;
        this.source = source;
        this.dest = dest;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public static Ticket of(Flight flight) {
        int flightID = flight.getFlightID();
        String source = flight.getRoute().getSourceCity();
        String dest = flight.getRoute().getDestCity();
        LocalDateTime departure = flight.getTime().getDeparture();
        LocalDateTime arrival = flight.getTime().getArrival();
        int price = flight.getPrice();
        return new Ticket(flightID, source, dest, departure, arrival, price);
    }

    public int getFlightID() {
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
