package application.domain.user.exception;

public class NotExistTicketException extends RuntimeException {
    private static final String MESSAGE = "해당 티켓을 보유하고 있지 않습니다. ";

    public NotExistTicketException() {
        super(MESSAGE);
    }
}
