package application.service;

import application.domain.flight.Flight;
import application.domain.flight.FlightRepository;
import application.domain.flight.FlightValidator;
import application.domain.user.domain.ticket.Ticket;
import application.domain.user.domain.ticket.TicketRepository;

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

    public static void reserve(int flightId) {
        Flight flight = FlightRepository.findById(flightId);
        FlightValidator.validateReservation(flight);
        TicketRepository.save(Ticket.of(flight));
    }
}
