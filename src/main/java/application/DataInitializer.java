package application;

import application.domain.flight.Flight;
import application.domain.flight.FlightRepository;
import application.domain.place.Airport;
import application.domain.place.AirportRepository;
import application.domain.place.City;
import application.domain.place.CityRepository;

import java.util.Arrays;
import java.util.List;

public class DataInitializer {
    private DataInitializer() {
    }

    public static void initialize() {
        City pairs = new City("파리");
        City incheon = new City("인천");
        City london = new City("런던");
        City busan = new City("부산");
        City daegu = new City("대구");
        City roma = new City("로미");

        List<City> cities = Arrays.asList(pairs, incheon, london, busan, daegu, roma);
        CityRepository.saveAll(cities);

        Airport CGA = new Airport(pairs, "CGA");
        Airport INS = new Airport(incheon, "ICN");
        Airport LDN = new Airport(london, "LDN");
        Airport BSN = new Airport(busan, "BSN");
        Airport DGU = new Airport(daegu, "DGU");
        Airport RMA = new Airport(roma, "RMA");

        List<Airport> airports = Arrays.asList(CGA, INS, LDN, BSN, DGU, RMA);
        AirportRepository.saveAll(airports);

        Flight flight1 = Flight.of(444, "ICN", "CGA",
                "2020-12-20 13:20", "2020-12-20 15:30", 200000);
        Flight flight2 = Flight.of(555, "ICN", "LDN",
                "2020-12-23 10:20", "2020-12-24 03:30", 400000);
        Flight flight3 = Flight.of(666, "LDN", "DGU",
                "2020-12-25 07:10", "2020-12-26 15:30", 300000);
        Flight flight4 = Flight.of(343, "RMA", "CGA",
                "2021-01-01 11:20", "2021-01-02 08:30", 200000);
        List<Flight> flights = Arrays.asList(flight1, flight2, flight3, flight4);
        FlightRepository.saveAll(flights);
    }
}
