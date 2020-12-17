package application.service;

import application.domain.place.Airport;
import application.domain.place.AirportRepository;
import application.domain.place.City;
import application.domain.place.CityRepository;

public class ManagementService {
    private ManagementService() {
    }

    public static void addCity(String name) {
        City city = new City(name);
        CityRepository.save(city);
    }

    public static void deleteCity(String name) {
        City city = CityRepository.findByName(name);
        CityRepository.delete(city);
    }

    public static void addAirport(String cityName, String representation) {
        City city = CityRepository.findByName(cityName);
        Airport airport = new Airport(city, representation);
        AirportRepository.save(airport);
    }

    public static void deleteAirport(String representation) {
        Airport airport = AirportRepository.findByRepresentation(representation);
        AirportRepository.delete(airport);
    }
}
