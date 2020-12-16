package application.flight.domain;

import application.flight.exception.NoCorrespondFlightException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlightRepository {
    private static List<Flight> flights = new ArrayList<>();

    static {
        City paris = new City("파리");
        City incheon = new City("인천");
        Airport parisAirport = new Airport(paris, "CGA");
        Airport incheonAirport = new Airport(incheon, "INC");
        Time time = new Time(LocalDateTime.of(2020, 12, 22, 12, 23),
                LocalDateTime.of(2020, 12, 25, 14, 33));
        flights.add(new Flight(324, new Route(parisAirport, incheonAirport), time, 2534443));
    }

    public static List<Flight> findAll() {
        return Collections.unmodifiableList(flights);
    }

    public static List<Flight> findByRoute(String source, String dest) {
        if (hasCorrespondRoute(source, dest)) {
            return flights.stream()
                    .filter(flight -> flight.isCorrespondRoute(source, dest))
                    .collect(Collectors.toList());
        }
        throw new NoCorrespondFlightException();
    }

    private static boolean hasCorrespondRoute(String source, String dest) {
        return flights.stream()
                .anyMatch(flight -> flight.isCorrespondRoute(source, dest));
    }
}
