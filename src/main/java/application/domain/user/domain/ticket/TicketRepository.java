package application.domain.user.domain.ticket;

import application.domain.user.domain.ticket.exception.NotExistTicketException;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    private static final List<Ticket> tickets = new ArrayList<>();

    public static void save(Ticket ticket) {
        tickets.add(ticket);
    }

    public static Ticket findById(int flightID) {
        return tickets.stream()
                .filter(ticket -> ticket.getFlightID() == flightID)
                .findAny()
                .orElseThrow(NotExistTicketException::new);
    }

    public static void deleteAll() {
        tickets.clear();
    }
}
