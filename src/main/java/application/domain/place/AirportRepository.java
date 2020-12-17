package application.domain.place;

import application.domain.place.exception.NotExistAirportException;

import java.util.ArrayList;
import java.util.List;

public class AirportRepository {
    private static final List<Airport> airports = new ArrayList<>();

    public static void save(Airport airport) {
        airports.add(airport);
    }

    public static Airport findByRepresentation(String representation) {
        return airports.stream()
                .filter(airport -> airport.getRepresentation().equals(representation))
                .findAny()
                .orElseThrow(NotExistAirportException::new);
    }

    public static boolean isExist(String representation) {
        return airports.stream()
                .anyMatch(airport -> airport.getRepresentation().equals(representation));
    }
}
