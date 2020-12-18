package application.view.screen.reservation;

import application.controller.UserController;
import application.view.InputView;
import application.view.OutputView;

public class FlightReservationScreen {
    private static final String INPUT_FLIGHT_ID = "구매하려는 항공편의 ID를 입력해 주세요. ";
    private static final String COMPLETE_PURCHASE = "항공편을 구매하였습니다.";

    public static void interact() {
        int flightId = inputFlightId();
        UserController.buy(flightId);
        OutputView.printlnResult(COMPLETE_PURCHASE);
    }

    private static int inputFlightId() {
        OutputView.printGuide(INPUT_FLIGHT_ID);
        return Integer.parseInt(InputView.readLine());
    }
}
