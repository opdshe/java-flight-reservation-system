package application.domain.flight;

import application.domain.flight.exception.NoCorrespondFlightException;
import application.domain.flight.exception.NotExistFlightException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlightRepository {
    private static List<Flight> flights = new ArrayList<>();

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

    public static Flight findById(int flightId) {
        return flights.stream()
                .filter(flight -> flight.getFlightID() == flightId)
                .findAny()
                .orElseThrow(NotExistFlightException::new);
    }

    private static boolean hasCorrespondRoute(String source, String dest) {
        return flights.stream()
                .anyMatch(flight -> flight.isCorrespondRoute(source, dest));
    }

    public static void save(Flight flight) {
        flights.add(flight);
    }

    public static void deleteAll() {
        flights.clear();
    }
}
