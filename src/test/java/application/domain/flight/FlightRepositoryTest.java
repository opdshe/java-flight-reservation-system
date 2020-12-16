package application.domain.flight;

import application.domain.flight.exception.NoCorrespondFlightException;
import application.domain.place.Airport;
import application.domain.place.City;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class FlightRepositoryTest {
    @AfterEach
    void clearUp() {
        FlightRepository.deleteAll();
    }

    @Test
    void 항공편_저장소에서_항공편을_추가할_수_있다() {
        //given
        Airport incheonAirport = new Airport(new City("인천"), "ICN");
        Airport parisAirport = new Airport(new City("파리"), "CGA");
        Route route = new Route(incheonAirport, parisAirport);
        Time time = new Time(LocalDateTime.now().minusDays(1), LocalDateTime.now());
        Flight flight = new Flight(232, route, time, 100000);

        //when
        FlightRepository.save(flight);
        boolean hasContain = FlightRepository.findByRoute("인천", "파리")
                .contains(flight);

        //then
        assertThat(hasContain).isTrue();
    }

    @Test
    void 경로_조회시_조건에맞는_항공편_없으면_예외_발생() {
        //given
        String source = "등록안된지역1";
        String dest = "등록안된지역2";

        //when & then
        assertThatExceptionOfType(NoCorrespondFlightException.class)
                .isThrownBy(() -> FlightRepository.findByRoute(source, dest));
    }
}