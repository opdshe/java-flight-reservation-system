package application.flight.exception;

public class NoCorrespondFlightException extends RuntimeException {
    private static final String MESSAGE = "해당 경로와 일치하는 비행편이 없습니다. ";

    public NoCorrespondFlightException() {
        super(MESSAGE);
    }
}
