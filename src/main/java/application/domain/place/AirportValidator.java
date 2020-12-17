package application.domain.place;

import application.domain.place.exception.AlreadyExistAirportException;

public class AirportValidator {
    private AirportValidator() {
    }

    public static void validateRegistration(String representation) {
        validateExistence(representation);
    }

    private static void validateExistence(String representation) {
        if (AirportRepository.isExist(representation)) {
            throw new AlreadyExistAirportException();
        }
    }
}
