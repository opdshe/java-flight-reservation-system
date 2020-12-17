package application.domain.flight.exception;

public class AlreadyExistFlightException extends RuntimeException {
    private static final String MESSAGE = "이미 등록된 항공편 입니다. ";

    public AlreadyExistFlightException() {
        super(MESSAGE);
    }
}
