package application.view.screen;

import application.FunctionMapper;
import application.view.InputView;
import application.view.OutputView;

import static application.FunctionMapper.MAIN_FUNCTION_MAPPER;

public class MainScreen {
    private static final String SCREEN_NAME = "메인 화면";
    private static final String ACTIVITY_LIST = "1. 항공편 예약 기능\n" +
            "2. 마이 페이지 기능\n" +
            "3. 관리자 기능\n" +
            "Q. 종료";

    public static Runnable getFunction() {
        OutputView.printGuide(SCREEN_NAME);
        OutputView.print(ACTIVITY_LIST);
        String command = InputView.inputFunction();
        return FunctionMapper.matchFunction(MAIN_FUNCTION_MAPPER, command);
    }
}
