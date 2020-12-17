package application.controller;

import application.domain.user.User;
import application.service.UserService;
import application.view.OutputView;

public class UserController {
    private UserController() {
    }

    private static void buy(int flightId) {
        UserService.buy(flightId);
    }

    private static void cancel(int flightId) {
        UserService.cancel(flightId);
    }

    private static void deposit(int amount) {
        UserService.deposit(amount);
    }

    private static void printBalance() {
        OutputView.printBalance(User.getBalance());
    }
}
