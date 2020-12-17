package application.service;

import application.domain.place.City;
import application.domain.place.CityRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ManagementServiceTest {
    @Test
    void 사용자가_입력한_공항을_추가할_수_있다() {
        //given
        String cityName = "런던";

        //when
        ManagementService.addCity(cityName);
        City findByName = CityRepository.findByName(cityName);

        //then
        assertThat(findByName).isNotNull();
    }
}