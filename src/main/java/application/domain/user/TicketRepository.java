package application.domain.user;

import application.domain.user.exception.NotExistTicketException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketRepository {
    private static final List<Ticket> tickets = new ArrayList<>();

    public static List<Ticket> findAll() {
        return Collections.unmodifiableList(tickets);
    }

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
