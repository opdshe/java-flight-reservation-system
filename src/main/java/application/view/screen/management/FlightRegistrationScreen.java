package application.view.screen.management;

import application.controller.ManagementController;
import application.view.InputView;
import application.view.OutputView;

public class FlightRegistrationScreen {
    private static final String INPUT_FLIGHT_ID = "항공편 ID를 입력해 주세요. ";
    private static final String INPUT_DEPARTURE_AIRPORT_REPRESENTATION = "출발하는 공항의 축악어를 입력해 주세요. ";
    private static final String INPUT_ARRIVAL_AIRPORT_REPRESENTATION = "도착하는 공항의 축악어를 입력해 주세요. ";
    private static final String INPUT_DEPARTURE_TIME = "출발 시간을 입력해 주세요. ";
    private static final String INPUT_ARRIVAL_TIME = "도착 시간을 입력해 주세요. ";
    private static final String INPUT_PRICE = "항공편 가격을 입력해 주세요.";
    private static final String COMPLETE_REGISTRATION = "항공편이 등록되었습니다. ";

    public static void interact() {
        int flightId = inputFlightId();
        String departureRepresentation = inputDepartureRepresentation();
        String arrivalRepresentation = inputArrivalRepresentation();
        String departureTime = inputDepartureTime();
        String arrivalTime = inputArrivalTime();
        int price = inputPrice();

        ManagementController.addFlight(flightId, departureRepresentation, arrivalRepresentation,
                departureTime, arrivalTime, price);
        OutputView.printlnResult(COMPLETE_REGISTRATION);
    }

    private static int inputFlightId() {
        OutputView.printGuide(INPUT_FLIGHT_ID);
        return Integer.parseInt(InputView.readLine());
    }

    private static String inputDepartureRepresentation() {
        OutputView.printGuide(INPUT_DEPARTURE_AIRPORT_REPRESENTATION);
        return InputView.readLine();
    }

    private static String inputArrivalRepresentation() {
        OutputView.printGuide(INPUT_ARRIVAL_AIRPORT_REPRESENTATION);
        return InputView.readLine();
    }

    private static String inputDepartureTime() {
        OutputView.printGuide(INPUT_DEPARTURE_TIME);
        return InputView.readLine();
    }

    private static String inputArrivalTime() {
        OutputView.printGuide(INPUT_ARRIVAL_TIME);
        return InputView.readLine();
    }

    private static int inputPrice() {
        OutputView.printGuide(INPUT_PRICE);
        return Integer.parseInt(InputView.readLine());
    }
}
