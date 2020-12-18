package application.view.screen.reservation;

import application.FunctionMapper;
import application.view.InputView;
import application.view.OutputView;

import static application.FunctionMapper.RESERVATION_FUNCTION_MAPPER;

public class ReservationScreen {
    private static final String SCREEN_NAME = "항공편 예약 화면";
    private static final String FUNCTION_LIST = "1. 모든 항공편 조회\n" +
            "2. 여행 경로를 통한 항공편 조회\n" +
            "3. 항공편 구매" +
            "B. 뒤로 가기\n";

    public static void interact() {
        OutputView.print(FUNCTION_LIST);
        String command = InputView.inputFunction();
        Runnable function = FunctionMapper.matchFunction(RESERVATION_FUNCTION_MAPPER, command);
        function.run();
    }
}
