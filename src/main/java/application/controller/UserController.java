package application.controller;

import application.service.UserService;

public class UserController {
    private UserController() {
    }

    private static void buy(int flightId) {
        UserService.buy(flightId);
    }

    private static void cancel(int flightId) {
        UserService.cancel(flightId);
    }
}
