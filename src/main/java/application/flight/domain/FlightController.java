package application.flight.domain;

import application.view.OutputView;

import java.util.List;

public class FlightController {
    private FlightController() {
    }

    public static void print() {
        List<Flight> flights = FlightService.findAll();
        OutputView.printFlights(flights);
    }
}
