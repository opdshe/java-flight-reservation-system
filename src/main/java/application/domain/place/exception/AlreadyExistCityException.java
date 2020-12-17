package application.domain.place.exception;

public class AlreadyExistCityException extends RuntimeException {
    private static final String MESSAGE = "이미 존재하는 도시입니다. ";

    public AlreadyExistCityException() {
        super(MESSAGE);
    }
}
