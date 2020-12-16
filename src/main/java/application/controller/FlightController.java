package application.controller;

import application.domain.flight.Flight;
import application.service.FlightService;
import application.view.OutputView;

import java.util.List;

public class FlightController {
    private FlightController() {
    }

    public static void printAll() {
        List<Flight> flights = FlightService.findAll();
        OutputView.printFlights(flights);
    }

    public static void printByRoute(String source, String dest) {
        List<Flight> flights = FlightService.findByRoute(source, dest);
        OutputView.printFlights(flights);
    }

    public static void reserve(int flightId) {
        FlightService.reserve(flightId);
    }
}
