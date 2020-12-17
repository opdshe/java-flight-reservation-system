package application.domain.place;

import application.domain.place.exception.AlreadyExistCityException;

public class CityValidator {
    private CityValidator() {
    }

    public static void validateRegistration(String name) {
        validateExistence(name);
    }

    private static void validateExistence(String name) {
        if (CityRepository.isExist(name)) {
            throw new AlreadyExistCityException();
        }
    }
}
