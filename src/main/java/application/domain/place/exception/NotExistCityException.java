package application.domain.place.exception;

public class NotExistCityException extends RuntimeException {
    private static final String MESSAGE = "존재하지 않는 도시 입니다. ";

    public NotExistCityException() {
        super(MESSAGE);
    }
}
