package application.domain.flight;

import application.domain.flight.exception.AlreadyExistFlightException;
import application.domain.user.Ticket;
import application.domain.user.TicketRepository;
import application.domain.user.User;
import application.domain.user.exception.NotAllowedDurationException;
import application.domain.user.exception.ShortOfMoneyException;

import java.util.List;

public class FlightValidator {
    private FlightValidator() {
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

    public static void validateRegistration(int flightId) {
        validateExistence(flightId);
    }

    private static void validateExistence(int flightId) {
        if (FlightRepository.isExist(flightId)) {
            throw new AlreadyExistFlightException();
        }
    }
}
