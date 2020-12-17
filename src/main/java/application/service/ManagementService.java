package application.service;

import application.domain.place.*;

public class ManagementService {
    private ManagementService() {
    }

    public static void addCity(String name) {
        CityValidator.validateRegistration(name);
        City city = new City(name);
        CityRepository.save(city);
    }

    public static void deleteCity(String name) {
        City city = CityRepository.findByName(name);
        CityRepository.delete(city);
    }

    public static void addAirport(String cityName, String representation) {
        City city = CityRepository.findByName(cityName);
        AirportValidator.validateRegistration(representation);
        Airport airport = new Airport(city, representation);
        AirportRepository.save(airport);
    }
}
