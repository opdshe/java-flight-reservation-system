package application.view.screen.management;

import application.controller.ManagementController;
import application.view.InputView;
import application.view.OutputView;

public class CityRegistrationScreen {
    private static final String INPUT_CITY_NAME = "도시 이름을 입력하세요. ";
    private static final String COMPLETE_REGISTRATION = "도시가 등록되었습니다. ";

    public static void interact() {
        String city = inputCityName();
        ManagementController.addCity(city);
        OutputView.printlnResult(COMPLETE_REGISTRATION);
    }

    private static String inputCityName() {
        OutputView.printGuide(INPUT_CITY_NAME);
        return InputView.readLine();
    }
}
