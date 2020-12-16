package application.flight;

import application.flight.domain.Flight;
import application.flight.domain.FlightService;
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
}
