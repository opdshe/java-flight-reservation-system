package application.domain.place.exception;

public class AlreadyExistAirportException extends RuntimeException {
    private static final String MESSAGE = "이미 존재하는 공항입니다.";

    public AlreadyExistAirportException() {
        super(MESSAGE);
    }
}
