package application.view.screen.mypage;

import application.controller.UserController;
import application.view.InputView;
import application.view.OutputView;

public class TicketCancelScreen {
    private static final String INPUT_FLIGHT_ID = "취소할 티켓의 항공편 ID를 입력하세요. ";
    private static final String COMPLETE_CANCELLATION = "항공편을 취소했습니다. ";

    public static void interact() {
        int flightId = inputFlightId();
        UserController.cancel(flightId);
        OutputView.printlnResult(COMPLETE_CANCELLATION);
    }

    private static int inputFlightId() {
        OutputView.print(INPUT_FLIGHT_ID);
        return Integer.parseInt(InputView.readLine());
    }
}
