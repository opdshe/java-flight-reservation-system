package application.domain.flight;

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

    public boolean isCorrespondRoute(String source, String dest) {
        return route.isCorrespondRoute(source, dest);
    }

    public boolean isValidFlight(LocalDateTime departure, LocalDateTime arrival) {
        return time.isValidDuration(departure, arrival);
    }

    public int getFlightID() {
        return flightID;
    }

    public Route getRoute() {
        return route;
    }

    public Time getTime() {
        return time;
    }

    public int getPrice() {
        return price;
    }
}
