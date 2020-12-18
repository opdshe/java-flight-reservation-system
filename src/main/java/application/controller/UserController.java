package application.controller;

import application.domain.user.User;
import application.service.UserService;
import application.view.OutputView;

public class UserController {
    private UserController() {
    }

    public static void buy(int flightId) {
        UserService.buy(flightId);
    }

    public static void cancel(int flightId) {
        UserService.cancel(flightId);
    }

    public static void deposit(int amount) {
        UserService.deposit(amount);
    }

    public static void printBalance() {
        OutputView.printBalance(User.getBalance());
    }
}
