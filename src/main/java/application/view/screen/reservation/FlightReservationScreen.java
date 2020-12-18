package application.view.screen.reservation;

import application.controller.UserController;
import application.view.InputView;
import application.view.OutputView;

public class FlightReservationScreen {
    private static final String INPUT_FLIGHT_ID = "구매하려는 항공편의 ID를 입력해 주세요. ";

    public static void interact() {
        int flightId = inputFlightId();
        UserController.buy(flightId);
    }

    private static int inputFlightId() {
        OutputView.print(INPUT_FLIGHT_ID);
        return Integer.parseInt(InputView.readLine());
    }
}
