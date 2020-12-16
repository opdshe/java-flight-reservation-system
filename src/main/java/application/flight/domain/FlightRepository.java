package application.flight.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightRepository {
    private static List<Flight> flights = new ArrayList<>();

    static {
        City paris = new City("PARIS");
        City incheon = new City("INCHON");
        Airport parisAirport = new Airport(paris, "CGA");
        Airport incheonAirport = new Airport(incheon, "INC");
        Time time = new Time(LocalDateTime.of(2020, 12, 22, 12, 23),
                LocalDateTime.of(2020, 12, 25, 14, 33));
        flights.add(new Flight(324, new Route(parisAirport, incheonAirport), time, 2534443));
    }

    public static List<Flight> findAll() {
        return Collections.unmodifiableList(flights);
    }
}
