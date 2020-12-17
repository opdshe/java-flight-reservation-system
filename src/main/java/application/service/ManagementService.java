package application.service;

import application.domain.place.City;
import application.domain.place.CityRepository;

public class ManagementService {
    private ManagementService() {
    }

    public static void addCity(String name) {
        City city = new City(name);
        CityRepository.save(city);
    }
}
