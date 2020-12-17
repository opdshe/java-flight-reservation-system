package application.service;

import application.domain.flight.Flight;
import application.domain.flight.FlightRepository;
import application.domain.flight.Route;
import application.domain.flight.Time;
import application.domain.flight.exception.NotExistFlightException;
import application.domain.place.Airport;
import application.domain.place.City;
import application.domain.user.Ticket;
import application.domain.user.TicketRepository;
import application.domain.user.User;
import application.domain.user.exception.NotAllowedDurationException;
import application.domain.user.exception.NotExistTicketException;
import application.domain.user.exception.ShortOfMoneyException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {
    private static final int flightId = 111;
    private static final int dummyFlightPrice = 100000;
    private static Flight dummyFlight;

    @BeforeEach
    void setUp() {
        Airport incheonAirport = new Airport(new City("인천"), "ICN");
        Airport parisAirport = new Airport(new City("파리"), "CGA");
        LocalDateTime departure = LocalDateTime.now().minusDays(1);
        LocalDateTime arrival = LocalDateTime.now();
        Route route = new Route(incheonAirport, parisAirport);
        Time time = new Time(departure, arrival);
        dummyFlight = new Flight(flightId, route, time, dummyFlightPrice);

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
        UserService.buy(flightId);
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
                .isThrownBy(() -> UserService.buy(notBeRegisteredId));
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
                .isThrownBy(() -> UserService.buy(999));
    }

    @Test
    void 항공편_구매시_금액만큼_잔고에서_돈이_출금되어야함() {
        //given
        int currentBalance = User.getBalance();
        int expectBalance = currentBalance - dummyFlightPrice;

        //when
        UserService.buy(flightId);

        //then
        assertThat(User.getBalance()).isEqualTo(expectBalance);
    }

    @Test
    void 내잔고를_초과하는_항공편은_살_수_없다() {
        //given
        int expensiveFlightId = 222;
        int expensiveFlightPrice = 2000000;
        Flight expensiveFlight = mock(Flight.class);
        FlightRepository.save(expensiveFlight);
        when(expensiveFlight.getFlightID()).thenReturn(expensiveFlightId);
        when(expensiveFlight.getPrice()).thenReturn(expensiveFlightPrice);

        //when & then
        assertThatExceptionOfType(ShortOfMoneyException.class)
                .isThrownBy(() -> UserService.buy(expensiveFlightId));
    }

    @Test
    void 내가_구매한_목록에서_취소한_항공편이_사라져야_함() {
        //given
        UserService.buy(flightId);

        //when
        UserService.cancel(flightId);

        //then
        assertThatExceptionOfType(NotExistTicketException.class)
                .isThrownBy(() -> TicketRepository.findById(flightId));
    }
}