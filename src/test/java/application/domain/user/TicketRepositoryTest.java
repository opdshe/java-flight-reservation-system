package application.domain.user;

import application.domain.flight.Flight;
import application.domain.flight.Route;
import application.domain.flight.Time;
import application.domain.place.Airport;
import application.domain.place.City;
import application.domain.user.exception.NotExistTicketException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class TicketRepositoryTest {
    @Test
    void 티켓저장소에_티켓을_추가할_수_있다() {
        //given
        Airport incheonAirport = new Airport(new City("인천"), "ICN");
        Airport parisAirport = new Airport(new City("파리"), "CGA");
        Route route = new Route(incheonAirport, parisAirport);
        Time time = new Time(LocalDateTime.now().minusDays(1), LocalDateTime.now());
        Flight flight = new Flight(232, route, time, 100000);
        Ticket ticket = Ticket.of(flight);

        //when
        TicketRepository.save(ticket);
        Ticket findById = TicketRepository.findById(232);

        //then
        assertThat(findById).isEqualTo(ticket);
    }

    @Test
    void 구매목록에_없는_티켓ID_입력시_예외발생해야함() {
        //given
        int notRegisteredId = 111;

        //when & then
        assertThatExceptionOfType(NotExistTicketException.class)
                .isThrownBy(() -> TicketRepository.findById(notRegisteredId));
    }
}