package application;

import application.view.OutputView;
import application.view.screen.MainScreen;

public class Application {
    public static void main(String[] args) {
        executeApplication();
    }

    private static void executeApplication() {
        DataInitializer.initialize();
        do {
            executeFunction();
        } while (Status.isContinue());
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
