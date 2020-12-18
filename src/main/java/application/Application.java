package application;

import application.view.OutputView;
import application.view.screen.MainScreen;

public class Application {
    public static void main(String[] args) {
        executeFunction();
    }

    private static void executeFunction() {
        try {
            Runnable function = MainScreen.getFunction();
            function.run();
        } catch (RuntimeException exception) {
            OutputView.print(exception.getMessage());
        }
    }
}
