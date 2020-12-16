package application.view;

import application.domain.flight.Flight;
import application.domain.user.domain.ticket.Ticket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OutputView {
    private static final String TIME_PATTERN = "yyyy-MM-dd HH:mm";
    private static final String DIVIDING_LINE = " | ";

    private OutputView() {
    }

    public static void printFlights(List<Flight> flights) {
        flights.forEach(flight -> printTicket(Ticket.of(flight)));
    }

    private static void printTicket(Ticket ticket) {
        System.out.println(ticket.getFlightID() + DIVIDING_LINE + ticket.getSource() + DIVIDING_LINE +
                ticket.getDest() + DIVIDING_LINE + getFormattedTime(ticket.getDeparture()) + DIVIDING_LINE +
                getFormattedTime(ticket.getArrival()));
    }

    private static String getFormattedTime(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(TIME_PATTERN));
    }
}
