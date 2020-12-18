package application.view.screen.management;

import application.controller.ManagementController;
import application.view.InputView;
import application.view.OutputView;

public class CityRemovalScreen {
    private static final String INPUT_CITY_NAME = "삭제할 도시 이름을 입력하세요.";
    private static final String COMPLETE_REMOVAL = "도시가 삭제되었습니다. ";

    public static void interact() {
        String cityName = inputCityName();
        ManagementController.deleteCity(cityName);
        OutputView.printlnResult(COMPLETE_REMOVAL);
    }

    private static String inputCityName() {
        OutputView.printGuide(INPUT_CITY_NAME);
        return InputView.readLine();
    }
}
