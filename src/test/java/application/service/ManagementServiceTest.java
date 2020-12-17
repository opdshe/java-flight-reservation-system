package application.service;

import application.domain.place.City;
import application.domain.place.CityRepository;
import application.domain.place.exception.AlreadyExistCityException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ManagementServiceTest {
    @AfterEach
    void clearUp() {
        CityRepository.deleteAll();
    }

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

    @Test
    void 이미_존재하는_공항이면_예외_발생() {
        //given
        String registeredCity = "런던";
        ManagementService.addCity(registeredCity);

        String duplicatedCity = "런던";

        //when & then
        assertThatExceptionOfType(AlreadyExistCityException.class)
                .isThrownBy(() -> ManagementService.addCity(duplicatedCity));
    }

    @Test
    void 사용자가_입력한_도시를_삭제할_수_있다() {
        //given
        String cityName = "런던";
        ManagementService.addCity(cityName);

        //when
        ManagementService.deleteCity(cityName);
        boolean isExist = CityRepository.isExist(cityName);

        //then
        assertThat(isExist).isFalse();
    }
}