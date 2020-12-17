package application.domain.user;

import application.domain.flight.Flight;

public class User {
    private static final int INITIAL_BALANCE = 1000000;
    private static int balance = INITIAL_BALANCE;

    public static void buy(Flight flight) {
        balance -= flight.getPrice();
    }

    public static boolean hasEnoughMoney(Flight flight) {
        return balance >= flight.getPrice();
    }

    public static int getBalance() {
        return balance;
    }
}
