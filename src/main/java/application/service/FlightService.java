package application.service;

import application.domain.flight.Flight;
import application.domain.flight.FlightRepository;

import java.util.List;

public class FlightService {
    private FlightService() {
    }

    public static List<Flight> findAll() {
        return FlightRepository.findAll();
    }

    public static List<Flight> findByRoute(String source, String dest) {
        return FlightRepository.findByRoute(source, dest);
    }
}
