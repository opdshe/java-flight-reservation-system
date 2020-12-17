package application.service;

import application.domain.flight.FlightRepository;
import application.domain.flight.exception.AlreadyExistFlightException;
import application.domain.place.Airport;
import application.domain.place.AirportRepository;
import application.domain.place.City;
import application.domain.place.CityRepository;
import application.domain.place.exception.AlreadyExistAirportException;
import application.domain.place.exception.AlreadyExistCityException;
import application.domain.place.exception.NotExistAirportException;
import application.domain.place.exception.NotExistCityException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ManagementServiceTest {
    @BeforeEach
    void setUp() {
        City departureCity = new City("인천");
        City arrivalCity = new City("파리");
        Airport departureAirport = new Airport(departureCity, "ICN");
        Airport arrivalAirport = new Airport(arrivalCity, "CGA");

        CityRepository.save(departureCity);
        CityRepository.save(arrivalCity);
        AirportRepository.save(departureAirport);
        AirportRepository.save(arrivalAirport);
    }

    @AfterEach
    void clearUp() {
        CityRepository.deleteAll();
        AirportRepository.deleteAll();
        FlightRepository.deleteAll();
    }

    @Test
    void 사용자가_입력한_도시를_추가할_수_있다() {
        //given
        String cityName = "런던";

        //when
        ManagementService.addCity(cityName);
        City findByName = CityRepository.findByName(cityName);

        //then
        assertThat(findByName).isNotNull();
    }

    @Test
    void 이미_존재하는_도시이면_예외_발생() {
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

    @Test
    void 도시_삭제시_존재하지_않는_도시는_예외_발생() {
        //given
        String notRegisteredCity = "대구";

        //when & then
        assertThatExceptionOfType(NotExistCityException.class)
                .isThrownBy(() -> ManagementService.deleteCity(notRegisteredCity));
    }

    @Test
    void 사용자가_입력한_공항을_추가할_수_있다() {
        //given
        String cityName = "부산";
        String representation = "PUS";

        CityRepository.save(new City(cityName));

        //when
        ManagementService.addAirport(cityName, representation);
        boolean isExist = AirportRepository.isExist(representation);

        //then
        assertThat(isExist).isTrue();
    }

    @Test
    void 공항등록시_이미_존재하는_공항이면_예외_발생() {
        //given
        String cityName = "인천";
        String duplicatedRepresentation = "ICN";

        //when & then
        assertThatExceptionOfType(AlreadyExistAirportException.class)
                .isThrownBy(() -> ManagementService.addAirport(cityName, duplicatedRepresentation));
    }

    @Test
    void 축약어_기반으로_공항을_삭제할_수_있다() {
        //given
        String registeredAirport = "ICN";

        //when
        ManagementService.deleteAirport(registeredAirport);
        boolean isExist = AirportRepository.isExist(registeredAirport);

        //then
        assertThat(isExist).isFalse();
    }

    @Test
    void 존재하지_않는_공항이면_예외_발생() {
        //given
        String airportName = "존재하지않는공항";

        //when & then
        assertThatExceptionOfType(NotExistAirportException.class)
                .isThrownBy(() -> ManagementService.deleteAirport(airportName));
    }

    @Test
    void 사용자가_입력한_값을_기반으로_항공편을_추가할_수_있다() {
        //given
        int flightId = 333;
        String departureRepresentation = "ICN";
        String arrivalRepresentation = "CGA";
        String departureTime = "2020-08-22 08:22";
        String arrivalTime = "2020-08-24 03:20";
        int price = 100000;

        //when
        ManagementService.addFlight(flightId, departureRepresentation, arrivalRepresentation, departureTime,
                arrivalTime, price);
        boolean isExist = FlightRepository.isExist(flightId);

        //then
        assertThat(isExist).isTrue();
    }

    @Test
    void 이미_존재하는_항공편이면_예외_발생해야함() {
        //given
        int flightId = 333;
        String departureRepresentation = "ICN";
        String arrivalRepresentation = "CGA";
        String departureTime = "2020-08-22 08:22";
        String arrivalTime = "2020-08-24 03:20";
        int price = 100000;

        ManagementService.addFlight(flightId, departureRepresentation, arrivalRepresentation, departureTime,
                arrivalTime, price);

        //when & then
        assertThatExceptionOfType(AlreadyExistFlightException.class)
                .isThrownBy(() -> ManagementService.addFlight(flightId, departureRepresentation, arrivalRepresentation,
                        departureTime, arrivalTime, price));
    }
}