package application.domain.place;

import application.domain.place.exception.NotExistCityException;

import java.util.ArrayList;
import java.util.List;

public class CityRepository {
    private static final List<City> cities = new ArrayList<>();

    public static void save(City city) {
        cities.add(city);
    }

    public static void saveAll(List<City> cities) {
        cities.forEach(CityRepository::save);
    }

    public static void delete(City city) {
        cities.remove(city);
    }

    public static City findByName(String name) {
        return cities.stream()
                .filter(city -> city.getName().equals(name))
                .findAny()
                .orElseThrow(NotExistCityException::new);
    }

    public static boolean isExist(String name) {
        return cities.stream()
                .anyMatch(city -> city.getName().equals(name));
    }

    public static void deleteAll() {
        cities.clear();
    }
}
