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
}
