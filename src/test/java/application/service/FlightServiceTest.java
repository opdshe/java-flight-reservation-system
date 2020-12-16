package application.service;

import application.domain.flight.Flight;
import application.domain.flight.FlightRepository;
import application.domain.flight.Route;
import application.domain.flight.Time;
import application.domain.place.Airport;
import application.domain.place.City;
import application.domain.user.domain.ticket.Ticket;
import application.domain.user.domain.ticket.TicketRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class FlightServiceTest {
    private static final int flightId = 111;
    private static Flight dummyFlight;

    @BeforeEach
    void setUp() {
        Airport incheonAirport = new Airport(new City("인천"), "ICN");
        Airport parisAirport = new Airport(new City("파리"), "CGA");
        Route route = new Route(incheonAirport, parisAirport);
        Time time = new Time(LocalDateTime.now().minusDays(1), LocalDateTime.now());
        dummyFlight = new Flight(flightId, route, time, 100000);

        FlightRepository.save(dummyFlight);
    }

    @AfterEach
    void clearUp() {
        TicketRepository.deleteAll();
        FlightRepository.deleteAll();
    }

    @Test
    void 항공편ID를_기반으로_항공편을_구매할_수_있다() {
        //given & when
        FlightService.reserve(flightId);
        Ticket ticketById = TicketRepository.findById(flightId);

        //then
        assertThat(ticketById.getFlightID()).isEqualTo(flightId);
    }
}