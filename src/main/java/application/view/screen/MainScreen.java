package application.view.screen;

import application.FunctionMapper;
import application.view.InputView;
import application.view.OutputView;

import static application.FunctionMapper.MAIN_FUNCTION_MAPPER;

public class MainScreen {
    private static final String SELECT_ACTIVITY = "원하는 활동을 선택해주세요. ";
    private static final String ACTIVITY_LIST = "메인 화면\n" +
            "1. 항공편 예약 기능\n" +
            "2. 마이 페이지 기능\n" +
            "3. 관리자 기능\n" +
            "Q. 종료";

    public static Runnable getFunction() {
        OutputView.print(ACTIVITY_LIST);
        String command = inputActivity();
        return FunctionMapper.matchFunction(MAIN_FUNCTION_MAPPER, command);
    }

    private static String inputActivity() {
        OutputView.print(SELECT_ACTIVITY);
        return InputView.readLine();
    }
}
