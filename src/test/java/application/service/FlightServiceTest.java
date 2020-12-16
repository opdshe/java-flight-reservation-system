package application.service;

import application.domain.flight.Flight;
import application.domain.flight.FlightRepository;
import application.domain.flight.Route;
import application.domain.flight.Time;
import application.domain.flight.exception.NotExistFlightException;
import application.domain.place.Airport;
import application.domain.place.City;
import application.domain.user.domain.ticket.Ticket;
import application.domain.user.domain.ticket.TicketRepository;
import application.domain.user.domain.ticket.exception.NotAllowedDurationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FlightServiceTest {
    private static final int flightId = 111;
    private static Flight dummyFlight;

    @BeforeEach
    void setUp() {
        Airport incheonAirport = new Airport(new City("인천"), "ICN");
        Airport parisAirport = new Airport(new City("파리"), "CGA");
        LocalDateTime departure = LocalDateTime.now().minusDays(1);
        LocalDateTime arrival = LocalDateTime.now();
        Route route = new Route(incheonAirport, parisAirport);
        Time time = new Time(departure, arrival);
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

    @Test
    void 일치하는_항공편이_없으면_예외_발생해야_한다() {
        //given
        int notBeRegisteredId = 999;

        //when & then
        assertThatExceptionOfType(NotExistFlightException.class)
                .isThrownBy(() -> FlightService.reserve(notBeRegisteredId));
    }

    @Test
    void 내가_구매한_항공편의_도착시간과의_시간차이가_48시간_이하인_티켓은_구매할_수_없다() {
        //given
        TicketRepository.save(Ticket.of(dummyFlight));

        Flight invalidFlight = mock(Flight.class);
        LocalDateTime departure = LocalDateTime.now().minusDays(3);
        LocalDateTime arrival = LocalDateTime.now().minusDays(2);
        Time time = new Time(departure, arrival);
        when(invalidFlight.getFlightID()).thenReturn(999);
        when(invalidFlight.getTime()).thenReturn(time);

        FlightRepository.save(invalidFlight);

        //whe & then
        assertThatExceptionOfType(NotAllowedDurationException.class)
                .isThrownBy(() -> FlightService.reserve(999));
    }
}