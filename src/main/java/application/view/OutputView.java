package application.view;

import application.domain.flight.Flight;
import application.domain.user.Ticket;
import application.util.TimeConverter;

import java.util.List;

public class OutputView {
    private static final String RESULT_PREFIX = "[INFO] ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String GUIDE_PREFIX = "## ";
    private static final String CURRENT_BALANCE = "현재 잔고: ";
    private static final String DIVIDING_LINE = " | ";
    private static final String WON = "원";

    private OutputView() {
    }

    public static void printFlights(List<Flight> flights) {
        flights.forEach(flight -> printTicket(Ticket.of(flight)));
    }

    private static void printTicket(Ticket ticket) {
        System.out.println(ticket.getFlightID() + DIVIDING_LINE + ticket.getSource() + DIVIDING_LINE +
                ticket.getDest() + DIVIDING_LINE + TimeConverter.toString(ticket.getDeparture()) + DIVIDING_LINE +
                TimeConverter.toString(ticket.getArrival()));
    }

    public static void printBalance(int balance) {
        System.out.println(CURRENT_BALANCE + balance + WON);
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
