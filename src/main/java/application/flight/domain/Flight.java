package application.flight.domain;

import java.time.LocalDateTime;

public class Flight {
    private final int flightID;
    private final Route route;
    private final Time time;
    private final int price;

    public Flight(int flightID, Route route, Time time, int price) {
        this.flightID = flightID;
        this.route = route;
        this.time = time;
        this.price = price;
    }

    public Ticket makeTicket() {
        String flightID = String.valueOf(this.flightID);
        String source = route.getSourceCity();
        String dest = route.getDestCity();
        LocalDateTime departure = time.getDeparture();
        LocalDateTime arrival = time.getArrival();
        return new Ticket(flightID, source, dest, departure, arrival);
    }
}