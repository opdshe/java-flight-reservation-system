package application.view.screen.management;

import application.controller.ManagementController;
import application.view.InputView;
import application.view.OutputView;

public class AirportRegistrationScreen {
    private static final String INPUT_CITY = "등록할 공항의 도시 이름을 입력해 주세요. ";
    private static final String INPUT_REPRESENTATION = "등록할 공항의 축약어를 입력래 주세요. ";
    private static final String COMPLETE_REGISTRATION = "공항이 등록되었습니다. ";

    public static void interact() {
        String city = inputCity();
        String representation = inputRepresentation();
        ManagementController.addAirport(city, representation);
        OutputView.printlnResult(COMPLETE_REGISTRATION);
    }

    private static String inputCity() {
        OutputView.printGuide(INPUT_CITY);
        return InputView.readLine();
    }

    private static String inputRepresentation() {
        OutputView.printGuide(INPUT_REPRESENTATION);
        return InputView.readLine();
    }
}
