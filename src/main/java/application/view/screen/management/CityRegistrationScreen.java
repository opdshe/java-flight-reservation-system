package application.view.screen.management;

import application.controller.ManagementController;
import application.view.InputView;
import application.view.OutputView;

public class CityRegistrationScreen {
    private static final String INPUT_CITY_NAME = "도시 이름을 입력하세요. ";

    public static void interact() {
        String city = inputCityName();
        ManagementController.addCity(city);
    }

    private static String inputCityName() {
        OutputView.print(INPUT_CITY_NAME);
        return InputView.readLine();
    }
}
