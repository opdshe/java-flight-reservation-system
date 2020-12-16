package application.domain.flight;

import application.domain.user.domain.ticket.Ticket;
import application.domain.user.domain.ticket.TicketRepository;
import application.domain.user.domain.ticket.exception.NotAllowedDurationException;

import java.util.List;

public class FlightValidator {
    private FlightValidator() {
    }

    public static void validateReservation(Flight flight) {
        validateDuration(flight);
    }

    private static void validateDuration(Flight flight) {
        if (!isValidDuration(flight)) {
            throw new NotAllowedDurationException();
        }
    }

    private static boolean isValidDuration(Flight flight) {
        List<Ticket> tickets = TicketRepository.findAll();
        return tickets.stream()
                .allMatch(ticket -> flight.isValidFlight(ticket.getDeparture(), ticket.getArrival()));
    }
}
