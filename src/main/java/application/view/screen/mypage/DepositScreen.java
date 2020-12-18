package application.view.screen.mypage;

import application.controller.UserController;
import application.view.InputView;
import application.view.OutputView;

public class DepositScreen {
    private static final String INPUT_AMOUNT = "입금할 금액을 입력하세요. ";
    private static final String COMPLETE_DEPOSIT = "입금이 완료되었습니다. ";

    public static void interact() {
        int amount = inputAmount();
        UserController.deposit(amount);
        OutputView.printlnResult(COMPLETE_DEPOSIT);
    }

    private static int inputAmount() {
        OutputView.printGuide(INPUT_AMOUNT);
        return Integer.parseInt(InputView.readLine());
    }
}
