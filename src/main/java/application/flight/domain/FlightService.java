package application.flight.domain;

import java.util.List;

public class FlightService {
    private FlightService() {
    }

    public static List<Flight> findAll() {
        return FlightRepository.findAll();
    }
}
