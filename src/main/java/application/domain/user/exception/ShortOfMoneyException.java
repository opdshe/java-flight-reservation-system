package application.domain.user.exception;

public class ShortOfMoneyException extends RuntimeException {
    private static final String MESSAGE = "잔고에 남은 돈보다 티켓의 가격이 높습니다. ";

    public ShortOfMoneyException() {
        super(MESSAGE);
    }
}
