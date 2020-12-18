package application.view.screen.mypage;

import application.controller.UserController;

public class BalanceInquiryScreen {
    private static final String SCREEN_NAME = "잔금 조회 화면";

    public static void interact() {
        UserController.printBalance();
    }
}
