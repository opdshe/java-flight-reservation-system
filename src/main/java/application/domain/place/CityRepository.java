package application.domain.place;

import application.domain.place.exception.NotExistCityException;

import java.util.ArrayList;
import java.util.List;

public class CityRepository {
    private static final List<City> cities = new ArrayList<>();

    public static void save(City city) {
        cities.add(city);
    }

    public static City findByName(String name) {
        return cities.stream()
                .filter(city -> city.getName().equals(name))
                .findAny()
                .orElseThrow(NotExistCityException::new);
    }
}