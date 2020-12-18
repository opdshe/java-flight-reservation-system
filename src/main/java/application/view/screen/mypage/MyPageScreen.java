package application.view.screen.mypage;

import application.FunctionMapper;
import application.view.InputView;
import application.view.OutputView;

import static application.FunctionMapper.MY_PAGE_FUNCTION_MAPPER;

public class MyPageScreen {
    private static final String SCREEN_NAME = "마이 페이지 화면";
    private static final String FUNCTION_LIST = "1. 항공편 취소\n" +
            "2. 잔금 조회\n" +
            "3. 입금 기능\n" +
            "B. 뒤로 가기\n";

    public static void interact() {
        OutputView.print(FUNCTION_LIST);
        String command = InputView.inputFunction();
        Runnable function = FunctionMapper.matchFunction(MY_PAGE_FUNCTION_MAPPER, command);
        function.run();
    }
}
