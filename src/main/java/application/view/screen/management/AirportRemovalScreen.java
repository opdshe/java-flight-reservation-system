package application.view.screen.management;

import application.controller.ManagementController;
import application.view.InputView;
import application.view.OutputView;

public class AirportRemovalScreen {
    private static final String INPUT_REPRESENTATION = "삭제할 공항의 축약어를 입력래 주세요. ";
    private static final String COMPLETE_REMOVAL = "공항이 삭제되었습니다. ";

    public static void interact() {
        String representation = inputRepresentation();
        ManagementController.deleteAirport(representation);
        OutputView.printlnResult(COMPLETE_REMOVAL);
    }

    private static String inputRepresentation() {
        OutputView.printGuide(INPUT_REPRESENTATION);
        return InputView.readLine();
    }
}
