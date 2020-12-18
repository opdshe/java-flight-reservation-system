package application.view.screen.reservation;

import application.controller.FlightController;
import application.view.InputView;
import application.view.OutputView;

public class SpecifiedFlightInquiryScreen {
    private static final String INPUT_SOURCE = "출발 도시를 입력하세요.";
    private static final String INPUT_DEST = "도착 도시를 입력하세요.";

    public static void interact() {
        String source = inputSource();
        String dest = inputDest();
        FlightController.printByRoute(source, dest);
    }

    private static String inputSource() {
        OutputView.printGuide(INPUT_SOURCE);
        return InputView.readLine();
    }

    private static String inputDest() {
        OutputView.printGuide(INPUT_DEST);
        return InputView.readLine();
    }
}
