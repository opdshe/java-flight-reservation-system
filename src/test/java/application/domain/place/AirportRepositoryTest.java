package application.domain.place;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AirportRepositoryTest {
    @AfterEach
    void clearUp() {
        AirportRepository.deleteAll();
    }

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

    @Test
    void 공항저장소에서_공항을_삭제할_수_있다() {
        //gvien
        String representation = "ICN";
        City city = new City("인천");
        Airport airport = new Airport(city, representation);

        AirportRepository.save(airport);

        //when
        AirportRepository.delete(airport);
        boolean isExist = AirportRepository.isExist(representation);

        //then
        assertThat(isExist).isFalse();
    }
}