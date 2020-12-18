package application.view.screen.management;

import application.controller.ManagementController;
import application.view.InputView;
import application.view.OutputView;

public class CityRemovalScreen {
    private static final String INPUT_CITY_NAME = "삭제할 도시 이름을 입력하세요.";

    public static void interact() {
        String cityName = inputCityName();
        ManagementController.deleteCity(cityName);
    }

    private static String inputCityName() {
        OutputView.print(INPUT_CITY_NAME);
        return InputView.readLine();
    }
}
