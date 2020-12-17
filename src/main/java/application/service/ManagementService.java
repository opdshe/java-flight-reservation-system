package application.service;

import application.domain.place.City;
import application.domain.place.CityRepository;
import application.domain.place.CityValidator;

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
}
