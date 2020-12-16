package application.domain.flight.exception;

public class NotExistFlightException extends RuntimeException {
    private static final String MESSAGE = "해당 ID와 일치하는 항공권이 존재하지 않습니다. ";

    public NotExistFlightException() {
        super(MESSAGE);
    }
}
