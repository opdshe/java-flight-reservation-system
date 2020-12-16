package application.domain.place;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AirportRepositoryTest {
    @Test
    void 공항_등록_동작_확인() {
        //given
        String representation = "ICN";
        City city = new City("인천");
        Airport airport = new Airport(city, representation);

        //when
        AirportRepository.save(airport);

        //then
        Airport registeredAirport = AirportRepository.findByRepresentation(representation);
        assertThat(registeredAirport).isEqualTo(airport);
    }
}