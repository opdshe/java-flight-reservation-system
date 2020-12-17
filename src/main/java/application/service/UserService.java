package application.service;

import application.domain.flight.Flight;
import application.domain.flight.FlightRepository;
import application.domain.user.ReservationValidator;
import application.domain.user.Ticket;
import application.domain.user.TicketRepository;
import application.domain.user.User;

public class UserService {
    public static void buy(int flightId) {
        Flight flight = FlightRepository.findById(flightId);
        ReservationValidator.validateReservation(flight);
        TicketRepository.save(Ticket.of(flight));
        User.buy(flight);
    }

    public static void cancel(int flightId) {
        Ticket ticket = TicketRepository.findById(flightId);
        TicketRepository.delete(ticket);
    }
}
