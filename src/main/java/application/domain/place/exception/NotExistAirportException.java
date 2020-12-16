package application.domain.place.exception;

public class NotExistAirportException extends RuntimeException {
    private static final String MESSAGE = "존재하지 않는 공항입니다. ";

    public NotExistAirportException() {
        super(MESSAGE);
    }
}
