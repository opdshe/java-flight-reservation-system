package application.domain.user;

import application.domain.flight.Flight;
import application.domain.user.exception.NotAllowedDurationException;
import application.domain.user.exception.ShortOfMoneyException;

import java.util.List;

public class ReservationValidator {
    private ReservationValidator() {
    }

    public static void validateReservation(Flight flight) {
        validateDuration(flight);
        validateBalance(flight);
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

    private static void validateBalance(Flight flight) {
        if (!User.hasEnoughMoney(flight)) {
            throw new ShortOfMoneyException();
        }
    }
}
