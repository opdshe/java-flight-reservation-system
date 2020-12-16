package application.domain.user.domain.ticket.exception;

public class NotAllowedDurationException extends RuntimeException {
    private static final String MESSAGE = "구매한 티켓 목록에 구매하려는 티켓과의 시간차가 48간이내인 티켓이 존재하면 구매할 수 없습니다. ";

    public NotAllowedDurationException() {
        super(MESSAGE);
    }
}
