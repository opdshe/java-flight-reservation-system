package application.view.screen.management;

import application.FunctionMapper;
import application.view.InputView;
import application.view.OutputView;

public class ManagementScreen {
    private static final String SCREEN_NAME = "관리자 기능 화면";
    private static final String FUNCTION_LIST = "1. 도시 추가\n" +
            "2. 도시 삭제\n" +
            "3. 역 조회\n" +
            "B. 돌아가기";

    public static void interact() {
        OutputView.print(FUNCTION_LIST);
        String command = InputView.inputFunction();
        Runnable function = FunctionMapper.matchFunction(FunctionMapper.MANAGEMENT_FUNCTION_MAPPER, command);
        function.run();
    }
}
