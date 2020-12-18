package application.view.screen.mypage;

import application.controller.UserController;
import application.view.InputView;
import application.view.OutputView;

public class DepositScreen {
    private static final String SCREEN_NAME = "입금 기능 화면";
    private static final String INPUT_AMOUNT = "입금할 금액을 입력하세요. ";

    public static void interact() {
        int amount = inputAmount();
        UserController.deposit(amount);
    }

    private static int inputAmount() {
        OutputView.print(INPUT_AMOUNT);
        return Integer.parseInt(InputView.readLine());
    }
}
