package application.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final String SELECT_FUNCTION = "원하는 기능을 선택해 주세요.";

    private InputView() {
    }

    public static String inputFunction() {
        OutputView.printGuide(SELECT_FUNCTION);
        return readLine();
    }

    public static String readLine() {
        return SCANNER.nextLine();
    }
}
